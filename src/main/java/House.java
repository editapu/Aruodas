import org.openqa.selenium.By;

public class House extends Advertisement {   // nurodomas paveldimumas
    private String landArea;
    private String buildYear;

    public House(String city, String microdistrict, String street, String phoNo, String houseSize, String landArea, String price, String buildYear, String photo) {
        super(city, microdistrict, street, phoNo, houseSize, price, photo);   // super reiskia tevinis konstruktorius
        this.landArea  = landArea;
        this.buildYear = buildYear;
    }

    public void fillAd() {
        Utils.driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=2&offer_type=1");
        fillGeneral();
        fillLandArea();
        fillBuildYear();

       // submit();
    }
    public void fillLandArea(){
        Utils.driver.findElement(By.id("fieldFAreaLot")).sendKeys(this.landArea);
    }

    public void fillBuildYear(){
        Utils.driver.findElement(By.name("FBuildYear")).sendKeys(this.buildYear);
    }
}
