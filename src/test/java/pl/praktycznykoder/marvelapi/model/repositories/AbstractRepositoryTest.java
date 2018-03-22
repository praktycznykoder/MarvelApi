/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.repositories;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import pl.praktycznykoder.api.domain.Param;
import pl.praktycznykoder.marvelapi.client.MarvelApiClient;
import pl.praktycznykoder.marvelapi.client.response.ComicsMarvelApiResponse;

/**
 *
 * @author User
 */
public class AbstractRepositoryTest {
    
    public AbstractRepositoryTest() {
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
     * Test of getClient method, of class AbstractRepository.
     */
    @Ignore
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        AbstractRepository instance = new AbstractRepositoryImpl();
        MarvelApiClient expResult = null;
        MarvelApiClient result = instance.getClient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPath method, of class AbstractRepository.
     */
    @Ignore
    @Test
    public void testGetPath() {
        System.out.println("getPath");
        AbstractRepository instance = new AbstractRepositoryImpl();
        String expResult = "";
        String result = instance.getPath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClazz method, of class AbstractRepository.
     */
    @Ignore
    @Test
    public void testGetClazz() {
        System.out.println("getClazz");
        AbstractRepository instance = new AbstractRepositoryImpl();
        Class expResult = null;
        Class result = instance.getClazz();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResultLimit method, of class AbstractRepository.
     */
    @Ignore
    @Test
    public void testSetResultLimit() {
        System.out.println("setResultLimit");
        int resultLimit = 0;
        AbstractRepository instance = new AbstractRepositoryImpl();
        instance.setResultLimit(resultLimit);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObjects method, of class AbstractRepository.
     */
    @Test
    public void testGetObjects() throws NoSuchAlgorithmException, URISyntaxException, IOException {
        System.out.println("getObjects");        
        List params = null;
        int resultLimit = 10;
        
        ComicsAbstractRepositoryImpl instance = new ComicsAbstractRepositoryImpl();
        instance.setResultLimit(resultLimit);
        
        //test with pagging
        int maxPage = 1;
        for(int page=0; page<maxPage; page++){            
            ComicsMarvelApiResponse result = instance.getObjects(params, page);
            int length = result.getData().getResults().length;
            assertNotEquals(0, length);        
            assertEquals(resultLimit*page, result.getData().getOffset());
            assertEquals(length, result.getData().getCount());
            assertEquals("Ok", result.getStatus());
        }        
    }

    /**
     * Test of getObjectWithId method, of class AbstractRepository.
     */
    @Test
    public void testGetObjectWithId() throws NoSuchAlgorithmException, URISyntaxException, IOException {
        System.out.println("getObjectWithId");
        String id = "59533";
        ComicsAbstractRepositoryImpl instance = new ComicsAbstractRepositoryImpl();
        int expResult = 59533;
        int expResultLength = 1;
        ComicsMarvelApiResponse result = instance.getObjectWithId(id);
        
        int length = result.getData().getResults().length;
        int resultId = result.getData().getResults()[0].getId();
        
        assertEquals(expResultLength, length);        
        assertEquals(expResult, resultId);
        assertEquals("Ok", result.getStatus());
    }

    /**
     * Test of getObjectWithUrl method, of class AbstractRepository.
     */
    @Test
    public void testGetObjectWithUrl() throws NoSuchAlgorithmException, URISyntaxException, IOException {
        System.out.println("getObjectWithUrl");
        String url = "http://gateway.marvel.com/v1/public/comics/57868";
        List params = null;
        ComicsAbstractRepositoryImpl instance = new ComicsAbstractRepositoryImpl();
        int expResult = 57868;
        int expResultLength = 1;
        ComicsMarvelApiResponse result = instance.getObjectWithUrl(url, params);
        
        int length = result.getData().getResults().length;
        int resultId = result.getData().getResults()[0].getId();
        
        assertEquals(expResultLength, length);        
        assertEquals(expResult, resultId);
        assertEquals("Ok", result.getStatus());
    }

    public class AbstractRepositoryImpl extends AbstractRepository<ComicsMarvelApiResponse> {

        private final MarvelApiClient client = new MarvelApiClient();
        private final String path = "v1/public/comics";

        @Override
        protected MarvelApiClient getClient() {
            return client;
        }
        @Override
        protected String getPath() {
            return path;
        }

        @Override
        protected Class<?> getClazz() {
            return ComicsMarvelApiResponse.class;
        }
    }
    
}
