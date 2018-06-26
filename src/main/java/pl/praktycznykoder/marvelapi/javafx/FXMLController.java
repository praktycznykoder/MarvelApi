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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pl.praktycznykoder.api.domain.Param;
import pl.praktycznykoder.marvelapi.client.response.Data;
import pl.praktycznykoder.marvelapi.model.services.Service;

/**
 *
 * @author praktycznykoder.pl
 */
public abstract class FXMLController implements Initializable{
    
    protected int orderByIndex = 0;
    private int currentPage = 0;
    private int lastPage = 0;
    
    protected abstract void beforeInit();
    protected abstract Service getService();
    protected abstract TableView getTableView();
    
    protected abstract List<Param> getParamsFromForm();
    
    protected abstract void showSelectedButtonAction(ActionEvent event);
    
    @FXML protected ComboBox<String> orderByComboBox;
    @FXML protected void findButtonAction(ActionEvent event){                  
        loadObjectsToTableView(true, 1);
    }
    @SuppressWarnings("empty-statement")  
    @FXML                
    protected void resetFormComboBoxOnAction(ActionEvent event){                  
        ComboBox comboBox = (ComboBox) event.getSource();
        if(comboBox.getSelectionModel().getSelectedIndex() == 0){            
            comboBox.getSelectionModel().clearSelection();
        };
    }
        
    @FXML Button firstButton;
    @FXML Button previousButton;
    @FXML Button goCurrentPageButton;
    @FXML Button nextButton;
    @FXML Button lastButton;
    
    @FXML Label lastPageLabel;
    public void setTextLastPageLabel(int lastPageLabel) {
        this.lastPageLabel.setText(lastPageLabel+"");
    }
    @FXML TextField currentPageTextField;
    public void setCurrentPageTextField(int currentPage){
        currentPageTextField.setText(currentPage+"");
    }

    public boolean initCurrentPageInputWhenIsValid() {
        setCurrentPageTextField(currentPage);
        String textTmp = currentPageTextField.getText();
        int pageFromTextField;
        try {
            pageFromTextField = Integer.parseInt(textTmp);
            
            if(pageFromTextField == currentPage){
                showAlert("Bad page input", null, "Input is current page");
                return false;
            } else if(pageFromTextField < 1 || pageFromTextField > lastPage){                
                showAlert(
                    "Bad page input", null, "Input must be betwen 1 or "+lastPage);
                return false;
            }
        } catch (NumberFormatException e) {            
            showAlert("Bad Input", null, "Input: \""+textTmp+"\" is not integer number (1-"+lastPage+")");
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        currentPage = pageFromTextField;
        return true;
    }
    
    @FXML protected void paggingButtonAction(ActionEvent actionEvent){
        String id = ((Button)actionEvent.getSource()).getId();
        switch (id) {
            case "firstButton":    
                loadObjectsToTableView(true, 1);
                break;
            case "previousButton":          
                loadObjectsToTableView(true, currentPage-1); 
                break;
            case "nextButton":   
                loadObjectsToTableView(true, currentPage+1); 
                break;
            case "lastButton": 
                loadObjectsToTableView(true, lastPage); 
                break;
            case "goCurrentPageButton":
                if(initCurrentPageInputWhenIsValid()){
                    loadObjectsToTableView(true, currentPage);                    
                };              
                break;
            default:
                break;
        }        
    }
    
    protected void showAlert(String titleText, String headerText, String contentText){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titleText);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
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
    protected void clearTableView(boolean clear){
        if(clear){
            getTableView().getItems().clear();            
        }
    }
    protected void refreshTableView(){
        getTableView().refresh();
    }
    protected void addRowsToTableView(Data data){
        if(data.getCount() >0){
            getTableView().getItems().addAll(data.getResults());
        } else {
            showAlert("Information", null, "NO RESULTS");
        }
    }    
    protected void initPagging(Data data){
        currentPage = data.countCurrentPage();
        lastPage = data.countLastPage();
        if(data.getCount() == 0){
            nextButton.setDisable(false);
            lastButton.setDisable(false);      
            nextButton.setDisable(false);
            lastButton.setDisable(false);
            return;
        }
        if(currentPage >= lastPage){             
            nextButton.setDisable(true);
            lastButton.setDisable(true);
        } else {        
            nextButton.setDisable(false);
            lastButton.setDisable(false);
        }   
        if(currentPage > 1){        
            firstButton.setDisable(false);
            previousButton.setDisable(false);
        } else { 
            firstButton.setDisable(true);
            previousButton.setDisable(true);
        }
        setTextLastPageLabel(lastPage);
        setCurrentPageTextField(currentPage);
    }
    protected Data getDataFromService(int page){
        try {
            return getService().getData(getParamsFromForm(), page);
        } catch (NoSuchAlgorithmException | URISyntaxException | IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    protected void loadObjectsToTableView(final boolean clear, final int page){
        new Runnable() {
            @Override
            public void run() {     
                clearTableView(clear);
                Data data = getDataFromService(page);
                if(data != null ){                    
                    addRowsToTableView(data);
                    initPagging(data);
                    refreshTableView();
                } else {
                    showAlert("Information", "CONNECTION ERROR", "CHECK LOG FILE");
                }
            }
        }.run();     
    }
    
    protected void initOrderByComboBox() {        
        String[] orders = getService().getOrderByParamNodes();
        addOrdersToOrderByComboBox(orders);
    }
    protected void initTableView() {        
       if(getTableView().getItems().isEmpty()){
            loadObjectsToTableView(false, 1);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        beforeInit();
        initOrderByComboBox();
        initTableView(); 
    }
}