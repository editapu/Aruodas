import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LandTests {

    @Test
    public void makeAdPositiveTest() {
        Land ad = new Land("Vilnius", "Kairėnai", "Gailių", "867302723", "2","45835",  new String[]{Purpose.miskuUkio,Purpose.namuValda},"//*[@id=\"uploadPhotoBtn\"]/input");
        ad.fillAd();
    }

    @Test

    @BeforeClass
    public void beforeClass() {
        Utils.driver = new ChromeDriver();
        Utils.driver.manage().window().maximize();
        Utils.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Utils.wait = new WebDriverWait(Utils.driver, Duration.ofSeconds(5));
        Utils.acceptCookies();
        Utils.login();
    }

    @AfterClass
    public void afterClass() {

    }
}


