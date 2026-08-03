package selenium_apis;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShadowDomTest{
    private WebDriver driver = new ChromeDriver();


    @Test
    public void shadowDomTest1() throws InterruptedException {
        driver.navigate().to("https://selectorshub.com/xpath-practice-page/");
        driver.findElement(By.cssSelector("#userName"))
                .getShadowRoot().findElement(By.cssSelector("input#kils")).sendKeys("Hello!!!");
        Thread.sleep(5000);

    }

    @Test
    public void shadowDomTest2() throws InterruptedException {
        driver.navigate().to("https://selectorshub.com/xpath-practice-page/");
        driver.findElement(By.cssSelector("#nested-1")).getShadowRoot().findElement(By.cssSelector("[data-testid='card-inside']"))
                .getShadowRoot().findElement(By.cssSelector("input#kils")).sendKeys("Hello!!!");
        Thread.sleep(5000);

    }

    @Test
    public void shadowDomTest3() throws InterruptedException {
        driver.navigate().to("" +
                "");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        Thread.sleep(5000);
        WebElement element = (WebElement) jse.executeScript("return document.querySelector('settings-ui').shadowRoot.querySelector('settings-main').shadowRoot.querySelector('cr-view-manager settings-appearance-page-index').shadowRoot.querySelector('cr-view-manager settings-appearance-page').shadowRoot.querySelector('settings-section settings-toggle-button').shadowRoot.querySelector('cr-toggle').shadowRoot.querySelector('span')");
        jse.executeScript("arguments[0].click()", element);
        //element.click();
        Thread.sleep(5000);

    }
}
