package com.assignment.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.utils.WaitUtils;
import com.assignmnet.basetest.SetUp;

public class HomePage extends SetUp {

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchTestBox;

	@FindBy(xpath = "//span[@class='a-button a-button-primary a-button-icon']/descendant::button[@class='a-button-text']")
	private List<WebElement> addTocartButton;

	@FindBy(xpath = "//span[@class ='a-price']/descendant::span[@class='a-price-whole']")
	private List<WebElement> productPrice;

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void searchTestBox(String product) {

		WaitUtils.waitTillVisibilityOfElement(getDriver(), searchTestBox);
		searchTestBox.clear();
        searchTestBox.sendKeys(product);
		searchTestBox.sendKeys(Keys.ENTER);

	}

	public void selectElements(int productPosition) {

		WaitUtils.waitTillElementToBeClickable(getDriver(), addTocartButton.get(productPosition - 1));
		addTocartButton.get(productPosition - 1).click();

	}

	public int getProductPrice(int productPosition) {

		return Integer.valueOf(productPrice.get(productPosition - 1).getText().replace(",", ""));

	}

}
