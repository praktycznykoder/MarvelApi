/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.api;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.http.HttpResponse;
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
     * Test of buildURI method, of class ApiClient.
     * @throws java.io.UnsupportedEncodingException
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.net.URISyntaxException
     */
    @Test
    public void testBuildURI_4args() throws UnsupportedEncodingException, 
            NoSuchAlgorithmException, URISyntaxException {
        System.out.println("buildURI");
        
        
        String sheme = "scheme";
        String host = "host";
        String path = "path";
        String API_KEY = "testKeyApi";
        String KEY_HASH = "testKeyHash";
        
        ApiClient instance = new ApiClient();
        
        Date date = new Date();
        String timestamp = date.getTime()+"";
        String url = sheme+"://"+host+"/"+path;        
        
        List<Param> params = new ArrayList();
        params.add(new Param("ts", timestamp));
        params.add(new Param("apikey", API_KEY));
        params.add(new Param("hash", KEY_HASH));
        
        String expResult = url+
            "?ts="+ timestamp+
            "&apikey="+ API_KEY+
            "&hash="+KEY_HASH;
        
        
        URI result = instance.buildURI(sheme, host, path, params);
        
        assertEquals(expResult, result.toString());
    }

    /**
     * Test of buildURI method, of class ApiClient.
     * @throws java.io.UnsupportedEncodingException
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.net.URISyntaxException
     */
    @Test
    public void testBuildURI_String_List() throws UnsupportedEncodingException, NoSuchAlgorithmException, URISyntaxException {
        System.out.println("buildURI");
        
        String sheme = "http";
        String host = "praktycznykoder.pl";
        String path = "tests/test_api.php";
        String API_KEY = "testKeyApi";
        String KEY_HASH = "testKeyHash";
        
        ApiClient instance = new ApiClient();
        String url = sheme+"://"+host+"/"+path;
        Date date = new Date();
        String timestamp = date.getTime()+"";
        
        List<Param> params = new ArrayList();
        params.add(new Param("ts", timestamp));
        params.add(new Param("apikey", API_KEY));
        params.add(new Param("hash", KEY_HASH));
        
        String expResult = url+
            "?ts="+ timestamp+
            "&apikey="+ API_KEY+
            "&hash="+KEY_HASH;
        
        
        URI result = instance.buildURI(url, params);
        
        assertEquals(expResult, result.toString());
    }  

    /**
     * Test of convertStreamContentToString method, of class ApiClient.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testConvertStreamContentToString() throws FileNotFoundException {
        System.out.println("convertStreamContentToString");
        File initialFile = new File(
            "src\\test\\java\\pl\\praktycznykoder\\api\\testConvertInputStreamFile");
        InputStream is = new FileInputStream(initialFile);
        
        ApiClient instance = new ApiClient();
        String expResult = "test test test";
        String result = instance.convertStreamContentToString(is);
        assertEquals(expResult, result);
    }

    /**
     * Test of getResponse method, of class ApiClient.
     * @throws java.net.URISyntaxException
     * @throws java.io.IOException
     */
    @Test
    public void testGetResponse() throws URISyntaxException, IOException {
        System.out.println("getResponse");
        
        String sheme = "http";
        String host = "praktycznykoder.pl";
        String path = "tests/test_api.php";
        String acceptHeaderType = "application/json";
        ApiClient instance = new ApiClient();
        String url = sheme+"://"+host+"/"+path;
        
        List<Param> params = new ArrayList();
        params.add(new Param("password", "test2018"));       
        
        URI uri = instance.buildURI(url, params);
        HttpResponse response = instance.getResponse(acceptHeaderType, uri);
        
        int expResult = 200;
        int result = response.getStatusLine().getStatusCode();
        
        assertEquals(expResult, result);
        
        String result2 = instance.convertStreamContentToString(
                response.getEntity().getContent());
        
        String expResult2 = "pass";
        assertEquals(expResult2, result2);
    }

    /**
     * Test of getObjectFromJsonString method, of class ApiClient.
     */
    @Test
    public void testGetObjectFromJsonString() {
        System.out.println("getObjectFromJsonString");
        String jsonString = "{\"id\":\"testId\", \"text\":\"test Text\"}";
        ApiClient instance = new ApiClient();
        TestJson result = instance.
                getObjectFromJsonString(jsonString, TestJson.class);
        assertEquals(new TestJson("testId", "test Text"), result);
    }

    /**
     * Test of getImage method, of class ApiClient.
     */
    @Ignore
    @Test
    public void testGetImage() throws IOException {
        System.out.println("getImage");
        String urlString = "";
        ApiClient instance = new ApiClient();
        BufferedImage expResult = null;
        BufferedImage result = instance.getImage(urlString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
