package selenium_apis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class FileDownloadTest {

    @Test
    public void fileDownloadInChrome(){

    }

    @Test
    public void fileDownloadInEdge(){

    }

    @Test
    public void fileDownloadInFirefox(){

        FirefoxProfile profile = new FirefoxProfile();
        String downloadpath = System.getProperty("user.dir") + "/src/test/resources/testdata";
        profile.setPreference("browser.download.folderList", 2 ); //1 - desktop
        profile.setPreference("browser.download.dir", downloadpath);
        profile.setPreference("browser.helperapps.neverAsk.saveToDisk", "application/ms-doc");
        profile.setPreference("pdfjs.disabled", true);

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

        WebDriver driver = new FirefoxDriver(options);
        driver.get("");
    }
}
