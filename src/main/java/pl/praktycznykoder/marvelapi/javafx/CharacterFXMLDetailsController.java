package pl.praktycznykoder.marvelapi.javafx;

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
import javafx.scene.image.ImageView;
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
    
    @Override
    protected Service getService() {
        return service;
    }
    
    private Character character;
        
    @FXML private ImageView thumbnailImageView;
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
    
    /**
     *
     * @throws NullPointerException
     */
    @Override
    protected void initFields() throws java.lang.NullPointerException{
        
        thumbnailImageView.setImage(
                getImage(character.getThumbnail().toString()));
        idTextField.setText(character.getId()+"");
        nameTextField.setText(character.getName());
        modyfiedTextField.setText(character.getModified());
        resourceURITextField.setText(character.getResourceURI());
        descriptionTextArea.setText(character.getDescription());
        
        urlsComboBox.getItems().addAll(character.getUrls());
        disableComboBoxWhereIsEmpty(urlsComboBox);
                         
        comicsComboBox.getItems().addAll(character.getComics().getItems());        
        disableComboBoxWhereIsEmpty(comicsComboBox);
        
        seriesComboBox.getItems().addAll(character.getSeries().getItems());
        disableComboBoxWhereIsEmpty(seriesComboBox);
        
        eventsComboBox.getItems().addAll(character.getEvents().getItems());
        disableComboBoxWhereIsEmpty(eventsComboBox);
        
        storiesComboBox.getItems().addAll(character.getStories().getItems());
        disableComboBoxWhereIsEmpty(storiesComboBox);
    }
        
    /**
     *
     * @param character
     */
    @Override
    public void initData(Character character){
        this.character = character;
        initFields();
    }
 
    @Override
    public void initData(DomainWraper remoteDomain) {
        try {
            this.character = service.getObjectWithUrl(remoteDomain.getResourceURI(), null);
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
            case "urlsButton":                
                    openDesktopBrowserFromComboBoxUrl(urlsComboBox);
                break;
            case "comicsButton":
                openNewScene("/fxml/ComicsDetails.fxml", "Comics",
                        comicsComboBox);
                break;
            case "seriesButton":
                System.out.println(seriesComboBox.getSelectionModel().
                        getSelectedItem());
                break;
            case "eventsButton":
                System.out.println(eventsComboBox.getSelectionModel().
                        getSelectedItem());
                break;
            case "storiesButton":
                System.out.println(storiesComboBox.getSelectionModel().
                        getSelectedItem());
                break;
            default:
                break;
        }
    }            
            
    @Override
    public void initialize(URL url, ResourceBundle rb) { }    

}
