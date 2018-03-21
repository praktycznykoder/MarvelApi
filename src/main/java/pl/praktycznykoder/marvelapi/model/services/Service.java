/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.services;

import java.awt.image.BufferedImage;
import java.util.List;
import pl.praktycznykoder.api.domain.Param;

/**
 *
 * @author praktycznykoder.pl
 * @param <OBJECT_TYPE>
 */
public interface Service<OBJECT_TYPE> {
    List<OBJECT_TYPE> getObjects(List<Param> params, int page);
    OBJECT_TYPE getObjectWithId(String id);
    OBJECT_TYPE getObjectWithUrl(String url, List<Param> params);
    BufferedImage getImage(String url);
}
