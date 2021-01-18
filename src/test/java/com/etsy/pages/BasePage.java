package com.etsy.pages;

import com.etsy.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "global-enhancements-search-query")
    public WebElement searchInputBox;

    @FindBy(css = "div.wt-menu.sort-by-redesign")
    public WebElement sortIcon;

    @FindBy(xpath = "//*[@id=\"sortby\"]/div/a[4]")
    public WebElement sortByPriceAsc;

    @FindBy(xpath = "//*[@id=\"sortby\"]/div/a[3]")
    public WebElement sortByPriceDesc;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/div/div[3]/div[2]/div[3]/div/div[1]/div/li/div/div/a/div[2]/div/span/span[2]")
    public List<WebElement> product;

    @FindBy(xpath = "(//div[@class='wt-overlay__footer__action'])[2]")
    public WebElement cookies;
}
