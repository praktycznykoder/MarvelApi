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
package pl.praktycznykoder.marvelapi.javafx;

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
import pl.praktycznykoder.marvelapi.model.domain.Event;
import pl.praktycznykoder.marvelapi.model.domain.basic.Url;
import pl.praktycznykoder.marvelapi.model.domain.wraper.DomainWraper;
import pl.praktycznykoder.marvelapi.model.services.EventAbstractServiceImpl;
import pl.praktycznykoder.marvelapi.model.services.Service;

/**
 *
 * @author praktycznykoder.pl
 */
public class EventFXMLDetailsController extends FXMLDetailsController<Event> {

    private final Service<Event> service = new EventAbstractServiceImpl();

    /**
     *
     * @return
     */
    @Override
    protected Service getService() {
        return service;
    }
    
    private Event eventDomain;
        
    @FXML private TextField idTextField;
    @FXML private TextField titleTextField;
    @FXML private TextArea descriptionTextArea;
    @FXML private TextField modifiedTextField;
    @FXML private TextField resourceURITextField;
    @FXML private TextField startTextField;
    @FXML private TextField endTextField;   
    
    @FXML private ComboBox<Url> urlsComboBox;
    
    @FXML private ComboBox<DomainWraper> comicsComboBox;
    @FXML private ComboBox<DomainWraper> storiesComboBox;
    @FXML private ComboBox<DomainWraper> seriesComboBox;
    @FXML private ComboBox<DomainWraper> charactersComboBox;
    @FXML private ComboBox<DomainWraper> creatorsComboBox;
            
    
    @FXML private Button previousButton; 
    @FXML private Button nextButton; 
    
    /**
     *
     */
    @Override
    protected void initFields() {
        thumbnailImageView.setImage(
                getImage(eventDomain.getThumbnail().toString()));
        idTextField.setText(eventDomain.getId()+"");
        titleTextField.setText(eventDomain.getTitle());       
        descriptionTextArea.setText(eventDomain.getId()+"");
        modifiedTextField.setText(eventDomain.getModified());
        startTextField.setText(eventDomain.getStart());
        endTextField.setText(eventDomain.getEnd());
        
        resourceURITextField.setText(eventDomain.getResourceURI());
        
        
        urlsComboBox.getItems().addAll(eventDomain.getUrls());
        disableComboBoxWhereIsEmpty(urlsComboBox);
        
        comicsComboBox.getItems().addAll(eventDomain.getComics().getItems());
        disableComboBoxWhereIsEmpty(comicsComboBox);
        
        storiesComboBox.getItems().addAll(eventDomain.getStories().getItems());
        disableComboBoxWhereIsEmpty(storiesComboBox);
        
        seriesComboBox.getItems().addAll(eventDomain.getSeries().getItems());
        disableComboBoxWhereIsEmpty(seriesComboBox);
        
        charactersComboBox.getItems().addAll(eventDomain.getCharacters().getItems());
        disableComboBoxWhereIsEmpty(charactersComboBox);
        
        creatorsComboBox.getItems().addAll(eventDomain.getCreators().getItems());
        disableComboBoxWhereIsEmpty(creatorsComboBox);
        
        disableButtonWhereIsEmpty(previousButton, eventDomain.getPrevious());        
        disableButtonWhereIsEmpty(nextButton, eventDomain.getNext());
        
    }
    
    /**
     *
     * @param eventDomain
     */
    @Override
    public void initData(Event eventDomain){
        this.eventDomain = eventDomain;
        initFields();
    }
    
    /**
     *
     * @param remoteDomain
     */
    @Override
    public void initData(DomainWraper remoteDomain) {
        try {
            this.eventDomain = service.getObjectWithUrl(remoteDomain.getResourceURI(), null);
        } catch (NoSuchAlgorithmException | URISyntaxException | IOException ex) {
            Logger.getLogger(EventFXMLDetailsController.class.getName()).log(Level.SEVERE, null, ex);
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
                        storiesComboBox);
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
            case "seriesButton":   
                openNewScene("/fxml/SeriesDetails.fxml", "Series",
                        seriesComboBox);
            break;                             
            case "previousButton":   
                openNewScene("/fxml/EventDetails.fxml", "Event",
                        eventDomain.getPrevious());
            break;                            
            case "nextButton":   
                openNewScene("/fxml/EventDetails.fxml", "Event",
                        eventDomain.getNext());
            break;
            case "resourceURIButton":
                try {
                    Desktop.getDesktop().browse(new URI(eventDomain.getResourceURI()));
                } catch (IOException | URISyntaxException ex) {
                    Logger.getLogger(EventFXMLDetailsController.class.getName()).log(Level.SEVERE, null, ex);
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
