/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.domain;

/**
 *
 * @author praktycznykoder.pl
 * 
 */
public class TextObject {
    private String type;
    private String language;
    private String text;

    /**
     *
     * @param type
     * @param language
     * @param text
     */
    public TextObject(String type, String language, String text) {
        this.type = type;
        this.language = language;
        this.text = text;
    }

    @Override
    public String toString() {
        return "type: " + type + " | language: " + language + " | " + text;
    }
    
    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public String getLanguage() {
        return language;
    }

    /**
     *
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     *
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }
    
}
