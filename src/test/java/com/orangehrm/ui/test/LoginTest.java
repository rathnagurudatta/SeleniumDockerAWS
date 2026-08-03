package com.orangehrm.ui.test;


import com.orangehrm.Constants.Browser;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.LoggerManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners(com.orangehrm.listeners.TestListener.class)
public class LoginTest extends TestBase{

    Logger logger = LoggerManager.getLogger(this.getClass());



    @Test(description = "Validate login functionality", groups={"e2e", "sanity"}, retryAnalyzer = com.orangehrm.listeners.MyRetryAnalyzer.class)
    public void loginRetryTest() throws InterruptedException {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isHeaderDisplayed("Swag Labs"), "Header is not displayed");
        logger.info("logged in successfully");

    }





}
