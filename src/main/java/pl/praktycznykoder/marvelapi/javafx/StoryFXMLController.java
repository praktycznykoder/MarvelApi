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
import javafx.stage.Stage;
import pl.praktycznykoder.api.domain.Param;
import pl.praktycznykoder.marvelapi.model.services.Service;
import pl.praktycznykoder.marvelapi.model.domain.Story;
import pl.praktycznykoder.marvelapi.model.services.StoryAbstractServiceImpl;

/**
 *
 * @author praktycznykoder.pl
 */
public class StoryFXMLController extends FXMLController {
    
    private final Service service = new StoryAbstractServiceImpl();
    
    @FXML private TableView<Story> tableView;
    
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
              
        LocalDate modifiedSince = modifiedSinceDatePicker.getValue();
        if(modifiedSince != null) params.add(
                new Param("modifiedSince", modifiedSince.toString()));
        
        return params.isEmpty() ? null : params;
    }
    
    @Override 
    @FXML protected void showSelectedButtonAction(ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().
            getResource("/fxml/StoryDetails.fxml"));     
        Stage stage = new Stage();
        Parent root = null;                       
        try {
            root = (Parent)fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(StoryFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("/styles/Styless.css");        
        final Story storyDomain = tableView.getSelectionModel().getSelectedItem(); 
        stage.setTitle("Story - "+storyDomain.getTitle());
        stage.setScene(scene);       

        StoryFXMLDetailsController controller = 
        fxmlLoader.<StoryFXMLDetailsController>getController();
        controller.initData(storyDomain);
        
        stage.show();        
    }
    
    
}
    
