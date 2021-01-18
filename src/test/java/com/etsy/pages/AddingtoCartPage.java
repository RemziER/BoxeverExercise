package com.etsy.pages;

import com.etsy.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddingtoCartPage {

    public AddingtoCartPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "div.wt-display-flex-xs.wt-flex-direction-column-xs.wt-flex-direction-row-md.wt-flex-wrap.wt-flex-direction-column-lg")
    public WebElement addCartButton;
}
