package pl.praktycznykoder.marvelapi.javafx;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
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
import pl.praktycznykoder.marvelapi.model.domain.others.Url;
import pl.praktycznykoder.marvelapi.model.domain.remote.RemoteDomain;

public class CharacterFXMLDetailsController extends FXMLDetailsController<Character> {
    
    private final Service service = new CharacterAbstractServiceImpl();     
    private Character character;
        
    @FXML private ImageView thumbnailImageView;
    @FXML private TextField idTextField;
    @FXML private TextField nameTextField;
    @FXML private TextField modyfiedTextField;
    @FXML private TextArea descriptionTextArea;
    @FXML private ComboBox<Url> urlsComboBox;
    @FXML private ComboBox<RemoteDomain> comicsComboBox;
    @FXML private ComboBox<RemoteDomain> seriesComboBox;
    @FXML private ComboBox<RemoteDomain> eventsComboBox;
    @FXML private ComboBox<RemoteDomain> storiesComboBox;
    
    private final int EMPTY_ITEMS = 0;
    private void disableComboBoxWhereIsEmpty(ComboBox comboBox){
        if(comboBox.getItems().size()<=EMPTY_ITEMS){
            comboBox.setDisable(true);
        }
    }
    
    /**
     *
     * @throws NullPointerException
     */
    @Override
    protected void initFields() throws java.lang.NullPointerException{
        
        try {
            BufferedImage image = service.getImage(character.getThumbnail().toString());
            thumbnailImageView.setImage(SwingFXUtils.toFXImage(image, null));
        } catch (IOException ex) {
            Logger.getLogger(CharacterFXMLDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        idTextField.setText(character.getId()+"");
        nameTextField.setText(character.getName());
        modyfiedTextField.setText(character.getModified());
        descriptionTextArea.setText(character.getDecription());
        
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
                System.out.println(urlsComboBox.getSelectionModel().
                        getSelectedItem());
                break;
            case "comicsButton":
                System.out.println(comicsComboBox.getSelectionModel().
                        getSelectedItem());
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
            case "resourceURIButton":
                try {
                    Desktop.getDesktop().browse(new URI(character.getResourceURI()));
                } catch (IOException | URISyntaxException ex) {
                    Logger.getLogger(CharacterFXMLDetailsController.class.getName()).log(Level.SEVERE, null, ex);
                }   break;
            default:
                break;
        }
    }            
            
    @Override
    public void initialize(URL url, ResourceBundle rb) { }    
}
