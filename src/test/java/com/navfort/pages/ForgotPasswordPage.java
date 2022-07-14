package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

    public ForgotPasswordPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@placeholder='Username or Email']")
    public WebElement usernameOrEmailField;

    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement requestButton;

    @FindBy(xpath = "//div[@class='alert alert-warn']")
    public WebElement unableToSendTheEmailMessage;
}
