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
import pl.praktycznykoder.marvelapi.model.domain.Creator;
import pl.praktycznykoder.marvelapi.model.services.CreatorAbstractServiceImpl;

/**
 *
 * @author praktycznykoder.pl
 */
public class CreatorFXMLController extends FXMLController {
    
    private final Service service = new CreatorAbstractServiceImpl();
    
    @FXML private TableView<Creator> tableView;
    @FXML private TextField firstNameTextField;
    @FXML private TextField firstNameStartsWithTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField lastNameStartsWithTextField;
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
        
        String firstName = firstNameTextField.getText();
        String firstNameStartsWith = firstNameStartsWithTextField.getText();
        String lastName = lastNameTextField.getText();
        String lastNameStartsWith = lastNameStartsWithTextField.getText();
        LocalDate modifiedSince = modifiedSinceDatePicker.getValue();
        
        if(!firstName.isEmpty()) params.add(new Param("firstName", firstName));
        if(!firstNameStartsWith.isEmpty()) params.add(
                new Param("firstNameStartsWith", firstNameStartsWith));
        if(!lastName.isEmpty()) params.add(new Param("lastName", lastName));
        if(!lastNameStartsWith.isEmpty()) params.add(
                new Param("lastNameStartsWith", lastNameStartsWith));
        if(modifiedSince != null) params.add(
                new Param("modifiedSince", modifiedSince.toString()));
        return params.isEmpty() ? null : params;
    }
    
    @Override 
    @FXML protected void showSelectedButtonAction(ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().
            getResource("/fxml/CreatorDetails.fxml"));     
        Stage stage = new Stage();
        Parent root = null;                       
        try {
            root = (Parent)fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(CreatorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("/styles/Styless.css");        
        final Creator creator = tableView.getSelectionModel().getSelectedItem(); 
        stage.setTitle("Creator - "+creator.getFirstName()+" "+ 
                creator.getLastName());
        stage.setScene(scene);       

        CreatorFXMLDetailsController controller = 
        fxmlLoader.<CreatorFXMLDetailsController>getController();
        controller.initData(creator);
        
        stage.show();        
    }
    
    
}
    
