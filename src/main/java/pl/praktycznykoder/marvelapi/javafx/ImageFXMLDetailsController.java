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

    /**
     *
     * @param fxImage
     */
    public void setImage(WritableImage fxImage) {
        imageView.setImage(fxImage);
        imageView.setFitHeight(fxImage.getHeight());
        imageView.setFitWidth(fxImage.getWidth());
        
    }
    
    /**
     *
     * @param image
     */
    public void setImage(javafx.scene.image.Image image) {
        imageView.setImage(image);  
        
        imageView.setFitHeight(800);
        imageView.setFitWidth(600);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {}
    
}
