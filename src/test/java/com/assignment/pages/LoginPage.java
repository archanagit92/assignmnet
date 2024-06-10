package com.assignment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.utils.PropertyUtils;
import com.assignmnet.basetest.SetUp;

public class LoginPage extends SetUp {

	@FindBy(xpath = "//input[@id='ap_email']")
	private WebElement user_name;

	@FindBy(xpath = " //input[@id='ap_password']")
	private WebElement password;

	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continueButton;

	@FindBy(xpath = " //input[@id='signInSubmit']")
	private WebElement siginInButton;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void enterUrl() {
		getDriver().get(PropertyUtils.getInstance().getValue("application.url"));
	}

	public void enterUserName() {
		user_name.sendKeys(PropertyUtils.getInstance().getValue("username"));

	}

	public void enterPassword() {
		password.sendKeys(PropertyUtils.getInstance().getValue("password"));

	}

	public void ClickContinueButton() {
		continueButton.click();

	}

	public void ClickSiginInButton() {
		siginInButton.click();

	}
	
	public String getPageTitel()
	{
	
		return getDriver().getTitle();
		
	}

}
