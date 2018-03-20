/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.repositories;

import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pl.praktycznykoder.api.domain.Pagging;
import pl.praktycznykoder.marvelapi.client.response.MarvelApiResponse;
import pl.praktycznykoder.marvelapi.model.domain.Comics;

/**
 *
 * @author User
 */
public class ComicsRepositoryTest {
    
    public ComicsRepositoryTest() {
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
     * Test of getObjects method, of class ComicsRepository.
     */
    @Test
    public void testGetObjects() {
        System.out.println("getObjects");
        List params = null;
        int page =0;
        
        ComicsRepository instance = new ComicsRepository();
        MarvelApiResponse<Comics> result = instance.getObjects(params, page);
        int length = result.getData().getResults().length;
        
        assertNotNull(result);
        
        
        System.out.println(result.getData().getCount());
        System.out.println(result.getData().getLimit());
        System.out.println(result.getData().getOffset());
        System.out.println(result.getData().getTotal());
        
        assertNotNull(result);
        assertEquals("Ok", result.getStatus());
    }

    /**
     * Test of getObjectWithId method, of class ComicsRepository.
     */
    //@Test
    public void testGetObjectWithId() {
        System.out.println("getObjectWithId");
        String id = "";
        List params = null;
        ComicsRepository instance = new ComicsRepository();
        Object expResult = null;
        Object result = instance.getObjectWithId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObjectWithUrl method, of class ComicsRepository.
     */
    //@Test
    public void testGetObjectWithUrl() {
        System.out.println("getObjectWithUrl");
        String url = "";
        List params = null;
        ComicsRepository instance = new ComicsRepository();
        Object expResult = null;
        Object result = instance.getObjectWithUrl(url, params);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
