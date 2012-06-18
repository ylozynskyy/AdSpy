package com.lozic.adspy.data.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;


/**
 * The persistent class representing user role in system.
 * 
 */
@Entity
@Table(name="roles")
public class Role implements Serializable, GrantedAuthority {
	private static final long serialVersionUID = 1L;
	private int id;
	private String authority;

    public Role() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}