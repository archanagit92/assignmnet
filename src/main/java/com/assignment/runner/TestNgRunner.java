package com.assignment.runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(monochrome = true, features = {"src/test/resources/features/"},
glue = {"com.assignment.steps"},
tags = "@regression")
public class TestNgRunner {

	
}
