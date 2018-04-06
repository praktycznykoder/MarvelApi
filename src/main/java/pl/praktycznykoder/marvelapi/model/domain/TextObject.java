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

    public TextObject(String type, String language, String text) {
        this.type = type;
        this.language = language;
        this.text = text;
    }

    @Override
    public String toString() {
        return "type: " + type + " | language: " + language + " | " + text;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
