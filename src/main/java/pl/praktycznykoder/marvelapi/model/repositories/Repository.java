/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.repositories;

import java.awt.image.BufferedImage;
import java.util.List;
import pl.praktycznykoder.api.domain.Param;

/**
 *
 * @author praktycznykoder.pl
 * @param <RESPONSE_TYPE>
 */
public interface Repository<RESPONSE_TYPE> {
    RESPONSE_TYPE getObjects(List<Param> params, int page);
    RESPONSE_TYPE getObjectWithId(String id);
    RESPONSE_TYPE getObjectWithUrl(String url, List<Param> params);
    BufferedImage getImage(String url);
}
