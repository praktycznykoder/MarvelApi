/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.javafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

/**
 *
 * @author praktycznykoder.pl
 */
public class ImageFXMLDetailsController implements Initializable{
    
    @FXML private ImageView imageView;

    public void setImage(WritableImage fxImage) {
        imageView.setImage(fxImage);
        imageView.setFitHeight(fxImage.getHeight());
        imageView.setFitWidth(fxImage.getWidth());
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
    
}