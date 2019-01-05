package com.example.attd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.attd.services.iZooService;

@RestController
@RequestMapping("/Animals")
public class DefaultZooController implements iZooController {

	@Autowired
	iZooService iZooService;
	
	@Override
	public String addAnimal(@PathVariable("animalname")String animalname) {
		return iZooService.addAnimal(animalname);
	}
	@GetMapping(path="/{animalname}")
	public String getAnimalbyName(@PathVariable("animalname")String animalname) {
		return iZooService.getAnimalbyName(animalname);
	}
	

}
