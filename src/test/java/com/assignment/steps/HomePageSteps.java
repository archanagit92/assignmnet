package com.assignment.steps;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.testng.Assert;

import com.assignment.pages.HomePage;
import com.assignment.pages.LoginPage;
import com.assignment.utils.ScenarioContext;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {

	HomePage homepage = new HomePage();

	@Given("user search for the products and add items to cart")
	public void user_search_for_the_and_add_item_to_cart(DataTable dataTable) {

		String[] listOfproductNames = null;
		String[] ListOfproductPositions = null;
		List<Map<String, String>> dataTableList = dataTable.asMaps();

		boolean isAllValuesNull = dataTableList.get(0).values().stream().allMatch(Objects::isNull);
		if (!isAllValuesNull) {
			for (Map<String, String> mapData : dataTableList) {

				if (mapData.get("productList").contains(",")) {
					listOfproductNames = mapData.get("productList").split(",");
					ListOfproductPositions = mapData.get("productPosition").split(",");
					for (int i = 0; i < listOfproductNames.length; i++) {

						homepage.searchTestBox(listOfproductNames[i]);
						int productPrize = homepage.getProductPrice(Integer.valueOf(ListOfproductPositions[i]));
						if (null == ScenarioContext.getInstance().get("subTotal")) {
							ScenarioContext.getInstance().put("subTotal", productPrize);
						} else {
							productPrize = (int) ScenarioContext.getInstance().get("subTotal") + productPrize;

							ScenarioContext.getInstance().put("subTotal", productPrize);
						}
						homepage.selectElements(Integer.valueOf(ListOfproductPositions[i]));
					}
				} else {
					homepage.searchTestBox(mapData.get("productList"));
					int productPrize = homepage.getProductPrice(Integer.valueOf("productPosition"));
					if (null == ScenarioContext.getInstance().get("subTotal")) {
						ScenarioContext.getInstance().put("subTotal", productPrize);
					} else {
						productPrize = (int) ScenarioContext.getInstance().get("subTotal") + productPrize;

						ScenarioContext.getInstance().put("subTotal", productPrize);
					}
					homepage.selectElements(Integer.valueOf(mapData.get("productPosition")));
				}

			}

		}

	}

	

}
