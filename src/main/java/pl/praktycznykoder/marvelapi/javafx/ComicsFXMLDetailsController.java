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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pl.praktycznykoder.marvelapi.model.domain.Comics;
import pl.praktycznykoder.marvelapi.model.domain.TextObject;
import pl.praktycznykoder.marvelapi.model.domain.others.Date;
import pl.praktycznykoder.marvelapi.model.domain.others.Image;
import pl.praktycznykoder.marvelapi.model.domain.others.Price;
import pl.praktycznykoder.marvelapi.model.domain.others.Url;
import pl.praktycznykoder.marvelapi.model.domain.remote.RemoteDomain;
import pl.praktycznykoder.marvelapi.model.services.ComicsAbstractServiceImpl;
import pl.praktycznykoder.marvelapi.model.services.Service;
import pl.praktycznykoder.marvelapi.model.domain.Character;
import pl.praktycznykoder.marvelapi.javafx.CharacterFXMLDetailsController;

/**
 *
 * @author User
 */
public class ComicsFXMLDetailsController extends FXMLDetailsController<Comics> {

    private final Service<Comics> service = new ComicsAbstractServiceImpl();
    @Override
    protected Service getService() {
        return service;
    }
    
    private Comics comics;
        
    @FXML private ImageView thumbnailImageView;
    @FXML private TextField idTextField;
    @FXML private TextField digitalIdTextField;
    @FXML private TextField titleTextField;
    @FXML private TextField issueNumberTextField;
    @FXML private TextField modyfiedTextField;
    @FXML private TextField upcTextField;
    @FXML private TextField eanTextField;
    @FXML private TextField issnTextField;
    @FXML private TextField diamondCodeTextField;
    @FXML private TextField formatTextField;
    @FXML private TextField pageCountTextField;
    @FXML private TextField isbnTextField;
    @FXML private TextArea variantDescriptionTextArea;
    @FXML private TextArea descriptionTextArea;
    
    @FXML private ComboBox<TextObject> textObjectsComboBox;
    //Comics
    @FXML private ComboBox<RemoteDomain> variantsComboBox;
    //Comics
    @FXML private ComboBox<RemoteDomain> collectionsComboBox;
    //Comics
    @FXML private ComboBox<RemoteDomain> collectedIssuesComboBox;
    @FXML private ComboBox<Url> urlsComboBox;
    @FXML private ComboBox<Date> datesComboBox;
    @FXML private ComboBox<Price> pricesComboBox;
    @FXML private ComboBox<Image> imagesComboBox;
    @FXML private ComboBox<RemoteDomain> creatorsComboBox;
    @FXML private ComboBox<RemoteDomain> charactersComboBox;
    @FXML private ComboBox<RemoteDomain> storiesComboBox;
    @FXML private ComboBox<RemoteDomain> eventsComboBox;

    
        
    @Override
    protected void initFields() {
        thumbnailImageView.setImage(
                getImage(comics.getThumbnail().toString()));
        idTextField.setText(comics.getId()+"");
        digitalIdTextField.setText(comics.getDigitalId()+"");
        titleTextField.setText(comics.getTitle());
        issueNumberTextField.setText(comics.getIssueNumber()+"");
        modyfiedTextField.setText(comics.getVariantDescription());
        upcTextField.setText(comics.getDescription());
        eanTextField.setText(comics.getModified());
        issnTextField.setText(comics.getIssn());
        diamondCodeTextField.setText(comics.getDiamondCode());
        formatTextField.setText(comics.getFormat());
        pageCountTextField.setText(comics.getPageCount()+"");
        isbnTextField.setText(comics.getIsbn());
        
        variantDescriptionTextArea.setText(comics.getVariantDescription());
        descriptionTextArea.setText(comics.getDescription());
        
        
        textObjectsComboBox.getItems().addAll(comics.getTextObjects());
        disableComboBoxWhereIsEmpty(textObjectsComboBox);
        variantsComboBox.getItems().addAll(comics.getVariants());
        disableComboBoxWhereIsEmpty(variantsComboBox);
        collectionsComboBox.getItems().addAll(comics.getCollections());
        disableComboBoxWhereIsEmpty(collectionsComboBox);
        collectedIssuesComboBox.getItems().addAll(comics.getCollectedIssues());
        disableComboBoxWhereIsEmpty(collectedIssuesComboBox);
        urlsComboBox.getItems().addAll(comics.getUrls());
        disableComboBoxWhereIsEmpty(urlsComboBox);
        datesComboBox.getItems().addAll(comics.getDates());        
        disableComboBoxWhereIsEmpty(datesComboBox);
        pricesComboBox.getItems().addAll(comics.getPrices());        
        disableComboBoxWhereIsEmpty(pricesComboBox);
        imagesComboBox.getItems().addAll(comics.getImages());        
        disableComboBoxWhereIsEmpty(imagesComboBox);
        
        creatorsComboBox.getItems().addAll(comics.getCreators().getItems());
        disableComboBoxWhereIsEmpty(creatorsComboBox);
        
        charactersComboBox.getItems().addAll(comics.getCharacters().getItems());
        disableComboBoxWhereIsEmpty(charactersComboBox);
        
        storiesComboBox.getItems().addAll(comics.getStories().getItems());
        disableComboBoxWhereIsEmpty(storiesComboBox);
        
        eventsComboBox.getItems().addAll(comics.getEvents().getItems());
        disableComboBoxWhereIsEmpty(eventsComboBox);
        
    }
    
    @Override
    public void initData(Comics comics){
        this.comics = comics;
        initFields();
    }
    
    @Override
    public void initData(RemoteDomain remoteDomain) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            case "creatorsButton":   
                openNewScene("/fxml/CreatorDetails.fxml", "Creator",
                        creatorsComboBox);
            break;
            case "charactersButton":   
                openNewScene("/fxml/CharacterDetails.fxml", "Character",
                        charactersComboBox);
            break;
            case "storiesButton":   
                openNewScene("/fxml/StoryDetails.fxml", "Story",
                        storiesComboBox);
            break;
            case "eventsButton":   
                openNewScene("/fxml/EventDetails.fxml", "Event",
                        eventsComboBox);
            break;
            
                    
            case "seriesButton":   
                openNewScene("/fxml/EventDetails.fxml", "Series",
                        comics.getSeries());
            break;            
            case "resourceURIButton":
                try {
                    Desktop.getDesktop().browse(new URI(comics.getResourceURI()));
                } catch (IOException | URISyntaxException ex) {
                    Logger.getLogger(CharacterFXMLDetailsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            break;
            
            case "textObjectsButton":  
                
            break;
            case "datesButton":  
                
            break;
            case "pricesButton":  
                
            break;
            
            case "variantsButton":   
                openNewScene("/fxml/ComicsDetails.fxml", "Comics - variant",
                        variantsComboBox);
            break;
            case "collectionsButton":   
                openNewScene("/fxml/ComicsDetails.fxml", "Comics - collection",
                        collectionsComboBox);
            break;
            case "collectedIssuesButton":   
                openNewScene("/fxml/ComicsDetails.fxml", "Comics - collected issue",
                        collectedIssuesComboBox);
            break;
            case "urlsComboBox":   
                Url url = urlsComboBox.getSelectionModel().getSelectedItem();
                try {
                    Desktop.getDesktop().browse(new URI(url.getUrl()));
                } catch (IOException | URISyntaxException ex) {
                    Logger.getLogger(CharacterFXMLDetailsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            break;
            
            
            case "imagesButton":  
                
            break;
                
                
                
            default:
                break;
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) { }


    
}
