package com.lozic.adspy.data.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the adverts database table.
 * 
 */
@Entity
@Table(name = "adverts")
public class Advert implements Serializable {

    private static final long serialVersionUID = -3166594469258263127L;

    private int id;
    private String caption;
    private String originalLink;
    private String text;
    private AdvertType type;
    private List<Picture> pictures;
    private Picture frontPicture;

    public Advert() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Lob()
    public String getCaption() {
        return this.caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Lob()
    @Column(name = "original_link")
    public String getOriginalLink() {
        return this.originalLink;
    }

    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }

    @Lob()
    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @ManyToOne
    @JoinColumn(name = "type_id")
    public AdvertType getType() {
        return this.type;
    }

    public void setType(AdvertType advertType) {
        this.type = advertType;
    }

    @OneToMany
    @JoinColumn(name = "davert_id")
    public List<Picture> getPictures() {
        return this.pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    @OneToOne
    @JoinColumn(name = "front_image_id")
    public Picture getFrontPicture() {
        return this.frontPicture;
    }

    public void setFrontPicture(Picture picture) {
        this.frontPicture = picture;
    }

}