/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.domain.basic;

/**
 *
 * @author praktycznykoder.pl
 */
public class Image {
    
    /**
     *
     */
    public String path;

    /**
     *
     */
    public String extension;

    /**
     *
     * @param path
     * @param extension
     */
    public Image(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }
    
    @Override
    public String toString() {
        return path+"."+extension;
    }  
}
