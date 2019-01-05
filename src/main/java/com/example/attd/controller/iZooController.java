package com.example.attd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Animals")
public interface iZooController {
	
@PostMapping("/addAnimal/{animalname}")
public String addAnimal(@PathVariable("animalname") String animalname);

@GetMapping(path="/{animalname}")
public String getAnimalbyName(@PathVariable("animalname")String animalname);
}
