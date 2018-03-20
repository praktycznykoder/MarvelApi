/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    public MarvelApiResponse() {
    }

    public MarvelApiResponse(String code, String status, String attributionText, String attributionHTML, String etag, Data<Type> data) {
        this.code = code;
        this.status = status;
        this.attributionText = attributionText;
        this.attributionHTML = attributionHTML;
        this.etag = etag;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public Data<Type> getData() {
        return data;
    }

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
