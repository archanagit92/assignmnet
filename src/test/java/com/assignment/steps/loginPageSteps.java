package com.assignment.steps;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.assignment.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginPageSteps {

	LoginPage loginPage = new LoginPage();

	@Given("user navigate to the login page")
	public void user_navigate_to_the_login_page() {
		loginPage.enterUrl();

	}

	@When("user submit username and password")
	public void user_submit_username_and_password() {
		loginPage.enterUserName();
		loginPage.ClickContinueButton();
		loginPage.enterPassword();
		loginPage.ClickSiginInButton();
	}

	@Then("user validate home page title sucessfully")
	public void user_validate_home_page_title_sucessfully(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> datatable = dataTable.asMaps();
		for(Map<String, String> title:datatable )
		{
        String expectedTitle = title.get("title");
        
		String actualTitle = loginPage.getPageTitel();
		Assert.assertEquals(actualTitle, expectedTitle, actualTitle);
		}
	}

}
