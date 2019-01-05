package com.example.attd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Animal {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "animal_id")
	int animalId;
	
	public int getAnimalId() {
		return animalId;
	}

	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}
	@Column(name = "animal_name")
	String animalName="";

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Animal ID is : "+animalId+ " Animal Name is : "+ animalName;
	}
}
