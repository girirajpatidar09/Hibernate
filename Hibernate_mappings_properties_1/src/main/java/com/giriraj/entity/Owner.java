package com.giriraj.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="owner")
public class Owner {
	
	@Id
	int id;
	
	@Column
	String name;
	

}
