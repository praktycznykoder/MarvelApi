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

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pl.praktycznykoder.marvelapi.model.domain.Comics;
import pl.praktycznykoder.marvelapi.model.domain.basic.Image;
import pl.praktycznykoder.marvelapi.model.domain.basic.Url;
import pl.praktycznykoder.marvelapi.model.domain.wraper.DomainWraper;
import pl.praktycznykoder.marvelapi.model.services.ComicsAbstractServiceImpl;
import pl.praktycznykoder.marvelapi.model.services.Service;

/**
 *
 * @author praktycznykoder.pl
 */
public class ComicsFXMLDetailsController extends FXMLDetailsController<Comics> {

    private final Service<Comics> service = new ComicsAbstractServiceImpl();

    /**
     *
     * @return
     */
    @Override
    protected Service getService() {
        return service;
    }
    
    private Comics comicsDomain;
        
    @FXML private TextField idTextField;
    @FXML private TextField digitalIdTextField;
    @FXML private TextField titleTextField;
    @FXML private TextField issueNumberTextField;
    @FXML private TextField modyfiedTextField;
    @FXML private TextField upcTextField;
    @FXML private TextField eanTextField;
    @FXML private TextField issnTextField;
    @FXML private TextField diamondCodeTextField;
    @FXML private TextField formatTextField;
    @FXML private TextField pageCountTextField;
    @FXML private TextField isbnTextField;
    @FXML private TextArea variantDescriptionTextArea;
    @FXML private TextField resourceURITextField;
    @FXML private TextArea descriptionTextArea;
    
    @FXML private TextArea textObjectsTextArea;
    @FXML private TextArea pricesTextArea;
    @FXML private TextArea datesTextArea;    
    //Comics
    @FXML private ComboBox<DomainWraper> variantsComboBox;
    //Comics
    @FXML private ComboBox<DomainWraper> collectionsComboBox;
    //Comics
    @FXML private ComboBox<DomainWraper> collectedIssuesComboBox;
    @FXML private ComboBox<Image> imagesComboBox;
    @FXML private ComboBox<DomainWraper> creatorsComboBox;
    @FXML private ComboBox<DomainWraper> charactersComboBox;
    @FXML private ComboBox<DomainWraper> storiesComboBox;
    @FXML private ComboBox<DomainWraper> eventsComboBox;
    @FXML private ComboBox<Url> urlsComboBox;
    
    @FXML private Button seriesButton;
    
    @FXML private Button variantsButton;
    @FXML private Button collectionsButton;
    @FXML private Button collectedIssuesButton;
    @FXML private Button urlsButton;
    @FXML private Button imagesButton;
    @FXML private Button creatorsButton;
    @FXML private Button charactersButton;
    @FXML private Button storiesButton;
    @FXML private Button eventsButton;    
    
