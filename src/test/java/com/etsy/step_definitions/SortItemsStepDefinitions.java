package com.etsy.step_definitions;

import com.etsy.pages.AddingtoCartPage;
import com.etsy.pages.BasePage;
import com.etsy.pages.CartPage;
import com.etsy.utilities.BrowserUtils;
import com.etsy.utilities.ConfigurationReader;
import com.etsy.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortItemsStepDefinitions {

    String price;

    @Given("The user is on the e-commerce website")
    public void the_user_is_on_the_e_commerce_website() {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(2);
        new BasePage().cookies.click();
    }

    @When("The user searchs for {string} from search box")
    public void the_user_searchs_for_from_search_box(String item) {
        new BasePage().searchInputBox.sendKeys(item);
        new BasePage().searchInputBox.sendKeys(Keys.ENTER);
    }

    @When("The user sorts the results by price ascending")
    public void the_user_sort_the_results_by_price_ascending() {
        new BasePage().sortIcon.click();
        new BasePage().sortByPriceAsc.click();
    }

    @Then("The items should be sorted by price ascending")
    public void the_items_should_be_sorted_by_price_ascending() {
        List<WebElement> price = new BasePage().product;
        List<String> list = new ArrayList<>();
        for (WebElement p : price) {
            list.add(p.getText());
        }
        List<String> sortedPrices = new ArrayList<String>(list);
        Collections.sort(sortedPrices);

        Assert.assertEquals(sortedPrices, list);
    }

    @Given("The user sorts the results by price descending")
    public void the_user_sorts_the_results_by_price_descending() {
        new BasePage().sortIcon.click();
        new BasePage().sortByPriceDesc.click();
    }

    @When("The user adds the most expensive item to the shopping chart")
    public void the_user_adds_the_most_expensive_item_to_the_shopping_chart() {
        price=new BasePage().product.get(3).getText();
        new BasePage().product.get(3).click();
        String handlewindow = (String) Driver.get().getWindowHandles().toArray()[1];
        Driver.get().switchTo().window(handlewindow);
        BrowserUtils.waitForPageToLoad(10);
    }

    @Then("The most expensive item should be added to the shopping chart")
    public void the_most_expensive_item_should_be_added_to_the_shopping_chart() {
        new AddingtoCartPage().addCartButton.click();
        BrowserUtils.waitForPageToLoad(10);
        Assert.assertEquals(price, new CartPage().priceList.get(3).getText());

    }
}
