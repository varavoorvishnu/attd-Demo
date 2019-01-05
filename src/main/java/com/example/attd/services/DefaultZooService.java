package com.example.attd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.attd.model.Animal;
import com.example.attd.repository.iZooRepository;

@Service
public class DefaultZooService implements iZooService{

	@Autowired
	iZooRepository izooRepository;
	
	
	@Override
	public String addAnimal(String animalname) {
		Animal animal = new Animal();
		animal.setAnimalName(animalname);
		return izooRepository.addNewAnimal(animal);
	}


	@Override
	public String getAnimalbyName(String animalname){
		return izooRepository.getAnimalbyName(animalname);
	}

}
