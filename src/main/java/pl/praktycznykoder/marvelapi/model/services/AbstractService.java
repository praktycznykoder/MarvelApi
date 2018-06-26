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
import pl.praktycznykoder.marvelapi.client.response.MarvelApiResponse;
import pl.praktycznykoder.marvelapi.model.repositories.Repository;

/**
 *
 * @author praktycznykoder.pl
 * @param <OBJECT_TYPE>
 */
public abstract class AbstractService<OBJECT_TYPE> implements Service<OBJECT_TYPE> {

    /**
     *
     * @return
     */
    protected abstract Repository<MarvelApiResponse> getRepository();
    
    /**
     *
     * @param url
     * @param params
     * @return
     * @throws NoSuchAlgorithmException
     * @throws URISyntaxException
     * @throws IOException
     */
    @Override
    public OBJECT_TYPE getObjectWithUrl(String url, List<Param> params)
            throws NoSuchAlgorithmException, URISyntaxException,IOException {
        MarvelApiResponse mar = getRepository().getObjectWithUrl(url, params);
        return (OBJECT_TYPE) mar.getData().getResults()[0];
    }

    /**
     *
     * @param id
     * @return
     * @throws NoSuchAlgorithmException
     * @throws URISyntaxException
     * @throws IOException
     */
    @Override
    public OBJECT_TYPE getObjectWithId(String id)
            throws NoSuchAlgorithmException, URISyntaxException,IOException {
        MarvelApiResponse mar = getRepository().getObjectWithId(id);
        return (OBJECT_TYPE) mar.getData().getResults()[0];
    }

    /**
     *
     * @param params
     * @param page
     * @return
     * @throws NoSuchAlgorithmException
     * @throws URISyntaxException
     * @throws IOException
     */
    @Override
    public Data getData(List<Param> params, int page)
            throws NoSuchAlgorithmException, URISyntaxException,IOException {
        return getRepository().getObjects(params, page).getData();
    }

//    @Override
//    public Pagging getPaggingFromData(Data data) {
//        return new Pagging(data.getOffset(), data.getLimit(), data.getTotal());
//    }
//
//    @Override
//    public List<OBJECT_TYPE> getObjectsFromData(Data data) {
//        return (List<OBJECT_TYPE>) Arrays.asList(data.getResults());
//    }

    /**
     *
     * @param url
     * @return
     * @throws IOException
     */

    @Override
    public BufferedImage getImage(String url) throws IOException {
        return getRepository().getImage(url);
    }

    /**
     *
     * @return
     */
    @Override
    public String[] getThreeBooleanState() {
        return new String[]{"true", "false"};
    }
}
