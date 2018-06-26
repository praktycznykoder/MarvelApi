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
package pl.praktycznykoder.api;

import com.google.gson.Gson;
import java.awt.image.BufferedImage;
import pl.praktycznykoder.api.domain.Param;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
 * This class containing the basic API methods
 */
public class ApiClient {
    
    /**
     *
     * @param urlString
     * @return
     * @throws IOException
     */
    public BufferedImage getImage(String urlString) throws IOException{
        URL url = new URL(urlString);
        return ImageIO.read(url);
    }

    /**
     *
     * @param scheme
     * @param host
     * @param path
     * @param params
     * @return
     * @throws URISyntaxException
     */
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
    
    /**
     *
     * @param url
     * @param params
     * @return
     * @throws URISyntaxException
     */
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
    /**
     *
     * @param is
     * @return
     */
    public String convertStreamContentToString(InputStream is) {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(is,"UTF-8").useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
    
    /**
     *
     * @param acceptHeaderType
     * @param uri
     * @return
     * @throws URISyntaxException
     * @throws ClientProtocolException
     * @throws IOException
     */
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
