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
import java.util.Date;
import org.igo.entities.GameMove;
import org.igo.entities.MoveComment;
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
public class MoveCommentTest {
    
    public MoveCommentTest() {
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
     * Test of getId method, of class MoveComment.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        MoveComment instance = new MoveComment();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class MoveComment.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        MoveComment instance = new MoveComment();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMoveComment method, of class MoveComment.
     */
    @Test
    public void testGetMoveComment() {
        System.out.println("getMoveComment");
        MoveComment instance = new MoveComment();
        String expResult = "";
        String result = instance.getMoveComment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMoveComment method, of class MoveComment.
     */
    @Test
    public void testSetMoveComment() {
        System.out.println("setMoveComment");
        String moveComment = "";
        MoveComment instance = new MoveComment();
        instance.setMoveComment(moveComment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPostDateTime method, of class MoveComment.
     */
    @Test
    public void testGetPostDateTime() {
        System.out.println("getPostDateTime");
        MoveComment instance = new MoveComment();
        Date expResult = null;
        Date result = instance.getPostDateTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPostDateTime method, of class MoveComment.
     */
    @Test
    public void testSetPostDateTime() {
        System.out.println("setPostDateTime");
        Date postDateTime = null;
        MoveComment instance = new MoveComment();
        instance.setPostDateTime(postDateTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGamesMoves method, of class MoveComment.
     */
    @Test
    public void testGetGamesMoves() {
        System.out.println("getGamesMoves");
        MoveComment instance = new MoveComment();
        GameMove expResult = null;
        GameMove result = instance.getGamesMoves();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGamesMoves method, of class MoveComment.
     */
    @Test
    public void testSetGamesMoves() {
        System.out.println("setGamesMoves");
        GameMove gamesMoves = null;
        MoveComment instance = new MoveComment();
        instance.setGamesMoves(gamesMoves);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMovesCommentsCollection method, of class MoveComment.
     */
    @Test
    public void testGetMovesCommentsCollection() {
        System.out.println("getMovesCommentsCollection");
        MoveComment instance = new MoveComment();
        Collection<MoveComment> expResult = null;
        Collection<MoveComment> result = instance.getMoveCommentCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMovesCommentsCollection method, of class MoveComment.
     */
    @Test
    public void testSetMovesCommentsCollection() {
        System.out.println("setMovesCommentsCollection");
        Collection<MoveComment> movesCommentsCollection = null;
        MoveComment instance = new MoveComment();
        instance.setMoveCommentCollection(movesCommentsCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInReplayToId method, of class MoveComment.
     */
    @Test
    public void testGetInReplayToId() {
        System.out.println("getInReplayToId");
        MoveComment instance = new MoveComment();
        MoveComment expResult = null;
        MoveComment result = instance.getInReplayToId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInReplayToId method, of class MoveComment.
     */
    @Test
    public void testSetInReplayToId() {
        System.out.println("setInReplayToId");
        MoveComment inReplayToId = null;
        MoveComment instance = new MoveComment();
        instance.setInReplayToId(inReplayToId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserId method, of class MoveComment.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        MoveComment instance = new MoveComment();
        GoUser expResult = null;
        GoUser result = instance.getGoUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserId method, of class MoveComment.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        GoUser userId = null;
        MoveComment instance = new MoveComment();
        instance.setGoUser(userId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class MoveComment.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        MoveComment instance = new MoveComment();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class MoveComment.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        MoveComment instance = new MoveComment();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class MoveComment.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MoveComment instance = new MoveComment();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
