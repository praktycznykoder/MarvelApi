/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pl.praktycznykoder.api.domain.Param;

/**
 *
 * @author User
 */
public class MarvelApiClientTest {
    
    public MarvelApiClientTest() {
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
     * Test of getKeyHash method, of class MarvelApiClient.
     * @throws java.io.UnsupportedEncodingException
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGetKeyHash() throws UnsupportedEncodingException, 
            NoSuchAlgorithmException, FileNotFoundException, IOException {
        System.out.println("getKeyHash");
        long timestamp = 10000L;
        MarvelApiClient instance = new MarvelApiClient(
                    "API_KEY","PRIVATE_API_KEY", "ACCEPT_HEADER", "test", "test");
        String expResult = "9bcd01dfa14dc32022e95c7b0c011af2";
        String result = instance.getKeyHash(timestamp);
        assertEquals(expResult, result);
    }

    /**
     * Test of getResponseFromMarvelApi method, of class MarvelApiClient.
     */
    //@Test
    public void testGetResponseFromMarvelApi() throws Exception {
        System.out.println("getResponseFromMarvelApi");
        String path = "";
        boolean pathIsFullUrl = false;
        List<Param> params = null;
        MarvelApiClient instance = new MarvelApiClient();
        String expResult = "";
        String result = instance.getResponseFromMarvelApi(path, pathIsFullUrl, params);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}