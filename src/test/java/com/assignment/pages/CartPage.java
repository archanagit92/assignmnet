package com.assignment.pages;

import java.util.List;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assignment.utils.WaitUtils;
import com.assignmnet.basetest.SetUp;

public class CartPage extends SetUp {

	@FindBy(xpath = "//span[@class='nav-cart-icon nav-sprite']")
	private WebElement clickOnCart;

	@FindBy(xpath = "span[id='sc-subtotal-amount-activecart'] span[class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")
	private WebElement subTotal;

	@FindBy(xpath = "//span[@class='sc-action-quantity']/following-sibling::span[@data-action='delete']/descendant::input")
	private List<WebElement> clickOnDelete;

	public CartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void clickOnCart() {

		WaitUtils.waitTillElementToBeClickable(getDriver(), clickOnCart);
		clickOnCart.click();

	}

	public int getSubTotal() {

		return Integer.valueOf(subTotal.getText().substring(1));

	}

	public void DeleteAllItemsFromCart() throws InterruptedException {

		for (WebElement elemnetToBeDeleted : clickOnDelete) {
			WaitUtils.waitTillElementToBeClickable(getDriver(), elemnetToBeDeleted);
			if (clickOnDelete.size() > 0) {
				elemnetToBeDeleted.sendKeys(Keys.ENTER);
				
			}

		}

	}

}
