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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pl.praktycznykoder.marvelapi.model.domain.Story;
import pl.praktycznykoder.marvelapi.model.domain.basic.Url;
import pl.praktycznykoder.marvelapi.model.domain.wraper.DomainWraper;
import pl.praktycznykoder.marvelapi.model.services.Service;
import pl.praktycznykoder.marvelapi.model.services.StoryAbstractServiceImpl;

/**
 *
 * @author praktycznykoder.pl
 */
public class StoryFXMLDetailsController extends FXMLDetailsController<Story> {

    private final Service<Story> service = new StoryAbstractServiceImpl();
    
    /**
     *
     * @return
     */
    @Override
    protected Service getService() {
        return service;
    }
    
    private Story storyDomain;
        
    @FXML private TextField idTextField;
    @FXML private TextField titleTextField;
    @FXML private TextArea descriptionTextArea;
    @FXML private TextField typeTextField;
    @FXML private TextField modifiedTextField;
    @FXML private TextField resourceURITextField;
    
    @FXML private ComboBox<Url> urlsComboBox;
    
    @FXML private ComboBox<DomainWraper> comicsComboBox;
    @FXML private ComboBox<DomainWraper> charactersComboBox;
    @FXML private ComboBox<DomainWraper> seriesComboBox;
    @FXML private ComboBox<DomainWraper> creatorsComboBox;
    @FXML private ComboBox<DomainWraper> eventsComboBox;
    
    @FXML private Button originalIssueButton; 
    
    @FXML private Button comicsButton;
    @FXML private Button seriesButton;
    @FXML private Button eventsButton;
    @FXML private Button charactersButton;
    @FXML private Button creatorsButton;
    
    /**
     *
     */
    @Override
    protected void initFields() {
        if(storyDomain.getThumbnail() != null){
            thumbnailImageView.setImage(
                getImage(storyDomain.getThumbnail().toString()));            
        }
        idTextField.setText(storyDomain.getId()+"");
        titleTextField.setText(storyDomain.getTitle());       
        descriptionTextArea.setText(storyDomain.getDescription());
        typeTextField.setText(storyDomain.getType());
        modifiedTextField.setText(storyDomain.getModified());
        
        resourceURITextField.setText(storyDomain.getResourceURI());
        
        
        comicsComboBox.getItems().addAll(storyDomain.getComics().getItems());
        disableComboBoxWhereIsEmpty(comicsComboBox, comicsButton);
        
        seriesComboBox.getItems().addAll(storyDomain.getSeries().getItems());
        disableComboBoxWhereIsEmpty(seriesComboBox, seriesButton);
                        
        eventsComboBox.getItems().addAll(storyDomain.getEvents().getItems());
        disableComboBoxWhereIsEmpty(eventsComboBox, eventsButton);
        
        charactersComboBox.getItems().addAll(storyDomain.getCharacters().getItems());
        disableComboBoxWhereIsEmpty(charactersComboBox, charactersButton);
        
        creatorsComboBox.getItems().addAll(storyDomain.getCreators().getItems());
        disableComboBoxWhereIsEmpty(creatorsComboBox, creatorsButton);
        
        disableButtonWhereIsEmpty(originalIssueButton, storyDomain.getOriginalIssue());        
    }
    
    /**
     *
     * @param storyDomain
     */
    @Override
    public void initData(Story storyDomain){
        this.storyDomain = storyDomain;
        initFields();
    }
    
    /**
     *
     * @param remoteDomain
     */
    @Override
    public void initData(DomainWraper remoteDomain) {
        try {
            this.storyDomain = service.getObjectWithUrl(remoteDomain.getResourceURI(), null);
        } catch (NoSuchAlgorithmException | URISyntaxException | IOException ex) {
            Logger.getLogger(StoryFXMLDetailsController.class.getName()).log(Level.SEVERE, null, ex);
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
        System.out.println(id);
        switch (id) {
            case "comicsButton":   
                openNewScene("/fxml/ComicsDetails.fxml", "Comics",
                        comicsComboBox);
            break;
            case "seriesButton":   
                openNewScene("/fxml/SsriesDetails.fxml", "Series",
                        seriesComboBox);
            break;
            case "charactersComboBox":   
                openNewScene("/fxml/CharacterDetails.fxml", "Character",
                        charactersComboBox);
            break;
            case "creatorsComboBox":   
                openNewScene("/fxml/CreatorDetails.fxml", "Creator",
                        creatorsComboBox);
            break;                   
            case "eventsComboBox":   
                openNewScene("/fxml/EventsDetails.fxml", "Event",
                        eventsComboBox);
            break;                             
            case "originalIssueButton":   
                openNewScene("/fxml/ComicsDetails.fxml", "Comics",
                        storyDomain.getOriginalIssue());
            break;     
            case "resourceURIButton":
                try {
                    Desktop.getDesktop().browse(new URI(storyDomain.getResourceURI()));
                } catch (IOException | URISyntaxException ex) {
                    Logger.getLogger(StoryFXMLDetailsController.class.getName()).log(Level.SEVERE, null, ex);
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
