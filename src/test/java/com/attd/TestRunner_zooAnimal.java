package com.attd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

 
@RunWith(Cucumber.class)
//@CucumberOptions(features="src/test/resources/")
@CucumberOptions(features = "classpath:zooanimal.feature")
public class TestRunner_zooAnimal {
}

