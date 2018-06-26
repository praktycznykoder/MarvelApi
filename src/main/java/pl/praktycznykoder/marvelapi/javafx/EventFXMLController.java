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
import pl.praktycznykoder.marvelapi.model.services.EventAbstractServiceImpl;

/**
 *
 * @author praktycznykoder.pl
 */
public class EventFXMLController extends FXMLController {
    
    private final Service service = new EventAbstractServiceImpl();
    
    @FXML private TableView<Event> tableView;
    @FXML private TextField nameTextField;
    @FXML private TextField nameStartsWithTextField;
    @FXML private DatePicker modifiedSinceDatePicker;
    
    /**
     *
     * @return
     */
    @Override
    protected Service getService() {
        return service;
    }

    /**
     *
     * @return
     */
    @Override
    protected TableView getTableView() {
        return tableView;
    }
    
    /**
     *
     */
    @Override
    protected void beforeInit() {
        orderByIndex = 0;
    }
    
    /**
     *
     * @return
     */
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
    
    /**
     *
     * @param event
     */
    @Override 
    @FXML protected void showSelectedButtonAction(ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().
            getResource("/fxml/EventDetails.fxml"));     
        Stage stage = new Stage();
        Parent root = null;                       
        try {
            root = (Parent)fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(EventFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("/styles/Styless.css");        
        final Event eventDomain = tableView.getSelectionModel().getSelectedItem(); 
        stage.setTitle("Event - "+eventDomain.getTitle());
        stage.setScene(scene);       

        EventFXMLDetailsController controller = 
        fxmlLoader.<EventFXMLDetailsController>getController();
        controller.initData(eventDomain);
        
        stage.show();        
    }
    
    
}
    
