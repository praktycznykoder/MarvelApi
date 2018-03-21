package pl.praktycznykoder.marvelapi.javafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import pl.praktycznykoder.marvelapi.model.domain.Comics;
import pl.praktycznykoder.marvelapi.model.services.ComicsAbstractServiceImpl;
import pl.praktycznykoder.marvelapi.model.services.Service;

public class ComicsFXMLController implements Initializable {
    
    Service service = new ComicsAbstractServiceImpl();
    
    @FXML
    private TableView<Comics> tableView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableView.getItems().addAll(service.getObjects(null, 0));
    }    
}
