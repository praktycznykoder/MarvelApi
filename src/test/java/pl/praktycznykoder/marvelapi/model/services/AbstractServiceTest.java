/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.services;

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
import pl.praktycznykoder.api.domain.Param;
import pl.praktycznykoder.marvelapi.model.domain.Comics;
import pl.praktycznykoder.marvelapi.model.repositories.ComicsAbstractRepositoryImpl;
import pl.praktycznykoder.marvelapi.model.repositories.Repository;

/**
 *
 * @author User
 */
public class AbstractServiceTest {
    
    public AbstractServiceTest() {
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
     * Test of getObjectWithUrl method, of class AbstractService.
     */
    @Test
    public void testGetObjectWithUrl() throws NoSuchAlgorithmException, URISyntaxException, IOException {
        System.out.println("getObjectWithUrl");
        String url = "http://gateway.marvel.com/v1/public/comics/57868";
        List<Param> params = null;
        AbstractService instance = new AbstractServiceImpl();
        Class<?> expResult = Comics.class;
        Class<?> result = instance.getObjectWithUrl(url, params).getClass();
        assertEquals(expResult, result);
    }

    /**
     * Test of getObjectWithId method, of class AbstractService.
     */
    @Test
    public void testGetObjectWithId() throws NoSuchAlgorithmException, URISyntaxException, IOException {
        System.out.println("getObjectWithId");
        String id = "57868";
        AbstractService instance = new AbstractServiceImpl();
        Class<?> expResult = Comics.class;
        Class<?> result = instance.getObjectWithId(id).getClass();
        assertEquals(expResult, result);
    }

    /**
     * Test of getObjects method, of class AbstractService.
     */
    @Test
    public void testGetObjects() throws NoSuchAlgorithmException, URISyntaxException, IOException {
        System.out.println("getObjects");
        List<Param> params = null;
        int page = 0;
        AbstractService instance = new AbstractServiceImpl();
        Class<?> expResult = Comics.class;
        Class<?> result = instance.getObjects(params, page).get(0).getClass();
        assertEquals(expResult, result);
    }

    public class AbstractServiceImpl extends AbstractService<Comics> {

        @Override
        protected Repository getRepository() {
            return new ComicsAbstractRepositoryImpl();
        }        
    }    
}
