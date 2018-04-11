/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import pl.praktycznykoder.marvelapi.model.repositories.Repository;
import pl.praktycznykoder.marvelapi.model.domain.Character;

/**
 *
 * @author praktycznykoder.pl
 */
public class CharacterAbstractServiceImplTest {
    
    public CharacterAbstractServiceImplTest() {
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
     * Test of getObjectWithId method, of class CharacterAbstractServiceImpl
     * extends from AbstractService.
     */
    @Test
    public void testGetObjectWithId() throws NoSuchAlgorithmException, URISyntaxException, IOException{        
        System.out.println("getObjectWithId");
        String id = "1017100";
        
        CharacterAbstractServiceImpl instance = 
                new CharacterAbstractServiceImpl();
        
        Character result = instance.getObjectWithId(id);
        assertNotNull(result);
        assertEquals(id, result.getId()+"");
    }
    /**
     * Test of getRepository method, of class CharacterAbstractServiceImpl.
     */
    @Ignore
    @Test
    public void testGetRepository() {
        System.out.println("getRepository");
        CharacterAbstractServiceImpl instance = new CharacterAbstractServiceImpl();
        Repository expResult = null;
        Repository result = instance.getRepository();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
