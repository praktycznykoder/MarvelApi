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
import java.util.ArrayList;
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
    
    protected int orderByIndex = 0;
    
    protected abstract Service getService();
    protected abstract TableView getTableView();
    
    protected abstract List<Param> getParamsFromForm();
    
    protected abstract void showSelectedButtonAction(ActionEvent event);
    
    @FXML protected ComboBox<String> orderByComboBox;
    @FXML protected void findButtonAction(ActionEvent event){                  
        loadObjectsToTableView(true);
    }
    @FXML protected void resetFormComboBoxOnAction(ActionEvent event){                  
        ComboBox comboBox = (ComboBox) event.getSource();
        String tmpString = (String) comboBox.getSelectionModel().getSelectedItem();
        if(tmpString.isEmpty()){
            comboBox.getSelectionModel().clearSelection();
        }
    }
    
    protected List<Param> getNewListParamWithOrderBy(){
        List<Param> params = new ArrayList();
        String orderBy = orderByComboBox.getSelectionModel().getSelectedItem();        
        if(!orderBy.isEmpty()) params.add(new Param("orderBy", orderBy));
        return params;
    }
    
    protected void addOrdersToOrderByComboBox(String[] orders){
        orderByComboBox.getItems().addAll(orders); 
        for(String order : orders){
            orderByComboBox.getItems().add("-"+order);
        }               
        orderByComboBox.getSelectionModel().select(orderByIndex);
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
    protected abstract void beforeInit();
    
    protected void initOrderByComboBox() {        
        String[] orders = getService().getOrderByParamNodes();
        addOrdersToOrderByComboBox(orders);
    }
    protected void initTableView() {        
       if(getTableView().getItems().isEmpty()){
            loadObjectsToTableView(false);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        beforeInit();
        initOrderByComboBox();
        initTableView(); 
    }
}