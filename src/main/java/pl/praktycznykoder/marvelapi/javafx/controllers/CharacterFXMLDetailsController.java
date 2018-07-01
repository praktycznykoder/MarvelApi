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

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pl.praktycznykoder.marvelapi.model.services.CharacterAbstractServiceImpl;
import pl.praktycznykoder.marvelapi.model.services.Service;
import pl.praktycznykoder.marvelapi.model.domain.Character;
import pl.praktycznykoder.marvelapi.model.domain.basic.Url;
import pl.praktycznykoder.marvelapi.model.domain.wraper.DomainWraper;

/**
 *
 * @author praktycznykoder.pl
 */
public class CharacterFXMLDetailsController extends FXMLDetailsController<Character> {
    
    private final Service<Character> service = new CharacterAbstractServiceImpl();     
    
    /**
     *
     * @return
     */
    @Override
    protected Service getService() {
        return service;
    }
    
    private Character characterDomain;
        
    @FXML private TextField idTextField;
    @FXML private TextField nameTextField;
    @FXML private TextField modyfiedTextField;
    @FXML private TextField resourceURITextField;
    @FXML private TextArea descriptionTextArea;
    @FXML private ComboBox<Url> urlsComboBox;
    @FXML private ComboBox<DomainWraper> comicsComboBox;
    @FXML private ComboBox<DomainWraper> seriesComboBox;
    @FXML private ComboBox<DomainWraper> eventsComboBox;
    @FXML private ComboBox<DomainWraper> storiesComboBox;
    
    @FXML private Button urlsButton;
    @FXML private Button comicsButton;
    @FXML private Button seriesButton;
    @FXML private Button eventsButton;
    @FXML private Button storiesButton;
    
    /**
     *
     * @throws NullPointerException
     */
    @Override
    protected void initFields() throws java.lang.NullPointerException{
        
        thumbnailImageView.setImage(
                getImage(characterDomain.getThumbnail().toString()));
        idTextField.setText(characterDomain.getId()+"");
        nameTextField.setText(characterDomain.getName());
        modyfiedTextField.setText(characterDomain.getModified());
        resourceURITextField.setText(characterDomain.getResourceURI());
        descriptionTextArea.setText(characterDomain.getDescription());
        
        urlsComboBox.getItems().addAll(characterDomain.getUrls());
        disableComboBoxWhereIsEmpty(urlsComboBox, urlsButton);
                         
        comicsComboBox.getItems().addAll(characterDomain.getComics().getItems());        
        disableComboBoxWhereIsEmpty(comicsComboBox, comicsButton);
        
        seriesComboBox.getItems().addAll(characterDomain.getSeries().getItems());
        disableComboBoxWhereIsEmpty(seriesComboBox, seriesButton);
        
        eventsComboBox.getItems().addAll(characterDomain.getEvents().getItems());
        disableComboBoxWhereIsEmpty(eventsComboBox, eventsButton);
        
        storiesComboBox.getItems().addAll(characterDomain.getStories().getItems());
        disableComboBoxWhereIsEmpty(storiesComboBox, storiesButton);
    }
        
    /**
     *
     * @param character
     */
    @Override
    public void initData(Character character){
        this.characterDomain = character;
        initFields();
    }
 
    /**
     *
     * @param remoteDomain
     */
    @Override
    public void initData(DomainWraper remoteDomain) {
        try {
            this.characterDomain = service.getObjectWithUrl(remoteDomain.getResourceURI(), null);
        } catch (NoSuchAlgorithmException | URISyntaxException | IOException ex) {
            Logger.getLogger(CharacterFXMLDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        initFields();
    }
    /**
     *
     * @param event
     */
    @Override
    @FXML
    protected void resourceButtonOnAction(ActionEvent event){
        Button btn = (Button) event.getSource();
        String id = btn.getId();
        
        switch (id) {
            case "urlsButton":                
                    openDesktopBrowserFromComboBoxUrl(urlsComboBox);
                break;
            case "comicsButton":
                    openNewScene("/fxml/ComicsDetails.fxml", "Comics",
                        comicsComboBox);
                break;
            case "seriesButton":
                    openNewScene("/fxml/SeriesDetails.fxml", "Series",
                        seriesComboBox);
                break;
            case "eventsButton":
                    openNewScene("/fxml/EventDetails.fxml", "Event",
                        eventsComboBox);
                break;
            case "storiesButton":
                    openNewScene("/fxml/StoryDetails.fxml", "Stories",
                        storiesComboBox);
                break;
            default:
                break;
        }
    }            
            
    @Override
    public void initialize(URL url, ResourceBundle rb) { }    

}
