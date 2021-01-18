package com.etsy.step_definitions;

import com.etsy.pages.AddingtoCartPage;
import com.etsy.pages.BasePage;
import com.etsy.pages.CartPage;
import com.etsy.utilities.BrowserUtils;
import com.etsy.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class AddItemsToChartStepDefinitions {

    String price;
    @When("The user searchs {string}")
    public void the_user_searchs(String item) {
        new BasePage().searchInputBox.sendKeys(item);
        new BasePage().searchInputBox.sendKeys(Keys.ENTER);
    }

    @When("The user adds the item to the shopping chart")
    public void the_user_adds_the_item_to_the_shopping_chart() {
        price=new BasePage().product.get(0).getText();
        new BasePage().product.get(0).click();
        String handlewindow = (String) Driver.get().getWindowHandles().toArray()[1];
        Driver.get().switchTo().window(handlewindow);
        BrowserUtils.waitForPageToLoad(10);
    }

    @Then("The {string} should be added to the shopping chart")
    public void the_should_be_added_to_the_shopping_chart(String itemName) {
        new AddingtoCartPage().addCartButton.click();
        BrowserUtils.waitForPageToLoad(10);
        Assert.assertEquals(price, new CartPage().priceList.get(0).getText());
    }
}
