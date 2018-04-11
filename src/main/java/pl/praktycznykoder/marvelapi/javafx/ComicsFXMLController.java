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
import pl.praktycznykoder.marvelapi.model.domain.Comics;
import pl.praktycznykoder.marvelapi.model.services.ComicsAbstractServiceImpl;
import pl.praktycznykoder.marvelapi.model.services.Service;

/**
 *
 * @author praktycznykoder.pl
 */
public class ComicsFXMLController extends FXMLController {
    
    private final ComicsAbstractServiceImpl service = new ComicsAbstractServiceImpl();
    
    @FXML private TableView<Comics> tableView;
    @FXML private TextField titleTextFieldTextField;
    @FXML private TextField titleStartsWithTextField;
    @FXML private TextField startYearTextField;
    @FXML private TextField issueNumberTextField;
    @FXML private TextField diamondCodeTextField;
    @FXML private TextField digitalIdTextField;
    @FXML private TextField upcTextField;
    @FXML private TextField isbnTextField;
    @FXML private TextField eanTextField;
    @FXML private TextField issnTextField;
        
    @FXML private ComboBox<String> formatComboBox;
    @FXML private ComboBox<String> formatTypeComboBox;
    @FXML private ComboBox<String> noVariantsComboBox;
    @FXML private ComboBox<String> dateDescriptorComboBox;
    @FXML private ComboBox<String> hasDigitalIssueComboBox;
    
    @FXML private DatePicker modifiedSinceDatePicker;
    

    @Override
    protected Service getService() {
        return service;
    }

    @Override
    protected TableView getTableView() {
        return tableView;
    }
//    public static String[] FORM_PARAM_NAMES = new String[]{
//        "title", 
//        "titleStartsWith", "startYear", "issueNumber", "diamondCode",
//        "format", "formatType", "noVariants", "dateDescriptor",
//        "digitalId", "upc", "isbn", "ean", "issn", "hasDigitalIssue",
//        "modifiedSince"
//    };
    
    @Override
    protected void beforeInit() {
        orderByIndex = 9;
        formatComboBox.getItems().addAll(service.getFormatParamNodes());
        formatTypeComboBox.getItems().addAll(service.getFormatTypeParamNodes());
        dateDescriptorComboBox.getItems().addAll(
                service.getDateDescriptorParamNodes());
        noVariantsComboBox.getItems().addAll(
                service.getThreeBooleanState());
        hasDigitalIssueComboBox.getItems().addAll(
                service.getThreeBooleanState());
    }
    
    @Override
    protected List<Param> getParamsFromForm() {
        List<Param> params = getNewListParamWithOrderBy();
        String title = titleTextFieldTextField.getText();
        if(!title.isEmpty()) params.add(new Param("title", title));
        String titleStartsWith = titleStartsWithTextField.getText();
        if(!titleStartsWith.isEmpty()) params.add(
                new Param("titleStartsWith", titleStartsWith));
        String startYear = startYearTextField.getText();
        if(!startYear.isEmpty()) params.add(new Param("startYear", startYear));
        String issueNumber = issueNumberTextField.getText();
        if(!issueNumber.isEmpty()) params.add(
                new Param("issueNumber", issueNumber));
        String diamondCode = diamondCodeTextField.getText();
        if(!diamondCode.isEmpty()) params.add(new Param("diamondCode", diamondCode));
        String digitalId = digitalIdTextField.getText();
        if(!digitalId.isEmpty()) params.add(new Param("digitalId", digitalId));
        String upc = upcTextField.getText();
        if(!upc.isEmpty()) params.add(new Param("upc", upc));
        String isbn = isbnTextField.getText();
        if(!isbn.isEmpty()) params.add(new Param("isbn", isbn));
        String ean = eanTextField.getText();
        if(!ean.isEmpty()) params.add(new Param("ean", ean));
        String issn = issnTextField.getText();
        if(!issn.isEmpty()) params.add(new Param("issn", issn));
        
        String format = formatComboBox.getSelectionModel().
                getSelectedItem();
        if(format != null && !format.isEmpty()) params.add(new Param("format", format));
        String formatType = formatTypeComboBox.getSelectionModel().
                getSelectedItem();
        if(formatType != null && !formatType.isEmpty()) params.add(
                new Param("formatType", formatType));
        String noVariants = noVariantsComboBox.getSelectionModel().
                getSelectedItem();
        if(noVariants != null && !noVariants.isEmpty()) params.add(
                new Param("noVariants", noVariants));
        String dateDescriptor = dateDescriptorComboBox.getSelectionModel().
                getSelectedItem();
        if(dateDescriptor != null && !dateDescriptor.isEmpty()) params.add(
                new Param("dateDescriptor", dateDescriptor));
        String hasDigitalIssue = hasDigitalIssueComboBox.getSelectionModel().
                getSelectedItem();
        if(hasDigitalIssue != null && !hasDigitalIssue.isEmpty()) params.add(
                new Param("hasDigitalIssue", hasDigitalIssue));
                
        LocalDate modifiedSince = modifiedSinceDatePicker.getValue();
        if(modifiedSince != null) params.add(
                new Param("modifiedSince", modifiedSince.toString()));
       
        return params.isEmpty() ? null : params;
    }
    
    @Override        
    @FXML protected void showSelectedButtonAction(ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().
            getResource("/fxml/ComicsDetails.fxml"));     
        Stage stage = new Stage();
        Parent root = null;                       
        try {
            root = (Parent)fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(CharacterFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("/styles/Styless.css");
        final Comics comics = tableView.getSelectionModel().getSelectedItem(); 
        stage.setTitle("Comics - "+comics.getTitle());
        stage.setScene(scene);       

        ComicsFXMLDetailsController controller = 
        fxmlLoader.<ComicsFXMLDetailsController>getController();
        controller.initData(comics);
        
        stage.show();        
    }
}
