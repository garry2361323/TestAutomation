package com.sjc.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.RequestPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    HomePage homepage;
    LoginPage loginpage;
    RequestPage requestpage;

    public HomePageTest() {
        super();
    }

    @BeforeTest
    public void setup() {
        init();
        homepage = new HomePage();
        loginpage = new LoginPage();
        loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void loginNameTest(){
        Assert.assertTrue(homepage.verifyLoginName());
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
