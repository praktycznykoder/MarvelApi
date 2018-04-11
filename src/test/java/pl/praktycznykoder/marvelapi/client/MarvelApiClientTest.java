/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import pl.praktycznykoder.api.domain.Param;

/**
 *
 * @author praktycznykoder.pl
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
    @Ignore
    @Test
    public void testGetKeyHash() throws UnsupportedEncodingException, 
            NoSuchAlgorithmException, FileNotFoundException, IOException {
        System.out.println("getKeyHash");
        long timestamp = 10000L;
        MarvelApiClient instance = new MarvelApiClient(
                    "API_KEY","PRIVATE_API_KEY", "ACCEPT_HEADER", "test", "test", 10);
        String expResult = "9bcd01dfa14dc32022e95c7b0c011af2";
        String result = instance.getKeyHash(timestamp);
        assertEquals(expResult, result);
    }

    /**
     * Test of getResponseFromMarvelApi method, of class MarvelApiClient.
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.io.IOException
     * @throws java.io.UnsupportedEncodingException
     * @throws java.net.URISyntaxException
     */
    @Ignore
    @Test
    public void testGetResponseFromMarvelApi() throws NoSuchAlgorithmException,
                IOException, UnsupportedEncodingException, URISyntaxException {
        System.out.println("getResponseFromMarvelApi");
        String path = null;
        boolean pathIsFullUrl = false;
        List<Param> params = null;
        MarvelApiClient instance = new MarvelApiClient();
        String result = instance.getResponseFromMarvelApi(
                path, pathIsFullUrl, params);
        assertNotNull(result);
    }

    /**
     * Test of getPaggingResponseFromMarvelApi method, of class MarvelApiClient.
     */
    @Ignore
    @Test
    public void testGetPaggingResponseFromMarvelApi() throws Exception {
        System.out.println("getPaggingResponseFromMarvelApi");
        String path = null;
        boolean pathIsFullUrl = false;
        List<Param> params = null;
        int page = 0;
        MarvelApiClient instance = new MarvelApiClient();
        String result = instance.getPaggingResponseFromMarvelApi(path, pathIsFullUrl, params, page);
        assertNotNull(result);
    }    

    /**
     * Test of getRESULT_LIMIT method, of class MarvelApiClient.
     */
    @Ignore
    @Test
    public void testGetRESULT_LIMIT() {
        System.out.println("getRESULT_LIMIT");
        MarvelApiClient instance = new MarvelApiClient();
        int expResult = 0;
        int result = instance.getRESULT_LIMIT();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRESULT_LIMIT method, of class MarvelApiClient.
     */
    @Ignore
    @Test
    public void testSetRESULT_LIMIT() {
        System.out.println("setRESULT_LIMIT");
        int RESULT_LIMIT = 0;
        MarvelApiClient instance = new MarvelApiClient();
        instance.setRESULT_LIMIT(RESULT_LIMIT);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProps method, of class MarvelApiClient.
     */
    @Test
    public void testGetProps() throws IOException {
        System.out.println("getProps");
        MarvelApiClient instance = new MarvelApiClient();
        Properties expResult = null;
        Properties result = instance.getProps();
        assertNotNull(result);
    }

    /**
     * Test of getAPI_KEY method, of class MarvelApiClient.
     */
    @Test
    @Ignore
    public void testGetAPI_KEY() {
        System.out.println("getAPI_KEY");
        MarvelApiClient instance = new MarvelApiClient();
        String expResult = "";
        String result = instance.getAPI_KEY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getACCEPT_HEADER method, of class MarvelApiClient.
     */
    @Test
    @Ignore
    public void testGetACCEPT_HEADER() {
        System.out.println("getACCEPT_HEADER");
        MarvelApiClient instance = new MarvelApiClient();
        String expResult = "";
        String result = instance.getACCEPT_HEADER();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSHEME method, of class MarvelApiClient.
     */
    @Test
    @Ignore
    public void testGetSHEME() {
        System.out.println("getSHEME");
        MarvelApiClient instance = new MarvelApiClient();
        String expResult = "";
        String result = instance.getSHEME();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHOST method, of class MarvelApiClient.
     */
    @Test
    @Ignore
    public void testGetHOST() {
        System.out.println("getHOST");
        MarvelApiClient instance = new MarvelApiClient();
        String expResult = "";
        String result = instance.getHOST();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}