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
import pl.praktycznykoder.marvelapi.model.domain.Comics;
import pl.praktycznykoder.marvelapi.model.domain.others.Image;
import pl.praktycznykoder.marvelapi.model.domain.others.Url;
import pl.praktycznykoder.marvelapi.model.domain.remote.RemoteDomain;
import pl.praktycznykoder.marvelapi.model.services.ComicsAbstractServiceImpl;
import pl.praktycznykoder.marvelapi.model.services.Service;

/**
 *
 * @author praktycznykoder.pl
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
    @FXML private TextField resourceURITextField;
    @FXML private TextArea descriptionTextArea;
    
    @FXML private TextArea textObjectsTextArea;
    @FXML private TextArea pricesTextArea;
    @FXML private TextArea datesTextArea;
    
    //Comics
    @FXML private ComboBox<RemoteDomain> variantsComboBox;
    //Comics
    @FXML private ComboBox<RemoteDomain> collectionsComboBox;
    //Comics
    @FXML private ComboBox<RemoteDomain> collectedIssuesComboBox;
    @FXML private ComboBox<Image> imagesComboBox;
    @FXML private ComboBox<RemoteDomain> creatorsComboBox;
    @FXML private ComboBox<RemoteDomain> charactersComboBox;
    @FXML private ComboBox<RemoteDomain> storiesComboBox;
    @FXML private ComboBox<RemoteDomain> eventsComboBox;
    @FXML private ComboBox<Url> urlsComboBox;

    
        
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
        resourceURITextField.setText(comics.getResourceURI());
        pageCountTextField.setText(comics.getPageCount()+"");
        isbnTextField.setText(comics.getIsbn());
        
        variantDescriptionTextArea.setText(comics.getVariantDescription());
        descriptionTextArea.setText(comics.getDescription());
        
        setArrayObjectToTextArea(comics.getTextObjects(), textObjectsTextArea);
        setArrayObjectToTextArea(comics.getPrices(), pricesTextArea);
        setArrayObjectToTextArea(comics.getDates(), datesTextArea);
                
        variantsComboBox.getItems().addAll(comics.getVariants());
        disableComboBoxWhereIsEmpty(variantsComboBox);
        collectionsComboBox.getItems().addAll(comics.getCollections());
        disableComboBoxWhereIsEmpty(collectionsComboBox);
        collectedIssuesComboBox.getItems().addAll(comics.getCollectedIssues());
        disableComboBoxWhereIsEmpty(collectedIssuesComboBox);
        urlsComboBox.getItems().addAll(comics.getUrls());
        disableComboBoxWhereIsEmpty(urlsComboBox);   
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
        try {
            this.comics = service.getObjectWithUrl(remoteDomain.getResourceURI(), null);
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
            case "urlsButton":   
                openDesktopBrowserFromComboBoxUrl(urlsComboBox);
            break;
            
            
            case "imagesButton":
                Image image = imagesComboBox.getSelectionModel().getSelectedItem();
                openImageScene(image);
            break;
                
                
                
            default:
                System.out.println("switch dont have this id");
                break;
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) { }


    
}
