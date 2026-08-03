package com.orangehrm.ui.test;

import com.orangehrm.Constants.Browser;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pojos.User;
import com.orangehrm.utilities.LoggerManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginExcelTest extends TestBase {

    Logger logger = LoggerManager.getLogger(this.getClass());


    @Test(description = "Validate login functionality", groups = {"e2e", "sanity"}, dataProviderClass = com.orangehrm.dataproviders.LoginDataProviders.class
            , dataProvider = "LoginCsvDataProvider")
    public void loginExcelTest(User user) throws InterruptedException {

        loginPage.login(user.getUsername(), user.getPassword());
        Assert.assertTrue(loginPage.isHeaderDisplayed("Swag Labs"), "Header is not displayed");
        logger.info("logged in successfully");
    }

}





