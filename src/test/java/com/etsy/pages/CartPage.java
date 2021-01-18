package com.etsy.pages;

import com.etsy.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[@id=\"multi-shop-cart-list\"]/div/div/div[1]/ul/li/ul/li/div/div[2]/div/div[2]/div/div[2]/div/p[1]/span/span[2]")
    public List<WebElement> priceList;

}
