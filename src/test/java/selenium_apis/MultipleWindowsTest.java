package selenium_apis;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class MultipleWindowsTest{
    private WebDriver driver = new ChromeDriver();

    @Test
    public void multipleWindowsTest() throws InterruptedException {
        driver.navigate().to("https://freelance-learn-automation.vercel.app/login");
        List<WebElement> list = driver.findElements(By.cssSelector("div.social a"));
        String parentWindow = driver.getWindowHandle();

        for(WebElement ele : list){
            ele.click();
        }

        Set<String> setOfWinhandles = driver.getWindowHandles();
        System.out.println("size = " + setOfWinhandles.size());
        for(String handle: setOfWinhandles){
            System.out.println("handle id = " + handle);
            driver.switchTo().window(handle);
            System.out.println("page title = " + driver.getTitle());
        }

        driver.quit();
    }
}
