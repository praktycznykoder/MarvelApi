package pl.praktycznykoder.marvelapi.javafx;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import pl.praktycznykoder.marvelapi.model.services.CharacterAbstractServiceImpl;
import pl.praktycznykoder.marvelapi.model.services.Service;
import pl.praktycznykoder.marvelapi.model.domain.Character;

public class CharacterFXMLController implements Initializable {
    
    private final Service service = new CharacterAbstractServiceImpl();
    
    @FXML private TableView<Character> tableView;
    
    @FXML protected void showSelectedButtonAction(ActionEvent event){        
       
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().
            getResource("/fxml/CharacterDetails.fxml"));     
        Stage stage = new Stage();
        Parent root = null;                       
        try {
            root = (Parent)fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(CharacterFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);
        //scene.getStylesheets().add("/styles/Styless.css");        
        
        final Character character = tableView.getSelectionModel().getSelectedItem(); 
        stage.setTitle("Characters - "+character.getName());
        stage.setScene(scene);       

        CharacterFXMLDetailsController controller = 
        fxmlLoader.<CharacterFXMLDetailsController>getController();
        controller.initData(character);
        
        stage.show();        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        ObservableList<Character> items = tableView.getItems();
        if(items.isEmpty()){
            new Runnable() {
                @Override
                public void run() {          
                    try {
                        tableView.getItems().addAll(service.getObjects(null, 0));
                    } catch (NoSuchAlgorithmException ex) {
                        org.apache.log4j.Logger.getLogger(ComicsFXMLController.class.getName()).error("GET_ITEMS", ex);
                    } catch (URISyntaxException ex) {
                        org.apache.log4j.Logger.getLogger(ComicsFXMLController.class.getName()).error("GET_ITEMS", ex);
                    } catch (IOException ex) {
                        org.apache.log4j.Logger.getLogger(ComicsFXMLController.class.getName()).error("GET_ITEMS", ex);
                    }
                    tableView.refresh();
                }
            }.run();
        }        
    }    
}
