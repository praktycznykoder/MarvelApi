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

/**
 *
 * @author praktycznykoder.pl
 * @param <Type>
 */
public abstract class MarvelApiResponse<Type> {
    private String code;
    private String status;
    private String attributionText;
    private String attributionHTML;
    private String etag;
    private Data<Type> data;

    /**
     *
     */
    public MarvelApiResponse() {
    }

    /**
     *
     * @param code
     * @param status
     * @param attributionText
     * @param attributionHTML
     * @param etag
     * @param data
     */
    public MarvelApiResponse(String code, String status, String attributionText, String attributionHTML, String etag, Data<Type> data) {
        this.code = code;
        this.status = status;
        this.attributionText = attributionText;
        this.attributionHTML = attributionHTML;
        this.etag = etag;
        this.data = data;
    }

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public String getAttributionText() {
        return attributionText;
    }

    /**
     *
     * @param attributionText
     */
    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    /**
     *
     * @return
     */
    public String getAttributionHTML() {
        return attributionHTML;
    }

    /**
     *
     * @param attributionHTML
     */
    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    /**
     *
     * @return
     */
    public String getEtag() {
        return etag;
    }

    /**
     *
     * @param etag
     */
    public void setEtag(String etag) {
        this.etag = etag;
    }

    /**
     *
     * @return
     */
    public Data<Type> getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(Data<Type> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MarvelApiResponse{" + "code=" + code + ", status=" + status + 
            ", attributionText=" + attributionText + ", attributionHTML=" + 
            attributionHTML + ", etag=" + etag + ", data=" + data + '}';
    }
}
