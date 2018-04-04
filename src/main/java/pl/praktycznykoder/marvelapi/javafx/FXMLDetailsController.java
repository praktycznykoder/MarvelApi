/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

/**
 *
 * @author praktycznykoder.pl
 * @param <DomainType>
 */
public abstract class FXMLDetailsController<DomainType> implements Initializable{
    public abstract void initData(DomainType character);
    protected abstract void initFields();
    protected abstract void getResourceButtonOnAction(ActionEvent event);
}
