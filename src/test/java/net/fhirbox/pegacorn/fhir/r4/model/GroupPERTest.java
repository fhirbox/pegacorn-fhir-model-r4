/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fhirbox.pegacorn.fhir.r4.model;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.parser.IParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hl7.fhir.r4.model.Group;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Reference;
import org.json.JSONException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ACT Health
 */
public class GroupPERTest
{

    public GroupPERTest()
    {
    }

    /**
     * Test of hasPredecessorGroup method, of class GroupPER.
     *
    @Test
    public void testHasPredecessorGroup()
    {
        System.out.println("hasPredecessorGroup");
        GroupPER instance = new GroupPER();
        boolean expResult = false;
        boolean result = instance.hasPredecessorGroup();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPredecessorGroup method, of class GroupPER.
     *
    @Test
    public void testGetPredecessorGroup() throws Exception
    {
        System.out.println("getPredecessorGroup");
        GroupPER instance = new GroupPER();
        Reference expResult = null;
        Reference result = instance.getPredecessorGroup();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPredecessorGroup method, of class GroupPER.
     *
    @Test
    public void testSetPredecessorGroup()
    {
        System.out.println("setPredecessorGroup");
        Reference previousGroup = null;
        GroupPER instance = new GroupPER();
        instance.setPredecessorGroup(previousGroup);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasJoinRule method, of class GroupPER.
     *
    @Test
    public void testHasJoinRule()
    {
        System.out.println("hasJoinRule");
        GroupPER instance = new GroupPER();
        boolean expResult = false;
        boolean result = instance.hasJoinRule();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJoinRule method, of class GroupPER.
     *
    @Test
    public void testGetJoinRule() throws Exception
    {
        System.out.println("getJoinRule");
        GroupPER instance = new GroupPER();
        Integer expResult = null;
        Integer result = instance.getJoinRule();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJoinRule method, of class GroupPER.
     *
    @Test
    public void testSetJoinRule()
    {
        System.out.println("setJoinRule");
        Integer newPriority = null;
        GroupPER instance = new GroupPER();
        instance.setJoinRule(newPriority);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasGroupPriority method, of class GroupPER.
     *
    @Test
    public void testHasGroupPriority()
    {
        System.out.println("hasGroupPriority");
        GroupPER instance = new GroupPER();
        boolean expResult = false;
        boolean result = instance.hasGroupPriority();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGroupPriority method, of class GroupPER.
     *
    @Test
    public void testGetGroupPriority() throws Exception
    {
        System.out.println("getGroupPriority");
        GroupPER instance = new GroupPER();
        Integer expResult = null;
        Integer result = instance.getGroupPriority();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGroupPriority method, of class GroupPER.
     *
    @Test
    public void testSetGroupPriority()
    {
        System.out.println("setGroupPriority");
        Integer newPriority = null;
        GroupPER instance = new GroupPER();
        instance.setGroupPriority(newPriority);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeExtension method, of class GroupPER.
     *
    @Test
    public void testRemoveExtension()
    {
        System.out.println("removeExtension");
        String url = "";
        GroupPER instance = new GroupPER();
        instance.removeExtension(url);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    @Test
    public void testToJSON()
    {
        // Transformation to/from Group/JSONObject
        FhirContext ctx = FhirContext.forR4();
        ctx.registerCustomType(GroupPER.class);
        GroupPER newGroup = new GroupPER();
        newGroup.setGroupPriority(5);
        Identifier newID = new Identifier();
        newID.setValue("TestId");
        newGroup.addIdentifier(newID);
        IParser parser = ctx.newJsonParser();
//        Group nativeGroup = (Group)(newGroup);
        System.out.println("Object Type = " + newGroup.getClass());
        String newGroupString = parser.encodeResourceToString(newGroup);
        System.out.println(newGroupString);
        
        GroupPER recodedGroupPER = parser.parseResource(GroupPER.class, newGroupString);
        System.out.println("Recoded Object = " + recodedGroupPER.toString());

        assertTrue(true);
    }

}
