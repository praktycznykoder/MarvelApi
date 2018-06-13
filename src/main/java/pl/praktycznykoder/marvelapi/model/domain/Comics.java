/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.domain;

import pl.praktycznykoder.marvelapi.model.domain.basic.Url;
import pl.praktycznykoder.marvelapi.model.domain.basic.Price;
import pl.praktycznykoder.marvelapi.model.domain.basic.Image;
import pl.praktycznykoder.marvelapi.model.domain.basic.Date;
import pl.praktycznykoder.marvelapi.model.domain.wraper.DomainWraper;
import pl.praktycznykoder.marvelapi.model.domain.wraper.DomainListWraper;

/**
 *
 * @author praktycznykoder.pl
 */
public class Comics implements Domain {
    
    public static String[] ORDERBY_PARAM_NAMES = {
        "focDate", "onsaleDate", "title", "issueNumber", "modified"
    };
    public static String[] FORMAT_PARAM_NAMES = {
        "", "comic", "magazine", "trade paperback", "hardcover", "digest",
        "graphic novel", "digital comic", "infinite comic"
    };
    public static String[] FORMAT_TYPE_PARAM_NAMES = {
        "", "comic", "collection"
    };
    public static String[] DATE_DESCRIPTOR_PARAM_NAMES = {
        "", "lastWeek", "thisWeek", "nextWeek", "thisMonth"
    };
    
    private int id;
    private int digitalId;
    private String title;
    private int issueNumber;
    
    private String variantDescription;    
    private String description;
    
    private String modified;
    private String isbn;
    private String upc;
    private String ean;
    private String issn;
    private String diamondCode;
    private String format;
    private int pageCount;
    private String resourceURI;
    private Image thumbnail;
    private DomainWraper series;

    
    private TextObject[] textObjects;
    private DomainWraper[] variants;
    private DomainWraper[] collections;
    private DomainWraper[] collectedIssues;
    private Url[] urls;
    private Date[] dates;
    private Price[] prices;
    private Image[] images;

    private DomainListWraper creators;
    private DomainListWraper characters;
    private DomainListWraper stories;
    private DomainListWraper events;

    public Comics(int id, int digitalId, String title, int issueNumber, String variantDescription, String description, String modified, String isbn, String upc, String diamondCode, String ean, String issn, String format, int pageCount, String resourceURI, Image thumbnail, DomainWraper series, TextObject[] textObjects, Url[] urls, DomainWraper[] variants, DomainWraper[] collections, DomainWraper[] collectedIssues, Date[] dates, Price[] prices, Image[] images, DomainListWraper creators, DomainListWraper characters, DomainListWraper stories, DomainListWraper events) {
        this.id = id;
        this.digitalId = digitalId;
        this.title = title;
        this.issueNumber = issueNumber;
        this.variantDescription = variantDescription;
        this.description = description;
        this.modified = modified;
        this.isbn = isbn;
        this.upc = upc;
        this.diamondCode = diamondCode;
        this.ean = ean;
        this.issn = issn;
        this.format = format;
        this.pageCount = pageCount;
        this.resourceURI = resourceURI;
        this.thumbnail = thumbnail;
        this.series = series;
        this.textObjects = textObjects;
        this.urls = urls;
        this.variants = variants;
        this.collections = collections;
        this.collectedIssues = collectedIssues;
        this.dates = dates;
        this.prices = prices;
        this.images = images;
        this.creators = creators;
        this.characters = characters;
        this.stories = stories;
        this.events = events;
    }
    
    @Override
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getDigitalId() {
        return digitalId;
    }

    public void setDigitalId(int digitalId) {
        this.digitalId = digitalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getVariantDescription() {
        return variantDescription;
    }

    public void setVariantDescription(String variantDescription) {
        this.variantDescription = variantDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    public DomainWraper getSeries() {
        return series;
    }

    public void setSeries(DomainWraper series) {
        this.series = series;
    }

    public TextObject[] getTextObjects() {
        return textObjects;
    }

    public void setTextObjects(TextObject[] textObjects) {
        this.textObjects = textObjects;
    }

    public Url[] getUrls() {
        return urls;
    }

    public void setUrls(Url[] urls) {
        this.urls = urls;
    }

    public DomainWraper[] getVariants() {
        return variants;
    }

    public void setVariants(DomainWraper[] variants) {
        this.variants = variants;
    }

    public DomainWraper[] getCollections() {
        return collections;
    }

    public void setCollections(DomainWraper[] collections) {
        this.collections = collections;
    }

    public DomainWraper[] getCollectedIssues() {
        return collectedIssues;
    }

    public void setCollectedIssues(DomainWraper[] collectedIssues) {
        this.collectedIssues = collectedIssues;
    }

    public Date[] getDates() {
        return dates;
    }

    public void setDates(Date[] dates) {
        this.dates = dates;
    }

    public Price[] getPrices() {
        return prices;
    }

    public void setPrices(Price[] prices) {
        this.prices = prices;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }

    public DomainListWraper getCreators() {
        return creators;
    }

    public void setCreators(DomainListWraper creators) {
        this.creators = creators;
    }

    public DomainListWraper getCharacters() {
        return characters;
    }

    public void setCharacters(DomainListWraper characters) {
        this.characters = characters;
    }

    public DomainListWraper getStories() {
        return stories;
    }

    public void setStories(DomainListWraper stories) {
        this.stories = stories;
    }

    public DomainListWraper getEvents() {
        return events;
    }

    public void setEvents(DomainListWraper events) {
        this.events = events;
    }
}
