/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.repositories;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.praktycznykoder.api.domain.Pagging;
import pl.praktycznykoder.api.domain.Param;
import pl.praktycznykoder.marvelapi.client.MarvelApiClient;
import pl.praktycznykoder.marvelapi.client.response.ComicsMarvelApiResponse;
import pl.praktycznykoder.marvelapi.client.response.MarvelApiResponse;
import pl.praktycznykoder.marvelapi.model.domain.Comics;

/**
 *
 * @author praktycznykoder.pl
 */
public class ComicsRepository implements Repository<Comics> {
    
    private final MarvelApiClient client = new MarvelApiClient();
    private final String path = "v1/public/comics";
    
    @Override
    public MarvelApiResponse<Comics> getObjects(List params,int page) {
        try {
            return client.getObjectFromJsonString(
                client.getPaggingResponseFromMarvelApi(
                        path, false, params, page), ComicsMarvelApiResponse.class);
        } catch (NoSuchAlgorithmException | URISyntaxException | IOException ex) {
            Logger.getLogger(ComicsRepository.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public MarvelApiResponse<Comics> getObjectWithId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MarvelApiResponse<Comics> getObjectWithUrl(String url, List<Param> params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
