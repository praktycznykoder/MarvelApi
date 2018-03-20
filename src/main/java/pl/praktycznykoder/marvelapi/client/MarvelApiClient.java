/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.client;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import pl.praktycznykoder.api.ApiClient;
import pl.praktycznykoder.api.domain.Param;
import pl.praktycznykoder.marvelapi.client.response.MarvelApiResponse;
import pl.praktycznykoder.marvelapi.model.domain.Comics;

/**
 *
 * @author praktycznykoder.pl
 */
public class MarvelApiClient extends ApiClient{
    private String API_KEY;
    private String PRIVATE_API_KEY;
    private String ACCEPT_HEADER;

    private String SHEME;
    private String HOST;
    
    private int RESULT_LIMIT;

    public int getRESULT_LIMIT() {
        return RESULT_LIMIT;
    }
    public void setRESULT_LIMIT(int RESULT_LIMIT) {
        this.RESULT_LIMIT = RESULT_LIMIT;
    }
    
    

    public MarvelApiClient(String API_KEY, String PRIVATE_API_KEY, 
            String ACCEPT_HEADER, String SHEME, String HOST, int RESULT_LIMIT) {
        super();
        this.API_KEY = API_KEY;
        this.PRIVATE_API_KEY = PRIVATE_API_KEY;
        this.ACCEPT_HEADER = ACCEPT_HEADER;
        this.SHEME = SHEME;
        this.HOST = HOST;
        this.RESULT_LIMIT = RESULT_LIMIT;
    }

    public MarvelApiClient() {
        super();
        try {
            this.init();
        } catch (IOException ex) {
            Logger.getLogger(MarvelApiClient.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
    
    private Properties getProps() throws FileNotFoundException, IOException  {
        Properties props = new Properties();
        FileReader file;
        file = new FileReader(
                "src\\main\\resources\\properties\\api-connect.properties");
        props.load(file);
        return props;
    }
    
    private void init() throws FileNotFoundException, IOException {        
        Properties props = this.getProps();
        SHEME = props.getProperty("sheme");
        HOST = props.getProperty("host");
        ACCEPT_HEADER = props.getProperty("acceptheader");
        API_KEY = props.getProperty("apikey");
        PRIVATE_API_KEY = props.getProperty("privateapikey");
        RESULT_LIMIT = Integer.parseInt(props.getProperty("resultlimit"));
    }
    
    protected String getKeyHash(long timestamp) throws
        UnsupportedEncodingException, NoSuchAlgorithmException {
        String stringToHash = 
            timestamp + PRIVATE_API_KEY + API_KEY;
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
    private List<Param> createAuthParam() throws UnsupportedEncodingException, NoSuchAlgorithmException{
        long timestamp = new Date().getTime();
        
        List<Param> auths = new ArrayList();
        auths.add(new Param("ts", timestamp+""));
        auths.add(new Param("apikey", API_KEY));
        auths.add(new Param("hash", this.getKeyHash(timestamp))); 
        return auths;
    }
    private List<Param> createPaggingParam(int page) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        List<Param> pagging = new ArrayList();
        pagging.add(new Param("limit", RESULT_LIMIT+""));
        pagging.add(new Param("offset", (page*RESULT_LIMIT)+""));
        return pagging;
    }
    public String getResponseFromMarvelApi(
            String path, boolean pathIsFullUrl, List<Param> params)
        throws UnsupportedEncodingException, NoSuchAlgorithmException,
            URISyntaxException, IOException {
        
        if(params != null){
            params.addAll(this.createAuthParam());            
        } else {
            params = this.createAuthParam();
        }
        HttpResponse response;
        if(pathIsFullUrl){
            response =  this.getResponse(
                ACCEPT_HEADER, this.buildURI(path, params));
        } else {
            response =  this.getResponse(
                ACCEPT_HEADER, this.buildURI(SHEME, HOST, path, params));
        }
        return this.convertStreamContentToString(response.getEntity().getContent());
    }
    
    
    public String getPaggingResponseFromMarvelApi(
            String path, boolean pathIsFullUrl, List<Param> params, int page)
        throws UnsupportedEncodingException, NoSuchAlgorithmException,
            URISyntaxException, IOException {
        
        if(params != null){
            params.addAll(this.createAuthParam());            
        } else {
            params = this.createAuthParam();
        }
        params.addAll(createPaggingParam(page));
        HttpResponse response;
        if(pathIsFullUrl){
            response =  this.getResponse(
                ACCEPT_HEADER, this.buildURI(path, params));
        } else {
            response =  this.getResponse(
                ACCEPT_HEADER, this.buildURI(SHEME, HOST, path, params));
        }
        return this.convertStreamContentToString(response.getEntity().getContent());
    }
    
    public String getAPI_KEY() {
        return API_KEY;
    }
    public String getACCEPT_HEADER() {
        return ACCEPT_HEADER;
    }
    public String getSHEME() {
        return SHEME;
    }
    public String getHOST() {
        return HOST;
    }

    public Object getObjectFromJsonString(String paggingResponseFromMarvelApi, MarvelApiResponse<Comics> marvelApiResponse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

