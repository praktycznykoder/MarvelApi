/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.api.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author praktycznykoder.pl
 */
public class Pagging {
    private int offset;    
    private int limit ;
    private int total;

    public Pagging() {
    
    }

    public Collection toParams() {
        List<Param> params = new ArrayList<>();
        params.add(new Param("offset", offset+""));
        params.add(new Param("limit", limit+""));
        return params;
    }
    
    public int nextPage(){
        return 0;
    }
    public int previousPage(){
        return 0;
    }    
    public int lastPage(){
        return 0;
    }
    
    public Pagging(int offset, int limit, int total) {
        this.offset = offset;
        this.limit = limit;
        this.total = total;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
