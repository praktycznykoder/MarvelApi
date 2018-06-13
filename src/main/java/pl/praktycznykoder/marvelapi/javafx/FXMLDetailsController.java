/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.javafx;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import pl.praktycznykoder.marvelapi.model.domain.TextObject;
import pl.praktycznykoder.marvelapi.model.domain.basic.Image;
import pl.praktycznykoder.marvelapi.model.domain.basic.Url;
import pl.praktycznykoder.marvelapi.model.domain.wraper.DomainWraper;
import pl.praktycznykoder.marvelapi.model.services.Service;

/**
 *
 * @author praktycznykoder.pl
 * @param <DomainType>
 */
public abstract class FXMLDetailsController<DomainType> implements Initializable{
    public abstract void initData(DomainType character);
    public abstract void initData(DomainWraper remoteDomain);
    protected abstract void initFields();
    protected abstract void getResourceButtonOnAction(ActionEvent event);
    
    protected final int EMPTY_ITEMS = 0;
    protected void disableComboBoxWhereIsEmpty(ComboBox comboBox){
        if(comboBox.getItems().size()<= EMPTY_ITEMS){
            comboBox.setDisable(true);
        }
    }
    protected void disableButtonWhereIsEmpty(Button button, DomainWraper value){
        if(value == null){
            button.setDisable(true);
        }
    }
    
    protected void showAlert(String titleText, String headerText, String contentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleText);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
    
    protected WritableImage getImage(String url){
        try {
            BufferedImage image = getService().getImage(url);
            return SwingFXUtils.toFXImage(image, null);
        } catch (IOException ex) {
            Logger.getLogger(CharacterFXMLDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    protected void openImageScene(Image image){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().
        getResource("/fxml/ShowImage.fxml"));     
        Stage stage = new Stage();
        Parent root = null;                       
        try {
            root = (Parent)fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(ImageFXMLDetailsController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        stage.setTitle("Image" +" - "+image);
        stage.setScene(scene);       
        
        WritableImage fxImage = getImage(image.toString());

        ImageFXMLDetailsController controller = 
        fxmlLoader.<ImageFXMLDetailsController>getController();
        
        controller.setImage(fxImage);        
        stage.setMaximized(true);
        stage.show();        
       
    }
    protected void openNewScene(String resource, String titeScene, 
               DomainWraper remoteDomain){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().
        getResource(resource));     
        Stage stage = new Stage();
        Parent root = null;                       
        try {
            root = (Parent)fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(CharacterFXMLController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);
        //scene.getStylesheets().add("/styles/Styless.css");
        stage.setTitle(titeScene +" - "+remoteDomain.getName());
        stage.setScene(scene);       

        FXMLDetailsController controller = 
        fxmlLoader.<FXMLDetailsController>getController();
        controller.initData(remoteDomain);
        stage.show();        
    }
    protected void openNewScene(String resource, String titeScene, 
            ComboBox<DomainWraper> comboBox){        
        if(comboBox.getItems().isEmpty()){
            showAlert(titeScene, null, titeScene+" is Empty");
            return;
        }
        final DomainWraper remoteDomain = comboBox.getSelectionModel().
                getSelectedItem();
        openNewScene(resource, titeScene, remoteDomain); 
    }
    
    protected void setArrayObjectToTextArea(Object[] objs, TextArea textArea){
        String tmpText = "";        
        for (Object textObject : objs) {
            tmpText += textObject+ "\n";
        }
        textArea.setText(tmpText);
    }
    
    protected void openDesktopBrowserWithUrl(Url url){
        try {
            Desktop.getDesktop().browse(new URI(url.getUrl()));
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(CharacterFXMLDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    protected void openDesktopBrowserFromComboBoxUrl(ComboBox<Url> comboBox){
        Url url = comboBox.getSelectionModel().getSelectedItem();
        openDesktopBrowserWithUrl(url);
    }
    
    protected abstract Service getService();
}
