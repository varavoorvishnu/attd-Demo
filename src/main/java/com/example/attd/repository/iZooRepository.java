package com.example.attd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.attd.model.Animal;

public interface iZooRepository{
	public String addNewAnimal(Animal animal);
	public String getAnimalbyName(String animalname);
	
}
