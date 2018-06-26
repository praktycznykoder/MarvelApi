/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.services;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import pl.praktycznykoder.api.domain.Param;
import pl.praktycznykoder.marvelapi.client.response.Data;

/**
 *
 * @author praktycznykoder.pl
 * @param <OBJECT_TYPE>
 */
public interface Service<OBJECT_TYPE> {

    /**
     *
     * @param params
     * @param page
     * @return
     * @throws NoSuchAlgorithmException
     * @throws URISyntaxException
     * @throws IOException
     */
    Data getData(List<Param> params, int page)
            throws NoSuchAlgorithmException, URISyntaxException,IOException;
    
//    Pagging getPaggingFromData(Data data);
//    List<OBJECT_TYPE> getObjectsFromData(Data data);

    /**
     *
     * @param id
     * @return
     * @throws NoSuchAlgorithmException
     * @throws URISyntaxException
     * @throws IOException
     */
    
    OBJECT_TYPE getObjectWithId(String id)
            throws NoSuchAlgorithmException, URISyntaxException,IOException;

    /**
     *
     * @param url
     * @param params
     * @return
     * @throws NoSuchAlgorithmException
     * @throws URISyntaxException
     * @throws IOException
     */
    OBJECT_TYPE getObjectWithUrl(String url, List<Param> params)
            throws NoSuchAlgorithmException, URISyntaxException,IOException;

    /**
     *
     * @param url
     * @return
     * @throws IOException
     */
    BufferedImage getImage(String url) throws IOException;

    /**
     *
     * @return
     */
    String[] getOrderByParamNodes();

    /**
     *
     * @return
     */
    String[] getThreeBooleanState();
    
    
}
