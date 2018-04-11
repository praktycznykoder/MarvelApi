/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.javafx;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import pl.praktycznykoder.api.domain.Param;
import pl.praktycznykoder.marvelapi.model.services.Service;

/**
 *
 * @author praktycznykoder.pl
 */
public abstract class FXMLController implements Initializable{
    
    protected abstract Service getService();
    protected abstract TableView getTableView();
    protected abstract ComboBox<String> getOrderByComboBox();
    
    protected abstract List<Param> getParamsFromForm();
    
    protected abstract void showSelectedButtonAction(ActionEvent event);
    
    @FXML protected void findButtonAction(ActionEvent event){                  
        loadObjectsToTableView(true);
    }
    
    protected void addOrdersToOrderByComboBox(String[] orders, int selectedIndex){
        if(selectedIndex >= orders.length*2){
            selectedIndex = 0;
        }
        getOrderByComboBox().getItems().addAll(orders); 
        for(String order : orders){
            getOrderByComboBox().getItems().add("-"+order);
        }               
        getOrderByComboBox().getSelectionModel().select(selectedIndex);
    }
    
    protected void loadObjectsToTableView(final boolean clear){
        new Runnable() {
            @Override
            public void run() {          
                try {
                    if(clear){
                        getTableView().getItems().clear();                        
                    }
                    getTableView().getItems().addAll(
                        getService().getObjects( getParamsFromForm(), 0));
                } catch (NoSuchAlgorithmException ex) {
                    org.apache.log4j.Logger.getLogger(
                            ComicsFXMLController.class.getName()).error("GET_ITEMS", ex);
                } catch (URISyntaxException ex) {
                    org.apache.log4j.Logger.getLogger(ComicsFXMLController.class.getName()).error("GET_ITEMS", ex);
                } catch (IOException ex) {
                    org.apache.log4j.Logger.getLogger(ComicsFXMLController.class.getName()).error("GET_ITEMS", ex);
                }
                getTableView().refresh();
            }
        }.run();     
    }
    
    protected void initOrderByComboBox() {        
        String[] orders = getService().getOrderByParamNodes();
        addOrdersToOrderByComboBox(orders, 3);
    }
    protected void initTableView() {        
       if(getTableView().getItems().isEmpty()){
            loadObjectsToTableView(false);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initOrderByComboBox();
        initTableView(); 
    }
}
