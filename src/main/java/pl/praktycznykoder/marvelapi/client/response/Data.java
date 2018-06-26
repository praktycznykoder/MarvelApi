/*
 * Copyright (C) 2018 praktycznykoder.pl
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
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
    
    /**
     *
     * @return
     */
    public int countCurrentPage(){
        return getOffset()/getLimit()+1;
    }

    /**
     *
     * @return
     */
    public int countLastPage(){
        return getTotal()/getLimit()+1;
    }

    /**
     *
     * @param offset
     * @param total
     * @param results
     * @param count
     * @param limit
     */
    public Data(int offset, int total, Type[] results, int count, int limit) {
        this.offset = offset;
        this.total = total;
        this.results = results;
        this.count = count;
        this.limit = limit;
    }
    
    /**
     *
     * @return
     */
    public int getOffset() {
        return offset;
    }

    /**
     *
     * @param offset
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     *
     * @return
     */
    public int getTotal() {
        return total;
    }

    /**
     *
     * @param total
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     *
     * @return
     */
    public Type[] getResults() {
        return results;
    }

    /**
     *
     * @param results
     */
    public void setResults(Type[] results) {
        this.results = results;
    }

    /**
     *
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     *
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     *
     * @return
     */
    public int getLimit() {
        return limit;
    }

    /**
     *
     * @param limit
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "Data{" + "offset=" + offset + ", total=" + total + 
            ", results=" + Arrays.toString(results) + ", count=" + count + ", limit=" + limit + '}';
    }
}
