package pl.praktycznykoder.marvelapi.javafx;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;
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
        ObservableList<Comics> items = tableView.getItems();
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
