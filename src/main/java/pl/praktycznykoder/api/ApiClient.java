/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.api;

import com.google.gson.Gson;
import pl.praktycznykoder.api.domain.Param;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import pl.praktycznykoder.marvelapi.client.MarvelApiClient;

/**
 *
 * @author praktycznykoder.pl
 */
public class ApiClient {

    public URI buildURI(String scheme, String host, String path, 
        List<Param> params) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme(scheme);
        uriBuilder.setHost(host);
        uriBuilder.setPath(path);

        if(params != null){
            for(int i=0; i<params.size(); i++){
                uriBuilder.setParameter(
                params.get(i).getKey(), params.get(i).getValue());
            }
        }
        return uriBuilder.build();
    }
    
    public URI buildURI(String url,  List<Param> params) throws URISyntaxException{
        URIBuilder uriBuilder = new URIBuilder(url);
        if(params != null){
            for(int i=0; i<params.size(); i++){
                uriBuilder.setParameter(
                params.get(i).getKey(), params.get(i).getValue());
            }
        }
        return uriBuilder.build();
    }
    //  HttpEntity entity = response.getEntity();
    //  InputStream content =  entity.getContent();
    //  convertStreamContentToString(content)

    /**
     *
     * @param is
     * @return
     */
    public String convertStreamContentToString(InputStream is) {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
    
    public HttpResponse getResponse(String acceptHeaderType, URI uri) throws 
        URISyntaxException, ClientProtocolException, IOException {
        
        HttpGet request = new HttpGet(uri);
        request.addHeader("accept", acceptHeaderType);

        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(request);

        return response;
    }
    
    /**
     *
     * @param <Type>
     * @param jsonString
     * @param clazz
     * @return
     * @throws NullPointerException
     */
    public <Type> Type getObjectFromJsonString(String jsonString, Class<Type> clazz) throws java.lang.NullPointerException {
        try {
            Gson gson = new Gson();
            return (Type) gson.fromJson(jsonString, clazz);
        } catch (com.google.gson.JsonSyntaxException ex) {
            Logger.getLogger(MarvelApiClient.class.getName()).
                    log(Level.SEVERE, null, ex);
            System.out.println(ex.getLocalizedMessage());
        }
        return null;
    }
}
