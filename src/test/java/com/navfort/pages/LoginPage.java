package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[.='Log in']")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@required='required']")
    public WebElement fillOutWarning;

    @FindBy(xpath = "//div[.='Invalid user name or password.']")
    public WebElement invalidUsernameOrPasswordMessage;

    @FindBy(xpath = "//a[@href= '/user/reset-request']")
    public WebElement forgotYourPasswordLink;

    @FindBy(xpath = "//span [@class='custom-checkbox__icon']")
    public WebElement RememberMeCheckBox;


    public void login(String username, String password) {
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.click();
    }

    public void login1(){
        Driver.getDriver().get("https://qa.navfort.com/");
    }

}

