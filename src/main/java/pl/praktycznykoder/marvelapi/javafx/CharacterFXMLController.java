package pl.praktycznykoder.marvelapi.javafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import pl.praktycznykoder.marvelapi.model.services.CharacterAbstractServiceImpl;
import pl.praktycznykoder.marvelapi.model.services.Service;

public class CharacterFXMLController implements Initializable {
    
    Service service = new CharacterAbstractServiceImpl();
    
    @FXML
    private TableView<Character> tableView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableView.getItems().addAll(service.getObjects(null, 0));
    }    
}
