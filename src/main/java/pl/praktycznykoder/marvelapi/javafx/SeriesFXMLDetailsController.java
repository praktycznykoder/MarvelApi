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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
    @Override
    protected Service getService() {
        return service;
    }
    
    private Series seriesDomain;
        
    @FXML private ImageView thumbnailImageView;
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
            
    @Override
    protected void initFields() {
        thumbnailImageView.setImage(
                getImage(seriesDomain.getThumbnail().toString()));
        idTextField.setText(seriesDomain.getId()+"");
        titleTextField.setText(seriesDomain.getTitle());       
        descriptionTextArea.setText(seriesDomain.getId()+"");
        modifiedTextField.setText(seriesDomain.getModified());
        startTextField.setText(seriesDomain.getStart());
        endTextField.setText(seriesDomain.getEnd());
        
        resourceURITextField.setText(seriesDomain.getResourceURI());
        
        
        urlsComboBox.getItems().addAll(seriesDomain.getUrls());
        disableComboBoxWhereIsEmpty(urlsComboBox);
        
        comicsComboBox.getItems().addAll(seriesDomain.getComics().getItems());
        disableComboBoxWhereIsEmpty(comicsComboBox);
        
        storiesComboBox.getItems().addAll(seriesDomain.getStories().getItems());
        disableComboBoxWhereIsEmpty(storiesComboBox);
        
        seriesComboBox.getItems().addAll(seriesDomain.getSeries().getItems());
        disableComboBoxWhereIsEmpty(seriesComboBox);
        
        charactersComboBox.getItems().addAll(seriesDomain.getCharacters().getItems());
        disableComboBoxWhereIsEmpty(charactersComboBox);
        
        creatorsComboBox.getItems().addAll(seriesDomain.getCreators().getItems());
        disableComboBoxWhereIsEmpty(creatorsComboBox);
    }
    
    @Override
    public void initData(Series seriesDomain){
        this.seriesDomain = seriesDomain;
        initFields();
    }
    
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
    protected void getResourceButtonOnAction(ActionEvent event){
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
                        seriesDomain.getPrevious());
            break;                            
            case "nextButton":   
                openNewScene("/fxml/EventDetails.fxml", "Event",
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
