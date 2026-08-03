package com.orangehrm.pages;

import com.orangehrm.Constants.Browser;
import com.orangehrm.utilities.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BrowserUtility {

    private static final By selectAction = By.name("username");
    private static final By headerTitle = By.cssSelector("span.oxd-topbar-header-breadcrumb>h6");

    public DashboardPage(Browser browserName, boolean isHeadless) {
        super(browserName, isHeadless);
    }

    public String getHeaderTitle(){
        return getVisibletext(headerTitle);
    }




}
