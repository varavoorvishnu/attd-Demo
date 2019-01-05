package com.example.attd.repository.support;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.attd.model.Animal;
import com.example.attd.repository.iRepo;
import com.example.attd.repository.iZooRepository;

@Repository
public class DefaultZooRepository implements iZooRepository{
	
	 private final Logger LOGGER = getLogger(this.getClass().getSimpleName());
	 
	@Autowired
	iRepo irepo;

	
	public String addNewAnimal(Animal animal) {
		LOGGER.info("Inside AddNewAnimal Method :"+animal.getAnimalId() + " : "+ animal.getAnimalName());
		irepo.save(animal);
		return "SUCCESS";
	}


	@Override
	public String getAnimalbyName(String animalname) {
		
		List<Animal> animalList=irepo.findAll();
		for(Animal animalObjfromList:animalList) {
			if(animalObjfromList.getAnimalName().equals(animalname)) {
				LOGGER.info("Animal Name:"+animalname+" is present in Animals list:"+animalObjfromList.getAnimalName());		
				return "SUCCESS";
			}
		}
		return "FAILURE";
	}
	
}
