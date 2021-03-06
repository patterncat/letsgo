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

import java.util.Collection;
import org.igo.entities.Room;
import org.igo.entities.GoUser;
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
public class RoomTest {

    public RoomTest() {
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
     * Test of getId method, of class Room.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Room instance = new Room();
        Short expResult = null;
        Short result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Room.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
         Short id = null;
        Room instance = new Room();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoomName method, of class Room.
     */
    @Test
    public void testGetRoomName() {
        System.out.println("getRoomName");
        Room instance = new Room();
        String expResult = "";
        String result = instance.getRoomName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoomName method, of class Room.
     */
    @Test
    public void testSetRoomName() {
        System.out.println("setRoomName");
        String roomName = "";
        Room instance = new Room();
        instance.setRoomName(roomName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersCollection method, of class Room.
     */
    @Test
    public void testGetUsersCollection() {
        System.out.println("getUsersCollection");
        Room instance = new Room();
        Collection<GoUser> expResult = null;
        Collection<GoUser> result = instance.getUsersCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersCollection method, of class Room.
     */
    @Test
    public void testSetUsersCollection() {
        System.out.println("setUsersCollection");
        Collection<GoUser> usersCollection = null;
        Room instance = new Room();
        instance.setUsersCollection(usersCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Room.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Room instance = new Room();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Room.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Room instance = new Room();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Room.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Room instance = new Room();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
