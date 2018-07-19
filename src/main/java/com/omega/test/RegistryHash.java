package com.omega.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(schema = "TEST", name = "REGISTRYHASH")
public class RegistryHash implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id ;
    private String mapkey;
    private String value;
    
    @Column(name = "id") 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)     
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "mapkey", unique = true, nullable = false)
    public String getMapkey() {
        return mapkey;
    }

    public void setMapkey(String mapkey) {
        this.mapkey = mapkey;
    }
    
    @Column(name = "value", unique = false, nullable = false)
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