    /**
     *
     */
    @Override
    protected void initFields() {
        thumbnailImageView.setImage(
                getImage(comicsDomain.getThumbnail().toString()));
        idTextField.setText(comicsDomain.getId()+"");
        digitalIdTextField.setText(comicsDomain.getDigitalId()+"");
        titleTextField.setText(comicsDomain.getTitle());
        issueNumberTextField.setText(comicsDomain.getIssueNumber()+"");
        modyfiedTextField.setText(comicsDomain.getVariantDescription());
        upcTextField.setText(comicsDomain.getDescription());
        eanTextField.setText(comicsDomain.getModified());
        issnTextField.setText(comicsDomain.getIssn());
        diamondCodeTextField.setText(comicsDomain.getDiamondCode());
        formatTextField.setText(comicsDomain.getFormat());
        resourceURITextField.setText(comicsDomain.getResourceURI());
        pageCountTextField.setText(comicsDomain.getPageCount()+"");
        isbnTextField.setText(comicsDomain.getIsbn());
        
        variantDescriptionTextArea.setText(comicsDomain.getVariantDescription());
        descriptionTextArea.setText(comicsDomain.getDescription());
        
        setArrayObjectToTextArea(comicsDomain.getTextObjects(), textObjectsTextArea);
        setArrayObjectToTextArea(comicsDomain.getPrices(), pricesTextArea);
        setArrayObjectToTextArea(comicsDomain.getDates(), datesTextArea);
                
        variantsComboBox.getItems().addAll(comicsDomain.getVariants());
        disableComboBoxWhereIsEmpty(variantsComboBox, variantsButton);
        collectionsComboBox.getItems().addAll(comicsDomain.getCollections());
        disableComboBoxWhereIsEmpty(collectionsComboBox, collectionsButton);
        collectedIssuesComboBox.getItems().addAll(comicsDomain.getCollectedIssues());
        disableComboBoxWhereIsEmpty(collectedIssuesComboBox, collectedIssuesButton);
        urlsComboBox.getItems().addAll(comicsDomain.getUrls());
        disableComboBoxWhereIsEmpty(urlsComboBox, urlsButton);   
        imagesComboBox.getItems().addAll(comicsDomain.getImages());        
        disableComboBoxWhereIsEmpty(imagesComboBox, imagesButton);
        
        creatorsComboBox.getItems().addAll(comicsDomain.getCreators().getItems());
        disableComboBoxWhereIsEmpty(creatorsComboBox, creatorsButton);
        
        charactersComboBox.getItems().addAll(comicsDomain.getCharacters().getItems());
        disableComboBoxWhereIsEmpty(charactersComboBox, charactersButton);
        
        storiesComboBox.getItems().addAll(comicsDomain.getStories().getItems());
        disableComboBoxWhereIsEmpty(storiesComboBox, storiesButton);
        
        eventsComboBox.getItems().addAll(comicsDomain.getEvents().getItems());
        disableComboBoxWhereIsEmpty(eventsComboBox, eventsButton);
        
        disableButtonWhereIsEmpty(seriesButton, comicsDomain.getSeries());
        
        
    }
    
    /**
     *
     * @param comics
     */
    @Override
    public void initData(Comics comics){
        this.comicsDomain = comics;
        initFields();
    }
    
    /**
     *
     * @param remoteDomain
     */
    @Override
    public void initData(DomainWraper remoteDomain) {
        try {
            this.comicsDomain = service.getObjectWithUrl(remoteDomain.getResourceURI(), null);
        } catch (NoSuchAlgorithmException | URISyntaxException | IOException ex) {
            Logger.getLogger(CharacterFXMLDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        initFields();
    }
    /**
     *
     * @param event
     */
    @Override
    @FXML
    protected void resourceButtonOnAction(ActionEvent event){
        Button btn = (Button) event.getSource();
        String id = btn.getId();
        
        switch (id) {
            case "creatorsButton":   
                openNewScene("/fxml/CreatorDetails.fxml", "Creator",
                        creatorsComboBox);
            break;
            case "charactersButton":   
                openNewScene("/fxml/CharacterDetails.fxml", "Character",
                        charactersComboBox);
            break;
            case "storiesButton":   
                openNewScene("/fxml/StoryDetails.fxml", "Story",
                        storiesComboBox);
            break;
            case "eventsButton":   
                openNewScene("/fxml/EventDetails.fxml", "Event",
                        eventsComboBox);
            break;                   
            case "seriesButton":   
                openNewScene("/fxml/SeriesDetails.fxml", "Series",
                        comicsDomain.getSeries());
            break;            
            case "resourceURIButton":
                try {
                    Desktop.getDesktop().browse(new URI(comicsDomain.getResourceURI()));
                } catch (IOException | URISyntaxException ex) {
                    Logger.getLogger(CharacterFXMLDetailsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            break;
            
            case "variantsButton":   
                openNewScene("/fxml/ComicsDetails.fxml", "Comics - variant",
                        variantsComboBox);
            break;
            case "collectionsButton":   
                openNewScene("/fxml/ComicsDetails.fxml", "Comics - collection",
                        collectionsComboBox);
            break;
            case "collectedIssuesButton":   
                openNewScene("/fxml/ComicsDetails.fxml", "Comics - collected issue",
                        collectedIssuesComboBox);
            break;
            case "urlsButton":   
                openDesktopBrowserFromComboBoxUrl(urlsComboBox);
            break;
            
            
            case "imagesButton":
                Image image = imagesComboBox.getSelectionModel().getSelectedItem();
                openImageScene(image);
            break;
                
                
                
            default:
                System.out.println("switch dont have this id");
                break;
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) { }


    
}
