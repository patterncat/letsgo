/*
 * Copyright (C) 2017 pl
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.igo.junit.entities;

import java.util.Arrays;
import java.util.Collection;
import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import static org.hamcrest.CoreMatchers.equalTo;
import org.igo.entities.City;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author pl
 */
@RunWith(Parameterized.class)
public class CityCacheTest {

    public CityCacheTest() {
    }

    @Parameterized.Parameter(value = 0)
    static public EntityManagerFactory emf;

    private EntityManager em;

    @Parameterized.Parameters
    public static Collection dataBaseParam() {

        final EntityManagerFactory emf0 = Persistence.createEntityManagerFactory("testGamePU_MySQL");
        final EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("testPU_PostgreSQL");
        final EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("testGamePU_H2");

        final Object[][] param = {{emf0}, {emf1}, {emf2}};

        return Arrays.asList(param);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
        if (emf != null) {
            emf.close();
        }
    }

    @Before
    public void setUp() {
        em = emf.createEntityManager();

        if (em != null) {
            final Query q = em.createQuery("DELETE FROM City");
            em.getTransaction().begin();
            q.executeUpdate();
            em.getTransaction().commit();
        }
    }

    @After
    public void tearDown() {
        if (em != null) {
            final Query q = em.createQuery("DELETE FROM City");
            em.getTransaction().begin();
            q.executeUpdate();
            em.getTransaction().commit();
            em.close();
        }
    }

    @Test
    public void testCityInCache() {
        System.out.println("CityInCache");

        final City city = new City("Москва");
        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
        assertTrue("Объекта в L1 кеше нет", em.contains(city));
        em.clear();
        assertFalse("Объекта в L1 кеше", em.contains(city));

        final City nuvoCity = em.find(City.class, city.getId());
        final Cache cache = em.getEntityManagerFactory().getCache();
        em.merge(nuvoCity);
        assertTrue("Объекта в L1 кеше нет", em.contains(nuvoCity));
        assertTrue("Объекта в L2 кеше нет", cache.contains(City.class, nuvoCity.getId()));

        cache.evict(City.class, city.getId());
        assertFalse(cache.contains(City.class, city.getId()));

    }

    @Test
    public void testUpdateCityWithNativSQLCityInCache() {
        System.out.println("UpdateCityWithNativSQLCityInCache");
        final Cache cache = em.getEntityManagerFactory().getCache();
        final City city = new City("Москва");
        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }

            try {
                em.getTransaction().begin();
                final int number = em
                        .createQuery("UPDATE City c SET c.cityName =:cityName WHERE c.id = :id")
                        .setParameter("cityName", "Новая Москва")
                        .setParameter("id", city.getId())
                        .executeUpdate();
                em.getTransaction().commit();
                assertThat(number, equalTo(1));

                final String cityFromDbTadle = em
                        .createQuery("SELECT c.cityName From City c WHERE c.id=:id", String.class)
                        .setParameter("id", city.getId())
                        .setHint("org.hibernate.readOnly", true)
                        .getSingleResult();
                assertThat(cityFromDbTadle, equalTo("Новая Москва"));
                
                assertTrue(em.contains(city));

                final City cityFromCahe = em.find(City.class, city.getId());
                
                assertThat(cityFromCahe.getCityName(), equalTo("Москва"));

                em.refresh(cityFromCahe);
                assertThat(city.getCityName(), equalTo("Новая Москва"));
                assertThat(cityFromCahe.getCityName(), equalTo("Новая Москва"));

            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }

        cache.evict(City.class, city.getId());
        assertFalse(cache.contains(City.class, city.getId()));
    }
}
