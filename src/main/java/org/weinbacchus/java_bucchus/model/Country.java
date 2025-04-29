package org.weinbacchus.java_bucchus.model;

import jakarta.persistence.*;

/**
 * Die Klasse Country
 *
 * @author k.bndyan
 * @version 1.0
 * @date 28.11.2024
 */
@Entity
@Table(name = "laender")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_land")
    private long idCountry;
    private String name;

    public long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(long idCountry) {
        this.idCountry = idCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}