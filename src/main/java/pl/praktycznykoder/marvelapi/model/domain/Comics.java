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
    
    /**
     *
     */
    public static String[] ORDERBY_PARAM_NAMES = {
        "focDate", "onsaleDate", "title", "issueNumber", "modified"
    };

    /**
     *
     */
    public static String[] FORMAT_PARAM_NAMES = {
        "", "comic", "magazine", "trade paperback", "hardcover", "digest",
        "graphic novel", "digital comic", "infinite comic"
    };

    /**
     *
     */
    public static String[] FORMAT_TYPE_PARAM_NAMES = {
        "", "comic", "collection"
    };

    /**
     *
     */
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

    /**
     *
     * @param id
     * @param digitalId
     * @param title
     * @param issueNumber
     * @param variantDescription
     * @param description
     * @param modified
     * @param isbn
     * @param upc
     * @param diamondCode
     * @param ean
     * @param issn
     * @param format
     * @param pageCount
     * @param resourceURI
     * @param thumbnail
     * @param series
     * @param textObjects
     * @param urls
     * @param variants
     * @param collections
     * @param collectedIssues
     * @param dates
     * @param prices
     * @param images
     * @param creators
     * @param characters
     * @param stories
     * @param events
     */
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
    
    /**
     *
     * @return
     */
    @Override
    public int getId() {
        return id;
    }
    
    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public int getDigitalId() {
        return digitalId;
    }

    /**
     *
     * @param digitalId
     */
    public void setDigitalId(int digitalId) {
        this.digitalId = digitalId;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public int getIssueNumber() {
        return issueNumber;
    }

    /**
     *
     * @param issueNumber
     */
    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    /**
     *
     * @return
     */
    public String getVariantDescription() {
        return variantDescription;
    }

    /**
     *
     * @param variantDescription
     */
    public void setVariantDescription(String variantDescription) {
        this.variantDescription = variantDescription;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public String getModified() {
        return modified;
    }

    /**
     *
     * @param modified
     */
    public void setModified(String modified) {
        this.modified = modified;
    }

    /**
     *
     * @return
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     *
     * @param isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     *
     * @return
     */
    public String getUpc() {
        return upc;
    }

    /**
     *
     * @param upc
     */
    public void setUpc(String upc) {
        this.upc = upc;
    }

    /**
     *
     * @return
     */
    public String getDiamondCode() {
        return diamondCode;
    }

    /**
     *
     * @param diamondCode
     */
    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    /**
     *
     * @return
     */
    public String getEan() {
        return ean;
    }

    /**
     *
     * @param ean
     */
    public void setEan(String ean) {
        this.ean = ean;
    }

    /**
     *
     * @return
     */
    public String getIssn() {
        return issn;
    }

    /**
     *
     * @param issn
     */
    public void setIssn(String issn) {
        this.issn = issn;
    }

    /**
     *
     * @return
     */
    public String getFormat() {
        return format;
    }

    /**
     *
     * @param format
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     *
     * @return
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     *
     * @param pageCount
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    /**
     *
     * @return
     */
    public String getResourceURI() {
        return resourceURI;
    }

    /**
     *
     * @param resourceURI
     */
    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    /**
     *
     * @return
     */
    public Image getThumbnail() {
        return thumbnail;
    }

    /**
     *
     * @param thumbnail
     */
    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     *
     * @return
     */
    public DomainWraper getSeries() {
        return series;
    }

    /**
     *
     * @param series
     */
    public void setSeries(DomainWraper series) {
        this.series = series;
    }

    /**
     *
     * @return
     */
    public TextObject[] getTextObjects() {
        return textObjects;
    }

    /**
     *
     * @param textObjects
     */
    public void setTextObjects(TextObject[] textObjects) {
        this.textObjects = textObjects;
    }

    /**
     *
     * @return
     */
    public Url[] getUrls() {
        return urls;
    }

    /**
     *
     * @param urls
     */
    public void setUrls(Url[] urls) {
        this.urls = urls;
    }

    /**
     *
     * @return
     */
    public DomainWraper[] getVariants() {
        return variants;
    }

    /**
     *
     * @param variants
     */
    public void setVariants(DomainWraper[] variants) {
        this.variants = variants;
    }

    /**
     *
     * @return
     */
    public DomainWraper[] getCollections() {
        return collections;
    }

    /**
     *
     * @param collections
     */
    public void setCollections(DomainWraper[] collections) {
        this.collections = collections;
    }

    /**
     *
     * @return
     */
    public DomainWraper[] getCollectedIssues() {
        return collectedIssues;
    }

    /**
     *
     * @param collectedIssues
     */
    public void setCollectedIssues(DomainWraper[] collectedIssues) {
        this.collectedIssues = collectedIssues;
    }

    /**
     *
     * @return
     */
    public Date[] getDates() {
        return dates;
    }

    /**
     *
     * @param dates
     */
    public void setDates(Date[] dates) {
        this.dates = dates;
    }

    /**
     *
     * @return
     */
    public Price[] getPrices() {
        return prices;
    }

    /**
     *
     * @param prices
     */
    public void setPrices(Price[] prices) {
        this.prices = prices;
    }

    /**
     *
     * @return
     */
    public Image[] getImages() {
        return images;
    }

    /**
     *
     * @param images
     */
    public void setImages(Image[] images) {
        this.images = images;
    }

    /**
     *
     * @return
     */
    public DomainListWraper getCreators() {
        return creators;
    }

    /**
     *
     * @param creators
     */
    public void setCreators(DomainListWraper creators) {
        this.creators = creators;
    }

    /**
     *
     * @return
     */
    public DomainListWraper getCharacters() {
        return characters;
    }

    /**
     *
     * @param characters
     */
    public void setCharacters(DomainListWraper characters) {
        this.characters = characters;
    }

    /**
     *
     * @return
     */
    public DomainListWraper getStories() {
        return stories;
    }

    /**
     *
     * @param stories
     */
    public void setStories(DomainListWraper stories) {
        this.stories = stories;
    }

    /**
     *
     * @return
     */
    public DomainListWraper getEvents() {
        return events;
    }

    /**
     *
     * @param events
     */
    public void setEvents(DomainListWraper events) {
        this.events = events;
    }
}
