package org.weinbacchus.java_bucchus.model;

import jakarta.persistence.*;

import java.io.File;

/**
 * Die Klasse Wine
 *
 * @author k.bndyan
 * @version 1.0
 * @date 28.11.2024
 */
@Entity
@Table(name = "weine")
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_wein")
    private long idWine;
    @Column(name = "artikel_nr")
    private int itemNumber;
    @Column(name = "name")
    private String name;
    @Column(name = "jahr")
    private Integer vintage;
    @Column(name = "kurzbeschreibung")
    private String shortDescription;
    @Column(name = "preis")
    private double price;
    @Column(name = "inhalt")
    private double volume;
    @Column(name = "weingut")
    private String vineyard;
    @Column(name = "region")
    private String region;
//    @Column(name = "land_id")
//    private long countryId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "land_id",referencedColumnName = "id_land")
    private Country country;

    @Column(name = "typ")
    private String type;
    @Column(name = "beschreibung", columnDefinition = "Text")
    private String description;

    public String getImageFilename(){
        String path = "src/main/resources/static/images/small/";
        String filename = "w" + itemNumber + ".jpg";
        File file = new File(path + filename);
        return file.exists() ? filename : "blank.jpg"; // ئەگەر فایل بوو ئەگەر نا بلانک دانێ
    }

    public long getIdWine() {
        return idWine;
    }
    public void setIdWine(long idWine) {
        this.idWine = idWine;
    }
    public int getItemNumber() {
        return itemNumber;
    }
    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getVintage() {
        return vintage;
    }
    public void setVintage(Integer vintage) {
        this.vintage = vintage;
    }
    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getVolume() {
        return volume;
    }
    public void setVolume(double volume) {
        this.volume = volume;
    }
    public String getVineyard() {
        return vineyard;
    }
    public void setVineyard(String vineyard) {
        this.vineyard = vineyard;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
//    public long getCountryId() {
//        return countryId;
//    }
//    public void setCountryId(long countryId) {
//        this.countryId = countryId;
//    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


}
