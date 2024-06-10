package com.assignment.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	static WebDriverWait wait = null;

	public static void waitTillElementToBeClickable(WebDriver driver, WebElement element) {

		wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitTillVisibilityOfElement(WebDriver driver, WebElement element) {

		wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
