package com.orangehrm.utilities;

import static com.orangehrm.Constants.Browser.*;

import com.orangehrm.Constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class BrowserUtility {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    Logger logger = LoggerManager.getLogger(this.getClass());

    public BrowserUtility(WebDriver driver){
        super();
        this.driver.set(driver);  //initialize the instance variable driver
    }

    public BrowserUtility(String browserName){
        if(browserName.equals("chrome")){
            driver.set(new ChromeDriver());
        }else if(browserName.equals("edge")){
            driver.set(new EdgeDriver());
        }else{
            System.out.println("Invalid browser name.");
        }
    }

    public BrowserUtility(Browser browserName, boolean isHeadless){
        if(browserName == CHROME){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-gpu");
            options.addArguments("--remote-debugging-port=9222");

            if(isHeadless) {
                options.addArguments("--headless=new");
            }

            driver.set(new ChromeDriver(options));


        }else if(browserName == EDGE){
            if(isHeadless) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=old");
                options.addArguments("--disable-gpu");
                driver.set(new EdgeDriver(options));
            }else{
                driver.set(new EdgeDriver());
            }

        }else if(browserName == FIREFOX){
            if(isHeadless) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless=old");
                options.addArguments("--disable-gpu");
                driver.set(new FirefoxDriver(options));
            }else{
                driver.set(new EdgeDriver());
            }

        }else{
            logger.error("Invalid browser name.");
            System.out.println("Invalid browser name.");
        }
    }

    public BrowserUtility() {

    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver webdriver) {
        driver.set(webdriver);
    }

    public void launchSauceDemo(String url){
        driver.get().get(url);
        driver.get().manage().window().maximize();
        logger.info("Navigated to url " + url);
        System.out.println("URL opened");
    }

    public void clickOn(By locator){
        WebElement webElement = driver.get().findElement(locator);
        webElement.click();
        logger.info("Clicked on element with locator " + locator);
    }

    public void enterText(By locator, String text){
        WebElement webElement = driver.get().findElement(locator);
        webElement.sendKeys(text);
        logger.info("Entered text" +  text + " into " + locator);
    }

    public String getVisibletext(By locator){
        return driver.get().findElement(locator).getText().trim();
    }

    public String getPageTitle(){
        return driver.get().getTitle();
    }

    public static String takeScreenshot(String name){
       TakesScreenshot screenshot =  (TakesScreenshot)driver.get();
       File screenshotData  = screenshot.getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
       String path = System.getProperty("user.dir") + "/screenshots/" + name + " - " + timestamp + ".png";
       File screenshotfile = new File(path);
        try {
            FileUtils.copyFile(screenshotData, screenshotfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }





}
