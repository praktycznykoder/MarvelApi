package pl.praktycznykoder.marvelapi.javafx;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.praktycznykoder.api.domain.Param;
import pl.praktycznykoder.marvelapi.model.services.Service;
import pl.praktycznykoder.marvelapi.model.domain.Event;
import pl.praktycznykoder.marvelapi.model.domain.Series;
import pl.praktycznykoder.marvelapi.model.services.EventAbstractServiceImpl;

/**
 *
 * @author praktycznykoder.pl
 */
public class SeriesFXMLController extends FXMLController {
    
    private final Service service = new EventAbstractServiceImpl();
    
    @FXML private TableView<Series> tableView;
    @FXML private TextField nameTextField;
    @FXML private TextField nameStartsWithTextField;
    @FXML private DatePicker modifiedSinceDatePicker;
    
    @Override
    protected Service getService() {
        return service;
    }
    @Override
    protected TableView getTableView() {
        return tableView;
    }
    
    @Override
    protected void beforeInit() {
        orderByIndex = 0;
    }
    
    @Override
    protected List<Param> getParamsFromForm(){
        List<Param> params = getNewListParamWithOrderBy();
        
        String name = nameTextField.getText();
        String nameStartsWith = nameStartsWithTextField.getText();
        LocalDate modifiedSince = modifiedSinceDatePicker.getValue();
        
        if(!name.isEmpty()) params.add(new Param("name", name));
        if(!nameStartsWith.isEmpty()) params.add(
                new Param("nameStartsWith", nameStartsWith));
        if(modifiedSince != null) params.add(
                new Param("modifiedSince", modifiedSince.toString()));
        return params.isEmpty() ? null : params;
    }
    
    @Override 
    @FXML protected void showSelectedButtonAction(ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().
            getResource("/fxml/SeriesDetails.fxml"));     
        Stage stage = new Stage();
        Parent root = null;                       
        try {
            root = (Parent)fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(SeriesFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("/styles/Styless.css");        
        final Series seriesDomain = tableView.getSelectionModel().getSelectedItem(); 
        stage.setTitle("Series - "+seriesDomain.getTitle());
        stage.setScene(scene);       

        SeriesFXMLDetailsController controller = 
        fxmlLoader.<SeriesFXMLDetailsController>getController();
        controller.initData(seriesDomain);
        
        stage.show();        
    }
    
    
}
    
