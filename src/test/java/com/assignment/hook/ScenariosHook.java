package com.assignment.hook;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.assignmnet.basetest.SetUp;

import io.cucumber.java.After;
import io.cucumber.java.Before;





public class ScenariosHook {
	
	
	@Before
    public void beforeTest() {
     String browser=   System.getProperty("Browser", "CHROME");
		SetUp.browserInitalization(browser);
    }
	
	@After
	public void afterTest()
	{
		SetUp.quitDriver();
	}
	

}

