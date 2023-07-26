import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LandTests {

    @Test
    public void makeAdPositiveTest() {
        Land ad = new Land("Vilnius", "Kairėnai", "Gailių", "867302723", "2", "45835", new String[]{Purpose.miskuUkio, Purpose.namuValda}, "//*[@id=\"uploadPhotoBtn\"]/input");
        ad.fillAd();
    }

    @Test
    public void tooShortPhoneNumberTest() {
        Land ad = new Land("Vilnius", "Kairėnai", "Gailių", "112", "2", "45835", new String[]{Purpose.miskuUkio, Purpose.namuValda}, "//*[@id=\"uploadPhotoBtn\"]/input");
        ad.fillAd();
        Assert.assertEquals(Utils.driver.findElement(By.name("phone")).getText(), "Neteisingas telefono numeris");
        // Failed
    }

    @Test
    public void tooLongPhoneNumberTest() {
        Land ad = new Land("Vilnius", "Kairėnai", "Gailių", "+370673025897858", "2", "45835", new String[]{Purpose.miskuUkio, Purpose.namuValda}, "//*[@id=\"uploadPhotoBtn\"]/input");
        ad.fillAd();
        Assert.assertEquals(Utils.driver.findElement(By.name("phone")).getText(), "Neteisingas telefono numeris");
        // Failed
    }

    @Test
    public void emptyPhoneFieldTest() {
        Land ad = new Land("Vilnius", "Kairėnai", "Gailių", " ", "2", "200 ", new String[]{Purpose.miskuUkio, Purpose.namuValda}, "//*[@id=\"uploadPhotoBtn\"]/input");
        ad.fillAd();
        Assert.assertEquals(Utils.driver.findElement(By.name("phone")).getText(), "Neteisingas telefono numeris");
        //Failed
    }

    @Test
    public void specialCharacterInsteadNumbersPhoneTest() {
        Land ad = new Land("Vilnius", "Kairėnai", "Gailių", "#", "2", "200 ", new String[]{Purpose.miskuUkio, Purpose.namuValda}, "//*[@id=\"uploadPhotoBtn\"]/input");
        ad.fillAd();
        Assert.assertEquals(Utils.driver.findElement(By.name("phone")).getText(), "Neteisingas telefono numeris");
        //Failed
    }

    @Test
    public void lettersInsteadNumbersPhoneTest() {
        Land ad = new Land("Vilnius", "Kairėnai", "Gailių", "LOVE", "2", "200 ", new String[]{Purpose.miskuUkio, Purpose.namuValda}, "//*[@id=\"uploadPhotoBtn\"]/input");
        ad.fillAd();
        Assert.assertEquals(Utils.driver.findElement(By.name("phone")).getText(), "Neteisingas telefono numeris");
        //Failed
    }

    @Test
    public void tooLowPriceTest() {
        Land ad = new Land("Vilnius", "Kairėnai", "Gailių", "+37067302723", "2", "1", new String[]{Purpose.miskuUkio, Purpose.namuValda}, "//*[@id=\"uploadPhotoBtn\"]/input");
        ad.fillAd();
        Assert.assertEquals(Utils.driver.findElement(By.id("priceField")).getText(), "Kaina per maža");
        //Failed
    }

    @Test  // ?????????
    public void tooManyNumbersPriceTest() {
        Land ad = new Land("Vilnius", "Kairėnai", "Gailių", "+37067302723", "2", "12587458965325874589589568978542158965832589857458569852587456", new String[]{Purpose.miskuUkio, Purpose.namuValda}, "//*[@id=\"uploadPhotoBtn\"]/input");
        ad.fillAd();

    }

    @Test
    public void price0Test() {
        Land ad = new Land("Vilnius", "Kairėnai", "Gailių", "+37067302723", "2", "0", new String[]{Purpose.miskuUkio, Purpose.namuValda}, "//*[@id=\"uploadPhotoBtn\"]/input");
        ad.fillAd();
        Assert.assertEquals(Utils.driver.findElement(By.id("priceField")).getText(), "Neteisinga kaina");
        //Failed
    }

    @Test
    public void emptyPriceFieldTest() {
        Land ad = new Land("Vilnius", "Kairėnai", "Gailių", "+37067302723", "2", " ", new String[]{Purpose.miskuUkio, Purpose.namuValda}, "//*[@id=\"uploadPhotoBtn\"]/input");
        ad.fillAd();
        Assert.assertEquals(Utils.driver.findElement(By.id("priceField")).getText(), "Neteisinga kaina");
        //Failed
    }

    @Test
    public void lettersInsteadNumbersPriceTest() {
        Land ad = new Land("Vilnius", "Kairėnai", "Gailių", "+37067302723", "2", "SUN", new String[]{Purpose.miskuUkio, Purpose.namuValda}, "//*[@id=\"uploadPhotoBtn\"]/input");
        ad.fillAd();
        Assert.assertEquals(Utils.driver.findElement(By.id("priceField")).getText(), "Neteisinga kaina");
        //Failed
    }

    @Test
    public void specialCharacterInsteadNumbersPriceTest() {
        Land ad = new Land("Vilnius", "Kairėnai", "Gailių", "+37067302723", "2", "#", new String[]{Purpose.miskuUkio, Purpose.namuValda}, "//*[@id=\"uploadPhotoBtn\"]/input");
        ad.fillAd();
        Assert.assertEquals(Utils.driver.findElement(By.id("priceField")).getText(), "Neteisinga kaina");
        //Failed
    }

    @Test
    public void addingASpaceAtTheEndPriceTest() {
        Land ad = new Land("Vilnius", "Kairėnai", "Gailių", "+37067302723", "2", "200 ", new String[]{Purpose.miskuUkio, Purpose.namuValda}, "//*[@id=\"uploadPhotoBtn\"]/input");
        ad.fillAd();
        Assert.assertEquals(Utils.driver.findElement(By.id("priceField")).getText(), "200");
        //Passed
    }

    @Test   // ???????  testas pasino, bet pazymejo tik 3 is viso saraso
    public void pickAllPurposesTest() {
        Land ad = new Land("Vilnius", "Kairėnai", "Gailių", "+37067302723", "2", "200 ", new String[]{Purpose.miskuUkio, Purpose.namuValda, Purpose.daugiabuciuStatyba, Purpose.sklypasSoduose, Purpose.zemesUkio, Purpose.pramones, Purpose.sandeliavimo, Purpose.komercine, Purpose.rekreacine, Purpose.kita}, "//*[@id=\"uploadPhotoBtn\"]/input");
        ad.fillAd();
        Assert.assertEquals(Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/label")).getText(), "");
        //Passed
    }
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


