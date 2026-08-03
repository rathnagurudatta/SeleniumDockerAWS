package com.orangehrm.ui.test;

import com.google.gson.Gson;
import com.orangehrm.Constants.Browser;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pojos.TestData;
import com.orangehrm.pojos.User;
import com.orangehrm.utilities.LoggerManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class LoginDataProvidersTest extends TestBase{

    Logger logger = LoggerManager.getLogger(this.getClass());





    @Test(description = "Validate login functionality", groups = {"e2e", "sanity"}, dataProviderClass = com.orangehrm.dataproviders.LoginDataProviders.class
            , dataProvider = "LoginExcelDataProvider")
    public void loginDataProviderTest(User user) throws InterruptedException {

        loginPage.login(user.getUsername(), user.getPassword());
        Assert.assertTrue(loginPage.isHeaderDisplayed("Swag Labs"), "Header is not displayed");
        logger.info("logged in successfully");
    }



}
