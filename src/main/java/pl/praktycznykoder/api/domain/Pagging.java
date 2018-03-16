/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.api.domain;

/**
 *
 * @author praktycznykoder.pl
 */
public class Pagging {
    private int offset;
    private int total;

    public Pagging(int offset, int total) {
        super();
        this.offset = offset;
        this.total = total;
    }

    public int getOffset() {
            return offset;
    }
    public void setOffset(int offset) {
            this.offset = offset;
    }
    public int getTotal() {
            return total;
    }
    public void setTotal(int total) {
            this.total = total;
    }
}