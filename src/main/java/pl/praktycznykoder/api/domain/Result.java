/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.api.domain;

import java.util.List;

/**
 *
 * @author praktycznykoder
 */
public interface Result {
    //List<ObjectDataType> getObjs();
    Pagging getPaging();
}
