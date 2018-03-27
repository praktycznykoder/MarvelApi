package pl.praktycznykoder.marvelapi.javafx;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
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

public class CharacterFXMLController implements Initializable {
    
    Service service = new CharacterAbstractServiceImpl();
    
    @FXML
    private TableView<Character> tableView;
    
    @FXML protected void showDetailsTableViewSelectAction(ActionEvent event){
        final Character character = tableView.getSelectionModel().getSelectedItem();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/App.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(CharacterFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Application app =  new Application() {
            @Override
            public void start(Stage primaryStage) throws Exception {
                
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().
                        getResource("/fxml/CharacterDetails.fxml"));     

                Parent root = (Parent)fxmlLoader.load();                       
            
                Scene scene = new Scene(root);
                scene.getStylesheets().add("/styles/Styless.css");        
                primaryStage.setTitle("Characters");

                primaryStage.setScene(scene);
                primaryStage.show();
                CharacterFXMLDetailsViewController controller = 
                        fxmlLoader.<CharacterFXMLDetailsViewController>getController();
                controller.setData(character);
            
            }
        };
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<Character> items = tableView.getItems();
        if(items.isEmpty()){
            new Runnable() {
                @Override
                public void run() {                
                    System.out.println("1");
                    try {
                        tableView.getItems().addAll(service.getObjects(null, 0));
                    } catch (NoSuchAlgorithmException ex) {
                        org.apache.log4j.Logger.getLogger(ComicsFXMLController.class.getName()).error("GET_ITEMS", ex);
                    } catch (URISyntaxException ex) {
                        org.apache.log4j.Logger.getLogger(ComicsFXMLController.class.getName()).error("GET_ITEMS", ex);
                    } catch (IOException ex) {
                        org.apache.log4j.Logger.getLogger(ComicsFXMLController.class.getName()).error("GET_ITEMS", ex);
                    }
                    System.out.println("2");
                    tableView.refresh();
                }
            }.run();
        }
        
    }    
}
