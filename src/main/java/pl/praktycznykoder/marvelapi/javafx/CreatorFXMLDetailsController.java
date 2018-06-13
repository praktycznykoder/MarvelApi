/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
    @Override
    protected Service getService() {
        return service;
    }
    
    private Creator creator;
        
    @FXML private ImageView thumbnailImageView;
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
            
    @Override
    protected void initFields() {
        thumbnailImageView.setImage(
                getImage(creator.getThumbnail().toString()));
        idTextField.setText(creator.getId()+"");
        firstNameTextField.setText(creator.getFirstName());
        middleNameTextField.setText(creator.getMiddleName());
        lastNameTextField.setText(creator.getLastName());
        fullNameTextField.setText(creator.getFullName());
        suffixTextField.setText(creator.getSuffix());
        modifiedTextField.setText(creator.getModified());
        resourceURITextField.setText(creator.getResourceURI());
        urlsComboBox.getItems().addAll(creator.getUrls());
        disableComboBoxWhereIsEmpty(urlsComboBox);
        
        comicsComboBox.getItems().addAll(creator.getComics().getItems());
        disableComboBoxWhereIsEmpty(comicsComboBox);
        
        storiesComboBox.getItems().addAll(creator.getStories().getItems());
        disableComboBoxWhereIsEmpty(storiesComboBox);
        
        seriesComboBox.getItems().addAll(creator.getSeries().getItems());
        disableComboBoxWhereIsEmpty(seriesComboBox);
        
        eventsComboBox.getItems().addAll(creator.getEvents().getItems());
        disableComboBoxWhereIsEmpty(eventsComboBox);
                
        
        
        
        
    }
    
    @Override
    public void initData(Creator creator){
        this.creator = creator;
        initFields();
    }
    
    @Override
    public void initData(DomainWraper remoteDomain) {
        try {
            this.creator = service.getObjectWithUrl(remoteDomain.getResourceURI(), null);
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
    protected void getResourceButtonOnAction(ActionEvent event){
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
                    Desktop.getDesktop().browse(new URI(creator.getResourceURI()));
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