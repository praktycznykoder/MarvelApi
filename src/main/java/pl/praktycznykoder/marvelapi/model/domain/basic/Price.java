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
public class Price {

    private String type;
    private float price;

    /**
     *
     * @param type
     * @param price
     */
    public Price(String type, float price) {
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return type + " : "+ price;
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
    public float getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(float price) {
        this.price = price;
    }    
}