package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(name = "SWEUserName")
    WebElement username;

    @FindBy(name = "SWEPassword")
    WebElement password;

    @FindBy(xpath = "//*[@id='s_swepi_22']")
    WebElement subButton;

    //Initialize Page Objects:
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public HomePage login(String user, String pwd){
        username.sendKeys(user);
        password.sendKeys(pwd);
        subButton.click();
        return new HomePage();
    }
}
