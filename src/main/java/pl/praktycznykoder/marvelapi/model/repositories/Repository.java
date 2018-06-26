/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.repositories;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import pl.praktycznykoder.api.domain.Param;

/**
 *
 * @author praktycznykoder.pl
 * @param <RESPONSE_TYPE>
 */
public interface Repository<RESPONSE_TYPE> {

    /**
     *
     * @param params
     * @param page
     * @return
     * @throws NoSuchAlgorithmException
     * @throws URISyntaxException
     * @throws IOException
     */
    RESPONSE_TYPE getObjects(List<Param> params, int page)
            throws NoSuchAlgorithmException, URISyntaxException,IOException;

    /**
     *
     * @param id
     * @return
     * @throws NoSuchAlgorithmException
     * @throws URISyntaxException
     * @throws IOException
     */
    RESPONSE_TYPE getObjectWithId(String id)
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
    RESPONSE_TYPE getObjectWithUrl(String url, List<Param> params)
            throws NoSuchAlgorithmException, URISyntaxException,IOException;

    /**
     *
     * @param url
     * @return
     * @throws IOException
     */
    BufferedImage getImage(String url) throws IOException;
}
