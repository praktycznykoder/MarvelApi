/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.api;

/**
 *
 * @author praktycznykoder.pl
 */
public class TestJson {
    
    public String id;
    public String text;

    public TestJson(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TestJson{" + "id=" + id + ", text=" + text + '}';
    }

    @Override
    public boolean equals(Object obj) {
        TestJson testJson = (TestJson) obj;
        return id.equals(testJson.id) && text.equals(testJson.text);
    }
}
