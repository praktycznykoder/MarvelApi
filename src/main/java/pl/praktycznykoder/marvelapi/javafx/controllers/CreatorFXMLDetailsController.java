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
import java.io.IOException;
import java.net.URI;
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
import javafx.scene.control.TextField;
import pl.praktycznykoder.marvelapi.model.domain.Creator;
import pl.praktycznykoder.marvelapi.model.domain.basic.Url;
import pl.praktycznykoder.marvelapi.model.domain.wraper.DomainWraper;
import pl.praktycznykoder.marvelapi.model.services.CreatorAbstractServiceImpl;
import pl.praktycznykoder.marvelapi.model.services.Service;

/**
 *
 * @author praktycznykoder.pl
 */
public class CreatorFXMLDetailsController extends FXMLDetailsController<Creator> {

    private final Service<Creator> service = new CreatorAbstractServiceImpl();

    /**
     *
     * @return
     */
    @Override
    protected Service getService() {
        return service;
    }
    
    private Creator creatorDomain;
        
    @FXML private TextField idTextField;
    @FXML private TextField firstNameTextField;
    @FXML private TextField middleNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField fullNameTextField;
    @FXML private TextField suffixTextField;
    @FXML private TextField modifiedTextField;
    @FXML private TextField resourceURITextField;    
    
    @FXML private ComboBox<Url> urlsComboBox;
    @FXML private ComboBox<DomainWraper> comicsComboBox;
    @FXML private ComboBox<DomainWraper> storiesComboBox;
    @FXML private ComboBox<DomainWraper> seriesComboBox;
    @FXML private ComboBox<DomainWraper> eventsComboBox;
    
    @FXML private Button urlsButton;
    @FXML private Button comicsButton;
    @FXML private Button storiesButton;
    @FXML private Button seriesButton;
    @FXML private Button eventsButton;
            
    /**
     *
     */
    @Override
    protected void initFields() {
        thumbnailImageView.setImage(
                getImage(creatorDomain.getThumbnail().toString()));
        idTextField.setText(creatorDomain.getId()+"");
        firstNameTextField.setText(creatorDomain.getFirstName());
        middleNameTextField.setText(creatorDomain.getMiddleName());
        lastNameTextField.setText(creatorDomain.getLastName());
        fullNameTextField.setText(creatorDomain.getFullName());
        suffixTextField.setText(creatorDomain.getSuffix());
        modifiedTextField.setText(creatorDomain.getModified());
        resourceURITextField.setText(creatorDomain.getResourceURI());
        urlsComboBox.getItems().addAll(creatorDomain.getUrls());
        disableComboBoxWhereIsEmpty(urlsComboBox, urlsButton);
        
        comicsComboBox.getItems().addAll(creatorDomain.getComics().getItems());
        disableComboBoxWhereIsEmpty(comicsComboBox, comicsButton);
        
        storiesComboBox.getItems().addAll(creatorDomain.getStories().getItems());
        disableComboBoxWhereIsEmpty(storiesComboBox, storiesButton);
        
        seriesComboBox.getItems().addAll(creatorDomain.getSeries().getItems());
        disableComboBoxWhereIsEmpty(seriesComboBox, seriesButton);
        
        eventsComboBox.getItems().addAll(creatorDomain.getEvents().getItems());
        disableComboBoxWhereIsEmpty(eventsComboBox, eventsButton);
                
        
        
        
        
    }
    
    /**
     *
     * @param creator
     */
    @Override
    public void initData(Creator creator){
        this.creatorDomain = creator;
        initFields();
    }
    
    /**
     *
     * @param remoteDomain
     */
    @Override
    public void initData(DomainWraper remoteDomain) {
        try {
            this.creatorDomain = service.getObjectWithUrl(remoteDomain.getResourceURI(), null);
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
            case "comicsButton":   
                openNewScene("/fxml/ComicsDetails.fxml", "Comics",
                        storiesComboBox);
            break;
            case "storiesButton":   
                openNewScene("/fxml/StoryDetails.fxml", "Stories",
                        storiesComboBox);
            break;
            case "eventsButton":   
                openNewScene("/fxml/EventDetails.fxml", "Event",
                        eventsComboBox);
            break;                   
            case "seriesButton":   
                openNewScene("/fxml/SeriesDetails.fxml", "Series",
                        seriesComboBox);
            break;            
            case "resourceURIButton":
                try {
                    Desktop.getDesktop().browse(new URI(creatorDomain.getResourceURI()));
                } catch (IOException | URISyntaxException ex) {
                    Logger.getLogger(CharacterFXMLDetailsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            break;
            case "urlsButton":   
                openDesktopBrowserFromComboBoxUrl(urlsComboBox);
            break;
                          
            default:
                System.out.println("switch dont have this id");
                break;
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) { }


    
}
