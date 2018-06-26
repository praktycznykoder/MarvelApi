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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author praktycznykoder.pl
 */
public class AppFXMLController implements Initializable {
    
    @FXML
    BorderPane appBorderPane;
     
    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML protected void handleDataCharacterMenuItem(ActionEvent event) throws IOException {
        Node charactersNode = FXMLLoader.load(getClass().getResource("/fxml/Character.fxml"));        
        appBorderPane.setCenter(charactersNode);
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML protected void handleDataComicsMenuItem(ActionEvent event) throws IOException {
        Node comicsNode = FXMLLoader.load(getClass().getResource("/fxml/Comics.fxml"));        
        appBorderPane.setCenter(comicsNode);
    }    

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML protected void handleDataCreatorMenuItem(ActionEvent event) throws IOException {
        Node creatorsNode = FXMLLoader.load(getClass().getResource("/fxml/Creator.fxml"));        
        appBorderPane.setCenter(creatorsNode);
    }  

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML protected void handleDataEventMenuItem(ActionEvent event) throws IOException {
        Node eventsNode = FXMLLoader.load(getClass().getResource("/fxml/Event.fxml"));        
        appBorderPane.setCenter(eventsNode);
    }  

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML protected void handleDataSeriesMenuItem(ActionEvent event) throws IOException {
        Node  seriesNode = FXMLLoader.load(getClass().getResource("/fxml/Series.fxml"));        
        appBorderPane.setCenter(seriesNode);
    }  

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML protected void handleDataStoryMenuItem(ActionEvent event) throws IOException {
        Node storiesNode = FXMLLoader.load(getClass().getResource("/fxml/Story.fxml"));        
        appBorderPane.setCenter(storiesNode);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
}
