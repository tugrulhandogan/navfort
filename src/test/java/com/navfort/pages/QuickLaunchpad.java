package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickLaunchpad {

    public QuickLaunchpad() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement QuickLauncpadPage;

    @FindBy(xpath = "//a[@title='Fleet Management']")
    public WebElement fleetManagement;
}
