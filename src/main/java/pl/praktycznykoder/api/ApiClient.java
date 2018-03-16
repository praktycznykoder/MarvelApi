/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.api;

import java.io.FileNotFoundException;
import java.io.FileReader;
import pl.praktycznykoder.api.domain.Param;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author praktycznykoder.pl
 */
public class ApiClient {
    
    ApiClient() throws FileNotFoundException, IOException {  
        init();
    }
    
    private void init() throws FileNotFoundException, IOException {        
        Properties props = getProps();
        SHEME = props.getProperty("sheme");
        HOST = props.getProperty("host");
        ACCEPT_HEADER = props.getProperty("acceptheader");
        API_KEY = props.getProperty("apikey");
        PRIVATE_API_KEY = props.getProperty("privateapikey");
    }
    
    private Properties getProps() throws FileNotFoundException, IOException  {
        Properties props = new Properties();
        FileReader file;
        file = new FileReader(
                "src\\main\\resources\\properties\\api-connect.properties");
        props.load(file);
        return props;
    }
    //insert to marvel api param class  - Start
    public String API_KEY;
    public String PRIVATE_API_KEY;
    public String ACCEPT_HEADER;

    public String SHEME;
    public String HOST;
    
    public String getTimestamp(Date date){
        return date.getTime() +"";
    }
    public String getKeyHash(Date date) throws
        UnsupportedEncodingException, NoSuchAlgorithmException {
        String stringToHash = 
            getTimestamp(date) + PRIVATE_API_KEY + API_KEY;
        byte[] bytesOfMessage = stringToHash.getBytes("UTF-8");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(bytesOfMessage);
        
        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
        while(hashtext.length() < 32 ){
          hashtext = "0"+ hashtext;
        }
        return hashtext;
    }
    
    //insert to marvel api param class  - End
    
    
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
    
    private String convertStreamToString(InputStream is) {
        @SuppressWarnings("resource")
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
    
    public String getRequest(String acceptHeaderType, String scheme, 
        String host, String path, List<Param> params) throws 
        URISyntaxException, ClientProtocolException, IOException {
        
        HttpGet request = new HttpGet(
            this.buildURI(scheme, host, path, params));
        request.addHeader("accept", acceptHeaderType);

        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(request);

        HttpEntity entity = response.getEntity();
        InputStream content =  entity.getContent();

        return convertStreamToString(content);
    }
	
    public String getRequest(String acceptHeaderType, String url,
        List<Param> params) throws URISyntaxException, ClientProtocolException, 
            IOException {

        HttpGet request = new HttpGet(
        this.buildURI(url, params));

        request.addHeader("accept", acceptHeaderType);

        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(request);

        HttpEntity entity = response.getEntity();
        InputStream content =  entity.getContent();

        return convertStreamToString(content);
    }
}
