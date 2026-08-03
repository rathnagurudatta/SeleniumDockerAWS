package selenium_apis;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static java.sql.DriverManager.getDriver;


public class AlertTest{

    private WebDriver driver = new ChromeDriver();

    @Test
    public void alertTest() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        System.out.println("content displayed on alert --> " + alert.getText());
        alert.sendKeys("I am amazing");
        alert.accept();
        //alert.dismiss();
        System.out.println("get text fom text area -->" + driver.findElement(By.id("result")).getText());
        Thread.sleep(5000);
    }
}
