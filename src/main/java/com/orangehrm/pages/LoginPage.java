package com.orangehrm.pages;


import com.orangehrm.Constants.Browser;
import com.orangehrm.Constants.Env;
import com.orangehrm.utilities.BrowserUtility;
import com.orangehrm.utilities.JsonUtiltity;
import com.orangehrm.utilities.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LoginPage extends BrowserUtility {

    private static final By usernameEditField = By.id("user-name");
    private static final By passwordTextBox = By.name("password");
    private static final By submitButtonLocator = By.id("login-button");
    private static final By headerTitle = By.xpath("//div[text()='Swag Labs']");


    public LoginPage(Browser browserName, boolean isHeadless) {
        super(browserName, isHeadless); //calls parent class constructor
        launchSauceDemo(PropertiesUtil.loadPropertiesFile(Env.qa, "url"));
        launchSauceDemo(JsonUtiltity.readJson(Env.qa).getUrl());

        try {
            Thread.sleep(2000);  //Application is slow
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public LoginPage(WebDriver lambdaDriver) {
        super(lambdaDriver);
        launchSauceDemo(PropertiesUtil.loadPropertiesFile(Env.qa, "url"));
    }

    public void login(String username, String password){
        enterText(usernameEditField, username);
        enterText(passwordTextBox, password);
        clickOn(submitButtonLocator);
        //return new DashboardPage(Browser.CHROME);
    }

    public boolean isHeaderDisplayed(String expectedValue){
        String actualText = getVisibletext(headerTitle);
        if(actualText.equalsIgnoreCase(expectedValue)){
            return true;
        }
        return false;
    }

    public void closeBrowser(){
        getDriver().quit();
    }







}
