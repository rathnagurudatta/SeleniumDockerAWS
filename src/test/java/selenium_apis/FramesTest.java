package selenium_apis;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class FramesTest{

    private WebDriver driver = new ChromeDriver();

    @Test  // [frame1 (frame2  (frame3))]
    public void framesTest1() throws InterruptedException {
        driver.navigate().to("https://app.thetestingacademy.com/playwright/frames/nested-iframes");
        List<WebElement> list = driver.findElements(By.tagName("iframe"));
        System.out.println("size of list --> " + list.size());
        for(int i=0; i<list.size(); i++){
            System.out.println("id --> " + list.get(i).getAttribute("id"));
            System.out.println("name --> " + list.get(i).getAttribute("name"));
            System.out.println("title --> " + list.get(i).getAttribute("title"));
            System.out.println("src --> " + list.get(i).getAttribute("src"));
            System.out.println("**************************");
        }

        WebElement frame1 = driver.findElement(By.id("pact1"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.id("inp_val")).sendKeys("inside frame1");

        WebElement frame2 = driver.findElement(By.id("pact2"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.id("jex")).sendKeys("inside frame2");

        WebElement frame3 = driver.findElement(By.id("pact3"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.id("glaf")).sendKeys("inside frame3");

        Thread.sleep(5000);

        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.xpath("//h1[@id='page-title']")).getText());

//        driver.switchTo().parentFrame();
//        driver.findElement(By.id("jex")).sendKeys("rename frame2");
//
//        driver.switchTo().parentFrame();
//        driver.findElement(By.id("inp_val")).sendKeys("rename frame1");

        Thread.sleep(8000);






    }

    @Test  // [frame1 (frame2  (frame3))]
    public void framesTest2() throws InterruptedException {
        driver.navigate().to("http://uitestingplayground.com/frames");
        List<WebElement> list = driver.findElements(By.tagName("iframe"));
        System.out.println("size of list --> " + list.size());
        for(int i=0; i<list.size(); i++){
            System.out.println("id --> " + list.get(i).getAttribute("id"));
            System.out.println("name --> " + list.get(i).getAttribute("name"));
            System.out.println("title --> " + list.get(i).getAttribute("title"));
            System.out.println("src --> " + list.get(i).getAttribute("src"));
            System.out.println("**************************");
        }

        WebElement frame1 = driver.findElement(By.id("frame-outer"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("//div[text()='Outer Frame (Level 1)']/following-sibling::button[text()='Edit']")).click();

        WebElement frame2 = driver.findElement(By.id("frame-inner"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.xpath("//div[text()='Inner Frame (Level 2)']/following-sibling::button[text()='Submit']")).click();

        Thread.sleep(5000);

//        driver.switchTo().parentFrame();
//        driver.findElement(By.xpath("//div[text()='Outer Frame (Level 1)']/following-sibling::button[text()='Primary']")).click();
//        Thread.sleep(5000);

        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.xpath("//h3[text()='Frames']/following-sibling::p")).getText());
        Thread.sleep(10000);


    }

    @Test  // [frame1 (frame2  (frame3))]
    public void framesTest3() throws InterruptedException {
        driver.navigate().to("https://testpages.eviltester.com/pages/embedded-pages/frames/");
        List<WebElement> list = driver.findElements(By.tagName("frame"));
        System.out.println("size of list --> " + list.size());
        for(int i=0; i<list.size(); i++){
            System.out.println("id --> " + list.get(i).getAttribute("id"));
            System.out.println("name --> " + list.get(i).getAttribute("name"));
            System.out.println("title --> " + list.get(i).getAttribute("title"));
            System.out.println("src --> " + list.get(i).getAttribute("src"));
            System.out.println("**************************");
        }

        WebElement frame1 = driver.findElement(By.name("left"));
        driver.switchTo().frame(frame1);
        String content1 = driver.findElement(By.xpath("//h1[text()='Left']/following-sibling::ul/li[1]")).getText();
        System.out.println("content1 " + content1);

        driver.switchTo().defaultContent();

        WebElement frame2 = driver.findElement(By.name("middle"));
        driver.switchTo().frame(frame2);
        String content2 = driver.findElement(By.xpath("//h1[text()='Middle']/following-sibling::ul/li[1]")).getText();
        System.out.println("content2 " +content2);
        Thread.sleep(5000);




    }
}
