import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Advertisement {     // sukurta tevine klase. sioje klaseje nugula visi universalus duomenys
    private String city;
    private String microdistrict;
    private String street;
    private String phoNo;
    private String area;
    private String price;
    private String photo;



    // zemiau nurodyta tevinis konstruktorius
    public Advertisement(String city, String microdistrict, String street, String phoNo, String area, String price, String photo) {
        this.city = city;
        this.microdistrict = microdistrict;
        this.street = street;
        this.phoNo = phoNo;
        this.area = area;
        this.price = price;
        this.photo = photo;
    }

    public void fillGeneral() {    // nusirodom atskirus metodus
        selectRegion();
        selectDistrict();
        selectStreet();
        fillArea();
        fillPrice();
        fillPhone();
        selectPhoto();
    }

    public void fillArea() {
        if (this.getArea().equals("")) {
            return;
        }
        Utils.driver.findElement(By.id("fieldFAreaOverAll")).sendKeys(this.getArea());
    }

    public void fillPrice() {
        if (this.getPrice().equals("")) {
            return;
        }
        Utils.driver.findElement(By.id("priceField")).sendKeys(this.getPrice());
    }

    public void fillPhone() {
        if (this.getPhoNo().equals("")) {
            return;
        }
        Utils.driver.findElement(By.name("phone")).sendKeys(this.getPhoNo());
    }

    public void selectDistrict() {
        if (this.getMicrodistrict().equals("")) {
            return;
        }
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[5]/span[1]/input[2]")).click();
        Utils.driver.findElements(By.className("dropdown-input-values-address")).get(1).findElement(By.tagName("input")).sendKeys(this.getMicrodistrict());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int rows = Utils.driver.findElements(By.className("dropdown-input-values-address")).get(1).findElements(By.tagName("li")).size() - 1;
        Utils.driver.findElements(By.className("dropdown-input-values-address")).get(1).findElements(By.tagName("li")).get(rows).click();
    }

    public void selectRegion() {
        if (this.getCity().equals("")) {
            return;
        }
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/span")).click();
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/ul[2]/li[1]/input")).sendKeys(this.getCity());
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/ul[2]/li[63]"), this.getCity()));
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/ul[2]/li[1]/input")).sendKeys(Keys.ENTER);
    }

    // public void selectMicrodistrict() {
    //    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[5]/span[1]/span[2]")).click();
    //    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[5]/span[1]/ul[2]/li[1]/input")).sendKeys("Kairėnai");
    //   Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[5]/span[1]/ul[2]/li[67]"), this.microdistrict));
    //   Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[5]/span[1]/ul[2]/li[1]/input")).sendKeys(Keys.ENTER);


    public void selectStreet() {
        if(this.getStreet().equals("")){
            return;
        }
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[6]/span[1]/span[2]")).click();
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[6]/span[1]/ul[2]/li[1]/input")).sendKeys("Gailių");
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[6]/span[1]/ul[2]/li[2961]"), this.street));
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[6]/span[1]/ul[2]/li[1]/input")).sendKeys(Keys.ENTER);
    }

    public void selectPhoto() {
        if(this.getPhoto().equals("")){
            return;
        }
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[28]/div/div[1]/a")).click();
        Utils.driver.findElement(By.xpath("//*[@id=\"uploadPhotoBtn\"]/input")).sendKeys("C:\\Users\\irtor\\Desktop\\objects-31455.jpeg");
}

    public void submit() {
        Utils.driver.findElement(By.id("submitFormButton")).click();
    }

    //public void deleteAd() {
        //Utils.driver.get("https://www.aruodas.lt/mano-aruodas/");
        //Utils.driver.findElement(By.id("deleteActionButton")).click();
        //Utils.driver.findElement(By.xpath("//*[@id=\"fancybox-content\"]/div/div/form/label[2]/input")).click();
        //Utils.driver.findElement(By.xpath("/html/body/div[9]/div/div[10]/div/div/form/p/button")).click();

    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getMicrodistrict(){
        return microdistrict;
    }
    public void setMicrodistrict(String microdistrict){
        this.microdistrict = microdistrict;
    }

    public String getStreet(){
        return street;
    }

    public void setStreet(String street){
        this.street = street;
    }
    public String getPhoNo(){
        return phoNo;
    }

    public void setPhoNo(String phoNo){
        this.phoNo = phoNo;
    }
    public String getArea(){
        return area;
    }
    public void setArea(String area){
        this.area = area;
    }
    public String getPrice(){
        return price;
    }
    public void setPrice(String price){
        this.price = price;
    }

    public String getPhoto(){
        return photo;
    }
    public void setPhoto(String photo){
        this.photo = photo;
    }

        }




