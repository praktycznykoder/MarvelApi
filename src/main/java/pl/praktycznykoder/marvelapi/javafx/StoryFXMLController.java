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
    
