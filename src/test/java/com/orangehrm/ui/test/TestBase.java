package com.orangehrm.ui.test;

import com.orangehrm.Constants.Browser;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.BrowserUtility;
import com.orangehrm.utilities.LambdaTestUtility;
import com.orangehrm.utilities.LoggerManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class TestBase {

    Logger logger = LoggerManager.getLogger(this.getClass());
    protected LoginPage loginPage;
    private boolean isLambdaTest;


    @Parameters({"browser", "isLambdaTest", "isHeadless"})
    @BeforeMethod(description = "load the application url")
    public void setup(@Optional("chrome") String browser, @Optional("false")boolean isLambdaTest, @Optional("false")boolean isHeadless, Method method) throws MalformedURLException {
        this.isLambdaTest = isLambdaTest;
        WebDriver lambdaDriver;
        System.out.println("Browser      : " + browser);
        System.out.println("LambdaTest   : " + isLambdaTest);
        System.out.println("Headless     : " + isHeadless);
    if(isLambdaTest){
        lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(browser, method.getName());
        loginPage = new LoginPage(lambdaDriver);
    }else{
        //Running test on local machine
        loginPage = new LoginPage(Browser.valueOf(browser.toUpperCase()), isHeadless);
    }

    }

    public BrowserUtility getInstance(){
        return loginPage;
    }


    @AfterMethod
    public void tearDown() {
        if(isLambdaTest){
            LambdaTestUtility.quitSession(); //quit or close the browser session on Lambda Test
        }else{
            loginPage.closeBrowser();
        }

    }




}
