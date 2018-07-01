/*
 * Copyright (C) 2018 praktycznykoder.pl
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package pl.praktycznykoder.marvelapi.javafx.controllers;

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
        seriesTypeComboBox.getItems().addAll(
                ((SeriesAbstractServiceImpl)service).getSeriesType());
        containsComboBox.getItems().addAll(
                ((SeriesAbstractServiceImpl)service).getContains());
    }
    
    /**
     *
     * @return
     */
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
    
    /**
     *
     * @param event
     */
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
        if(seriesDomain == null) return;
        stage.setTitle("Series - "+seriesDomain.getTitle());
        stage.setScene(scene);       

        SeriesFXMLDetailsController controller = 
        fxmlLoader.<SeriesFXMLDetailsController>getController();
        controller.initData(seriesDomain);
        
        stage.show();        
    }
    
    
}
    
