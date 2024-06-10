package com.assignment.steps;

import org.testng.Assert;

import com.assignment.pages.CartPage;
import com.assignment.utils.ScenarioContext;
import com.assignment.utils.WaitUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {

	CartPage addTocart = new CartPage();

	@Then("user click on cart")
	public void user_click_on_cart() {
		
		addTocart.clickOnCart();

	}

	@Then("user delete the itmes from cart if exists")
	public void user_delete_the_itmes_from_cart_if_exists() throws InterruptedException {
		addTocart.DeleteAllItemsFromCart();
	}

	@When("user verify subTotal price")
	public void user_verify_subTotal_price() {
		int actualSubTotal = addTocart.getSubTotal();
		int expectedSubTotal = (int) ScenarioContext.getInstance().get("subTotal");
		Assert.assertEquals(actualSubTotal, expectedSubTotal, "expected and Actual Subtotal did not match");
	}

}
