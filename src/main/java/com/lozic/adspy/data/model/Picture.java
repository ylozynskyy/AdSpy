package com.lozic.adspy.data.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class representing image in advert.
 * 
 */
@Entity
@Table(name = "pictures")
public class Picture implements Serializable {

    private static final long serialVersionUID = 4070956026149789277L;
    
    private int id;
    private byte[] data;

    public Picture() {
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
    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

}