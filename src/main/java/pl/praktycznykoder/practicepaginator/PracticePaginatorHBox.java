/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.practicepaginator;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import pl.praktycznykoder.api.domain.Pagging;

/**
 *
 * @author praktycznykoder.pl
 */
public abstract class PracticePaginatorHBox extends HBox{

    private Pagging pagging;

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
    
    protected abstract void refreshData(int page);
    
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
        refreshData(currentPage);
        
    }
    
    public PracticePaginatorHBox() {
        super();
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
            "fxml/PracticePaginator.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    
    
}
