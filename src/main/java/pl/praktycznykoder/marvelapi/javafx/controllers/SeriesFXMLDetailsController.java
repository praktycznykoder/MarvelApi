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
import pl.praktycznykoder.marvelapi.model.domain.Series;
import pl.praktycznykoder.marvelapi.model.domain.basic.Url;
import pl.praktycznykoder.marvelapi.model.domain.wraper.DomainWraper;
import pl.praktycznykoder.marvelapi.model.services.SeriesAbstractServiceImpl;
import pl.praktycznykoder.marvelapi.model.services.Service;

/**
 *
 * @author praktycznykoder.pl
 */
public class SeriesFXMLDetailsController extends FXMLDetailsController<Series> {

    private final Service<Series> service = new SeriesAbstractServiceImpl();

    /**
     *
     * @return
     */
    @Override
    protected Service getService() {
        return service;
    }
    
    private Series seriesDomain;
        
    @FXML private TextField idTextField;
    @FXML private TextField titleTextField;
    @FXML private TextArea descriptionTextArea;
    @FXML private TextField typeTextField;
    @FXML private TextField modifiedTextField;
    @FXML private TextField resourceURITextField;
    @FXML private TextField startYearTextField;
    @FXML private TextField endYearTextField;   
    
    @FXML private ComboBox<Url> urlsComboBox;
    
    @FXML private ComboBox<DomainWraper> comicsComboBox;
    @FXML private ComboBox<DomainWraper> charactersComboBox;
    @FXML private ComboBox<DomainWraper> storiesComboBox;
    @FXML private ComboBox<DomainWraper> creatorsComboBox;
    @FXML private ComboBox<DomainWraper> eventsComboBox;            
    
    @FXML private Button previousButton; 
    @FXML private Button nextButton;   
    
    @FXML private Button urlsButton;
    @FXML private Button comicsButton;
    @FXML private Button storiesButton;
    @FXML private Button eventsButton;
    @FXML private Button charactersButton;
    @FXML private Button creatorsButton;    
    /**
     *
     */
    @Override
    protected void initFields() {
        thumbnailImageView.setImage(
                getImage(seriesDomain.getThumbnail().toString()));
        idTextField.setText(seriesDomain.getId()+"");
        titleTextField.setText(seriesDomain.getTitle());       
        descriptionTextArea.setText(seriesDomain.getDescription());
        typeTextField.setText(seriesDomain.getType());
        modifiedTextField.setText(seriesDomain.getModified());
        startYearTextField.setText(seriesDomain.getStartYear());
        endYearTextField.setText(seriesDomain.getEndYear());
        
        resourceURITextField.setText(seriesDomain.getResourceURI());
        
        
        urlsComboBox.getItems().addAll(seriesDomain.getUrls());
        disableComboBoxWhereIsEmpty(urlsComboBox, urlsButton);
        
        comicsComboBox.getItems().addAll(seriesDomain.getComics().getItems());
        disableComboBoxWhereIsEmpty(comicsComboBox, comicsButton);
        
        storiesComboBox.getItems().addAll(seriesDomain.getStories().getItems());
        disableComboBoxWhereIsEmpty(storiesComboBox, storiesButton);
        
        eventsComboBox.getItems().addAll(seriesDomain.getEvents().getItems());
        disableComboBoxWhereIsEmpty(eventsComboBox, eventsButton);
        
        charactersComboBox.getItems().addAll(seriesDomain.getCharacters().getItems());
        disableComboBoxWhereIsEmpty(charactersComboBox, charactersButton);
        
        creatorsComboBox.getItems().addAll(seriesDomain.getCreators().getItems());
        disableComboBoxWhereIsEmpty(creatorsComboBox, creatorsButton);
        
        disableButtonWhereIsEmpty(previousButton, seriesDomain.getPrevious());        
        disableButtonWhereIsEmpty(nextButton, seriesDomain.getNext());
        
        
    }
    
    /**
     *
     * @param seriesDomain
     */
    @Override
    public void initData(Series seriesDomain){
        this.seriesDomain = seriesDomain;
        initFields();
    }
    
    /**
     *
     * @param remoteDomain
     */
    @Override
    public void initData(DomainWraper remoteDomain) {
        try {
            this.seriesDomain = service.getObjectWithUrl(remoteDomain.getResourceURI(), null);
        } catch (NoSuchAlgorithmException | URISyntaxException | IOException ex) {
            Logger.getLogger(SeriesFXMLDetailsController.class.getName()).log(Level.SEVERE, null, ex);
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
            case "storiesButton":   
                openNewScene("/fxml/StoryDetails.fxml", "Stories",
                        storiesComboBox);
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
            case "previousButton":   
                System.out.println(seriesDomain.getPrevious());
                openNewScene("/fxml/SeriesDetails.fxml", "Series",
                        seriesDomain.getPrevious());
            break;                            
            case "nextButton":   
                openNewScene("/fxml/SeriesDetails.fxml", "Series",
                        seriesDomain.getNext());
            break;
            case "resourceURIButton":
                try {
                    Desktop.getDesktop().browse(new URI(seriesDomain.getResourceURI()));
                } catch (IOException | URISyntaxException ex) {
                    Logger.getLogger(SeriesFXMLDetailsController.class.getName()).log(Level.SEVERE, null, ex);
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
