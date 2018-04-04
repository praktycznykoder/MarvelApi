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
import javafx.scene.control.Button;
import pl.praktycznykoder.marvelapi.model.domain.Comics;
import pl.praktycznykoder.marvelapi.model.services.ComicsAbstractServiceImpl;
import pl.praktycznykoder.marvelapi.model.services.Service;

/**
 *
 * @author User
 */
public class ComicsFXMLDetailsController extends FXMLDetailsController<Comics> {

    private final Service service = new ComicsAbstractServiceImpl();
    private Comics comics;
        
    @Override
    protected void initFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void initData(Comics comics){
        this.comics = comics;
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
        
      if(id.equals("resourceURIButton")){
        switch (id) {
//            case "urlsButton":
//                System.out.println(urlsComboBox.getSelectionModel().
//                        getSelectedItem());
//                break;
//            case "comicsButton":
//                System.out.println(comicsComboBox.getSelectionModel().
//                        getSelectedItem());
//                break;
//            case "seriesButton":
//                System.out.println(seriesComboBox.getSelectionModel().
//                        getSelectedItem());
//                break;
//            case "eventsButton":
//                System.out.println(eventsComboBox.getSelectionModel().
//                        getSelectedItem());
//                break;
//            case "storiesButton":
//                System.out.println(storiesComboBox.getSelectionModel().
//                        getSelectedItem());
//                break;
            case "resourceURIButton":
                try {
                    Desktop.getDesktop().browse(new URI(comics.getResourceURI()));
                } catch (IOException | URISyntaxException ex) {
                    Logger.getLogger(CharacterFXMLDetailsController.class.getName()).log(Level.SEVERE, null, ex);
                }   break;
            default:
                break;
        }
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) { }

    
}
