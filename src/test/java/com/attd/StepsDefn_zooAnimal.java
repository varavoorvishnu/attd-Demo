package com.attd;

import static org.slf4j.LoggerFactory.getLogger;

import java.net.URI;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.attd.DemoApplication;
import com.example.attd.model.Animal;
import com.example.attd.repository.iZooRepository;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = DemoApplication.class)
@ActiveProfiles("test")
@ContextConfiguration
public class StepsDefn_zooAnimal {

	private final Logger LOGGER = getLogger(this.getClass().getSimpleName());
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	iZooRepository  iZooRepository;
	
	@LocalServerPort
	int randomServerPort;

	private final String API_BASE_PATH = "http://localhost:8080/";


	

	public Animal createAnimalObj(String animals) {
		Animal animal = new Animal();
		animal.setAnimalName(animals);

		return animal;

	}

	@Given("^Add set of animal (.+) to the database$")
	public void add_set_of_animal_to_the_database(String animalname) throws Throwable {
		LOGGER.info("Holy !!"+createAnimalObj(animalname).getAnimalName());
	//	assertEquals("SUCCESS", zooRepository.addNewAnimal(createAnimalObj(animalname)));
		//assertEquals("SUCCESS","SUCCESS");
	}

	@When("^an animal (.+) name is suplied to animals rest endpoint$")
	public void an_animal_name_is_suplied_to_animals_rest_endpoint(String animals) throws Throwable {
		
		 final String endptURL = "http://localhost:"+randomServerPort+"/Animals/addAnimal/"+animals;
	        URI uri = new URI(endptURL);
	        
	         Animal animal = createAnimalObj(animals);
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("X-COM-PERSIST", "true");     
	 
	        HttpEntity<Animal> request = new HttpEntity<>(animal, headers);
	         
	        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
	         
	        //Verify request succeed
	        Assert.assertEquals(200, result.getStatusCodeValue());
	}

	@Then("^the animals (.+) should be stored in the database$")
	public void the_animals_should_be_stored_in_the_database(String animals) throws Throwable {	
		
	     
	    final String baseUrl = "http://localhost:" + randomServerPort + "/Animals/"+animals;
	    URI uri = new URI(baseUrl);
	   
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("X-COM-PERSIST", "true"); 
	    
	    
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("SUCCESS"));
	}

}
