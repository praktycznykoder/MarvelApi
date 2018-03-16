/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.api;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.time.Clock;
import java.util.ArrayList;
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
public class ApiClientTest {
    
    public ApiClientTest() {
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
     * Test of getTimestamp method, of class ApiClient.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGetTimestamp() throws FileNotFoundException {
        System.out.println("getTimestamp");
        Date date = new Date();
        // set the time for 10000 milliseconds after
        // january 1, 1970 00:00:00 gmt.
        date.setTime(10000);
        ApiClient instance = new ApiClient();
        String expResult = "10000";
        String result = instance.getTimestamp(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of getHash method, of class ApiClient.
     * @throws java.io.UnsupportedEncodingException
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.io.FileNotFoundException
     */
    //@Test
    public void testGetKeyHash() throws UnsupportedEncodingException, NoSuchAlgorithmException, FileNotFoundException {
        System.out.println("getHash");
        ApiClient instance = new ApiClient();
        String expResult = "";
        String result = instance.getKeyHash(new Date(10000));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buildURI method, of class ApiClient.
     */
    //@Test
    public void testBuildURI_4args() throws Exception {
        System.out.println("buildURI");
        String scheme = "";
        String host = "";
        String path = "";
        List<Param> params = null;
        ApiClient instance = new ApiClient();
        URI expResult = null;
        URI result = instance.buildURI(scheme, host, path, params);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buildURI method, of class ApiClient.
     * @throws java.lang.Exception
     */
    @Test
    public void testBuildURI_String_List() throws Exception {
        System.out.println("buildURI");
        
        ApiClient instance = new ApiClient();
        String url = instance.SHEME+"://"+instance.HOST;
        Date date = new Date();
        String timestamp = instance.getTimestamp(date);
        
        List<Param> params = new ArrayList();
        params.add(new Param("ts", timestamp));
        params.add(new Param("apikey", instance.API_KEY));
        params.add(new Param("hash", instance.getKeyHash(date)));
        
        String expResult = url+
            "/?ts="+ timestamp+
            "&apikey="+ instance.API_KEY+
            "&hash="+instance.getKeyHash(date);
        
        
        URI result = instance.buildURI(url, params);
        
        System.out.println(expResult);
        System.out.println(result.toString());
        assertEquals(expResult, result.toString());
    }

    /**
     * Test of getRequest method, of class ApiClient.
     */
    //@Test
    public void testGetRequest_5args() throws Exception {
        System.out.println("getRequest");
        String acceptHeaderType = "";
        String scheme = "";
        String host = "";
        String path = "";
        List<Param> params = null;
        ApiClient instance = new ApiClient();
        String expResult = "";
        String result = instance.getRequest(acceptHeaderType, scheme, host, path, params);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRequest method, of class ApiClient.
     */
    //@Test
    public void testGetRequest_3args() throws Exception {
        System.out.println("getRequest");
        String acceptHeaderType = "";
        String url = "";
        List<Param> params = null;
        ApiClient instance = new ApiClient();
        String expResult = "";
        String result = instance.getRequest(acceptHeaderType, url, params);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
