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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.praktycznykoder.api.domain.Param;
import pl.praktycznykoder.marvelapi.model.services.Service;
import pl.praktycznykoder.marvelapi.model.domain.Series;
import pl.praktycznykoder.marvelapi.model.services.SeriesAbstractServiceImpl;

/**
 *
 * @author praktycznykoder.pl
 */
public class SeriesFXMLController extends FXMLController {
    
    private final Service service = new SeriesAbstractServiceImpl();
    
    @FXML private TableView<Series> tableView;
    @FXML private TextField titleTextField;
    @FXML private TextField titleStartsWithTextField;
    @FXML private TextField startYearTextField;
    
    @FXML private ComboBox<String> seriesTypeComboBox;
    @FXML private ComboBox<String> containsComboBox;
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
        seriesTypeComboBox.getItems().addAll(
                ((SeriesAbstractServiceImpl)service).getSeriesType());
        containsComboBox.getItems().addAll(
                ((SeriesAbstractServiceImpl)service).getContains());
    }
    
    @Override
    protected List<Param> getParamsFromForm(){
        List<Param> params = getNewListParamWithOrderBy();
        
        String title = titleTextField.getText();
        if(!title.isEmpty()) params.add(new Param("title", title));
        String titleStartsWith = titleStartsWithTextField.getText();
        if(!titleStartsWith.isEmpty()) params.add(
                new Param("titleStartsWith", titleStartsWith));
        String startYear = startYearTextField.getText();
        if(!startYear.isEmpty()) params.add(
                new Param("startYear", titleStartsWith));
        
        String seriesType = seriesTypeComboBox.getSelectionModel().
                getSelectedItem();
        if(seriesType != null && !seriesType.isEmpty()) params.add(
                new Param("seriesType", seriesType));
        
        String contains = containsComboBox.getSelectionModel().
                getSelectedItem();
        if(contains != null && !contains.isEmpty()) params.add(
                new Param("contains", contains));
        
        LocalDate modifiedSince = modifiedSinceDatePicker.getValue();
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
    
