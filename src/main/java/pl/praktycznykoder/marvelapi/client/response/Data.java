/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.client.response;

import java.util.Arrays;

/**
 *
 * @author praktycznykoder.pl
 * @param <Type>
 */
public class Data<Type> {
    
    private int offset;
    private int total;
    private Type[] results;
    private int count;
    private int limit;

    public Data(int offset, int total, Type[] results, int count, int limit) {
        this.offset = offset;
        this.total = total;
        this.results = results;
        this.count = count;
        this.limit = limit;
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

    public Type[] getResults() {
        return results;
    }

    public void setResults(Type[] results) {
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "Data{" + "offset=" + offset + ", total=" + total + 
            ", results=" + Arrays.toString(results) + ", count=" + count + ", limit=" + limit + '}';
    }
}
