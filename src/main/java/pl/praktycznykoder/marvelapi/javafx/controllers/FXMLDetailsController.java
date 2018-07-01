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
package pl.praktycznykoder.marvelapi.javafx.controllers;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import pl.praktycznykoder.marvelapi.javafx.app.SceneData;
import pl.praktycznykoder.marvelapi.javafx.app.ScenesFactory;
import pl.praktycznykoder.marvelapi.model.domain.basic.Image;
import pl.praktycznykoder.marvelapi.model.domain.basic.Url;
import pl.praktycznykoder.marvelapi.model.domain.wraper.DomainWraper;
import pl.praktycznykoder.marvelapi.model.services.Service;

/**
 *
 * @author praktycznykoder.pl
 * @param <DomainType>
 */
public abstract class FXMLDetailsController<DomainType> implements Initializable {
    
    /**
     *
     */
    @FXML protected ImageView thumbnailImageView;
    
    /**
     *
     */
    @FXML protected void imageThumbnailViewClick(){
        if(thumbnailImageView.getImage() != null){
            openImageScene(thumbnailImageView.getImage());
        }
    }
    
    /**
     *
     * @param character
     */
    public abstract void initData(DomainType character);

    /**
     *
     * @param remoteDomain
     */
    public abstract void initData(DomainWraper remoteDomain);

    /**
     *
     */
    protected abstract void initFields();

    /**
     *
     * @param event
     */
    protected abstract void resourceButtonOnAction(ActionEvent event);
    
    /**
     *
     */
    protected final int EMPTY_ITEMS = 0;

    /**
     *
     * @param comboBox
     * @param activateButton
     */
    protected void disableComboBoxWhereIsEmpty(ComboBox comboBox, Button activateButton){
        if(comboBox.getItems().size()<= EMPTY_ITEMS){
            comboBox.setDisable(true);
            activateButton.setDisable(true);
        }
    }

    /**
     *
     * @param button
     * @param value
     */
    protected void disableButtonWhereIsEmpty(Button button, DomainWraper value){
        if(value == null){
            button.setDisable(true);
        }
    }
    
    /**
     *
     * @param titleText
     * @param headerText
     * @param contentText
     */
    protected void showAlert(String titleText, String headerText, String contentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleText);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
    
    /**
     *
     * @param url
     * @return
     */
    protected WritableImage getImage(String url){
        try {
            BufferedImage image = getService().getImage(url);
            return SwingFXUtils.toFXImage(image, null);
        } catch (IOException ex) {
            Logger.getLogger(CharacterFXMLDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    

    /**
     *
     * @param image
     */
    protected void openImageScene(javafx.scene.image.Image image){
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
        stage.setTitle("Thumbnails image");
        stage.setScene(scene);       
        

        ImageFXMLDetailsController controller = 
        fxmlLoader.<ImageFXMLDetailsController>getController();
        
        controller.setImage(image);        
        stage.setMaximized(true);
        stage.show();        
       
    }
    
    /**
     *
     * @param image
     */
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

    /**
     *
     * @param resource
     * @param titeScene
     * @param remoteDomain
     */
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

    /**
     *
     * @param sceneData
     * @param comboBox
     */
    protected void openNewScene(SceneData sceneData, 
            ComboBox<DomainWraper> comboBox){   
        
        String resource = sceneData.getDetailsUrl();
        String titeScene = sceneData.getTitle();
        
        if(comboBox.getItems().isEmpty()){
            showAlert(titeScene, null, titeScene+" is Empty");
            return;
        }
        final DomainWraper remoteDomain = comboBox.getSelectionModel().
                getSelectedItem();
        openNewScene(resource, titeScene, remoteDomain); 
    }
    
    protected void openCharacterDetails(ComboBox<DomainWraper> comboBox){
        SceneData sceneData = ScenesFactory.getSceneData("characters");
        openNewScene(sceneData, comboBox);
    }
    protected void openComicsDetails(ComboBox<DomainWraper> comboBox){
        SceneData sceneData = ScenesFactory.getSceneData("comics");
        openNewScene(sceneData, comboBox);
    }
    protected void openCreatorsDetails(ComboBox<DomainWraper> comboBox){
        SceneData sceneData = ScenesFactory.getSceneData("creators");
        openNewScene(sceneData, comboBox);
    }
    protected void openEventsDetails(ComboBox<DomainWraper> comboBox){
        SceneData sceneData = ScenesFactory.getSceneData("events");
        openNewScene(sceneData, comboBox);
    }
    protected void openSeriesDetails(ComboBox<DomainWraper> comboBox){
        SceneData sceneData = ScenesFactory.getSceneData("series");
        openNewScene(sceneData, comboBox);
    }
    protected void openStoriesDetails(ComboBox<DomainWraper> comboBox){
        SceneData sceneData = ScenesFactory.getSceneData("stories");
        openNewScene(sceneData, comboBox);
    }
    
    
    
    
    /**
     *
     * @param objs
     * @param textArea
     */
    protected void setArrayObjectToTextArea(Object[] objs, TextArea textArea){
        String tmpText = "";        
        for (Object textObject : objs) {
            tmpText += textObject+ "\n";
        }
        textArea.setText(tmpText);
    }
    
    /**
     *
     * @param url
     */
    protected void openDesktopBrowserWithUrl(Url url){
        try {
            Desktop.getDesktop().browse(new URI(url.getUrl()));
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(CharacterFXMLDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param comboBox
     */
    protected void openDesktopBrowserFromComboBoxUrl(ComboBox<Url> comboBox){
        Url url = comboBox.getSelectionModel().getSelectedItem();
        openDesktopBrowserWithUrl(url);
    }
    
    /**
     *
     * @return
     */
    protected abstract Service getService();
}
