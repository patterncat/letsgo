/*
 * Copyright (C) 2016 surzhin.konstantin
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

import org.igo.entities.Place;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author surzhin.konstantin
 */
public class PlaceTest {
    
    public PlaceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Place.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Place instance = new Place();
        Long expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Place.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        Place instance = new Place();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlaceName method, of class Place.
     */
    @Test
    public void testGetPlaceName() {
        System.out.println("getPlaceName");
        Place instance = new Place();
        String expResult = "";
        String result = instance.getPlaceName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlaceName method, of class Place.
     */
    @Test
    public void testSetPlaceName() {
        System.out.println("setPlaceName");
        String placeName = "";
        Place instance = new Place();
        instance.setPlaceName(placeName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Place.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Place instance = new Place();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Place.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Place instance = new Place();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Place.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Place instance = new Place();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
