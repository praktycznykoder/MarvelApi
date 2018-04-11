package pl.praktycznykoder.marvelapi.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author praktycznykoder.pl
 */
public class AppFXMLController implements Initializable {
    
    @FXML
    BorderPane appBorderPane;
     
    @FXML protected void handleDataCharacterMenuItem(ActionEvent event) throws IOException {
        Node charactersNode = FXMLLoader.load(getClass().getResource("/fxml/Character.fxml"));        
        appBorderPane.setCenter(charactersNode);
    }
    @FXML protected void handleDataComicsMenuItem(ActionEvent event) throws IOException {
        Node comicsNode = FXMLLoader.load(getClass().getResource("/fxml/Comics.fxml"));        
        appBorderPane.setCenter(comicsNode);
    }    
    @FXML protected void handleDataCreatorMenuItem(ActionEvent event) throws IOException {
        Node creatorsNode = FXMLLoader.load(getClass().getResource("/fxml/Creator.fxml"));        
        appBorderPane.setCenter(creatorsNode);
    }  
    @FXML protected void handleDataEventMenuItem(ActionEvent event) throws IOException {
        Node eventsNode = FXMLLoader.load(getClass().getResource("/fxml/Event.fxml"));        
        appBorderPane.setCenter(eventsNode);
    }  
    @FXML protected void handleDataSeriesMenuItem(ActionEvent event) throws IOException {
        Node  seriesNode = FXMLLoader.load(getClass().getResource("/fxml/Series.fxml"));        
        appBorderPane.setCenter(seriesNode);
    }  
    @FXML protected void handleDataStoryMenuItem(ActionEvent event) throws IOException {
        Node storiesNode = FXMLLoader.load(getClass().getResource("/fxml/Story.fxml"));        
        appBorderPane.setCenter(storiesNode);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
}
