package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.misc.Request;

public class HomePage extends TestBase {

    @FindBy(xpath = "//*[@id='s_1_l']/span[2]/div/b")
    WebElement loginName;

    @FindBy(xpath = "//*[@id='ui-id-416']/span/img")
    WebElement requestLink;

    //Initialize Page Factory
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyLoginName() {
        return loginName.isDisplayed();
    }

    public RequestPage clickonRequestLink() {
        loginName.click();
        return new RequestPage();
    }

}
