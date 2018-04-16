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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pl.praktycznykoder.api.domain.Pagging;
import pl.praktycznykoder.api.domain.Param;
import pl.praktycznykoder.marvelapi.client.response.Data;
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
                    
                    
                    
                    
                    Data data = getService().getData(getParamsFromForm(), 0);                
                    pagging.setLimit(data.getLimit());
                    pagging.setOffset(data.getOffset());
                    pagging.setTotal(data.getTotal());
                    //add data to table
                    getTableView().getItems().addAll(data.getResults());
                    setCurrentPage(1);
                    
                    
                    
                    
                    
                    
                    
                    
                    
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
    
    //paggination
    private Pagging pagging = new Pagging();

    public void setPagging(Pagging pagging) {
        this.pagging = pagging;
    }
    
    
    @FXML Button firstButton;
    @FXML Button previousButton;
    @FXML Button goCurrentPageButton;
    @FXML Button nextButton;
    @FXML Button lastButton;
    
    @FXML TextField currentPageTextField;
    public void setCurrentPage(int currentPage){
        currentPageTextField.setText(currentPage+"");
    }
    public int getCurrentPage(){
        return Integer.parseInt(currentPageTextField.getText());
    }
    @FXML protected void paggingButtonAction(ActionEvent actionEvent){
        Button button = (Button)actionEvent.getSource();
        int currentPage =0;
        switch (button.getId()) {
            case "firstButton":    
                currentPage = 1;             
                firstButton.setDisable(true);
                previousButton.setDisable(true);
                nextButton.setDisable(false);
                lastButton.setDisable(false);
                break;
            case "previousButton":          
                currentPage = getCurrentPage()-1; 
                if(currentPage<=1){
                    firstButton.setDisable(true);
                    previousButton.setDisable(true);
                } else {
                    firstButton.setDisable(false);
                    previousButton.setDisable(false);
                }
                nextButton.setDisable(false);
                lastButton.setDisable(false);  
                break;
            case "nextButton":          
                currentPage = getCurrentPage()+1;
                firstButton.setDisable(false);
                previousButton.setDisable(false);
                if(pagging.lastPage() <= currentPage){
                    nextButton.setDisable(true);
                    lastButton.setDisable(true);      
                }          
                break;
            case "lastButton":          
                currentPage = pagging.lastPage();
                firstButton.setDisable(false);
                previousButton.setDisable(false);
                if(pagging.lastPage() <= currentPage){
                    nextButton.setDisable(true);
                    lastButton.setDisable(true);      
                }          
                break;
            default:
                break;
        }
        setCurrentPage(currentPage);        
    }
}