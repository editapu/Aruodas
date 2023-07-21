import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AruodasAd {
    private String city;
    private String phoNo;
    private String area;
    private String price;
    private String[] purposes;
    private String microdistrict;
    private String street;
    private String no;
    private String description;

    public AruodasAd(String city, String microdistrict, String street, String no, String phoNo, String area, String description, String price, String[] purposes) {
        this.city = city;
        this.microdistrict = microdistrict;
        this.street = street;
        this.no = no;
        this.phoNo = phoNo;
        this.area = area;
        this.description = description;
        this.price = price;
        this.purposes = purposes;
    }

    public void fillAd() {
        Utils.driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=11&offer_type=1");   //isidejus urla nebereikia zemiau papilkintu esanciu veiksmu
        //driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div/div/a")).click();
        //driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[1]/ul/li[3]/img")).click();
        //driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/ul/li[1]")).click();
        selectRegion();
        selectMicrodistrict();
        selectStreet();
        Utils.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/input")).sendKeys("2");
        Utils.driver.findElement(By.id("fieldFAreaOverAll")).sendKeys(this.area);
        this.selectPurpose();
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[26]/div/div[1]/textarea")).sendKeys("Labas");
        Utils.driver.findElement(By.id("priceField")).sendKeys(this.price);
        Utils.driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[34]/span[1]/input")).sendKeys(this.phoNo);
        submit();
    }
    public void selectRegion() {
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/span")).click();
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/ul[2]/li[1]/input")).sendKeys(this.city);
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/ul[2]/li[63]"), this.city));
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[3]/span[1]/ul[2]/li[1]/input")).sendKeys(Keys.ENTER);
    }
    public void selectMicrodistrict() {
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[5]/span[1]/span[2]")).click();
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[5]/span[1]/ul[2]/li[1]/input")).sendKeys("Kairėnai");
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[5]/span[1]/ul[2]/li[67]"), this.microdistrict));
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[5]/span[1]/ul[2]/li[1]/input")).sendKeys(Keys.ENTER);
    }
    public void selectStreet() {
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[6]/span[1]/span[2]")).click();
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[6]/span[1]/ul[2]/li[1]/input")).sendKeys("Gailių");
        Utils.wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[2]/form/ul/li[6]/span[1]/ul[2]/li[2961]"), this.street));
        Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[6]/span[1]/ul[2]/li[1]/input")).sendKeys(Keys.ENTER);
    }
    public void submit() {
        Utils.driver.findElement(By.id("submitFormButton")).click();
    }
    public void selectPurpose() {

        for (int i = 0; i < this.purposes.length; i++) {
            switch (purposes[i]) {
                case "Namu valda":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[1]/label")).click();
                    break;
                case "Daugiabuciu statyba":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[2]/label")).click();
                    break;
                case "Zemes ukio":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[3]/label")).click();
                    break;
                case "Sklypas soduose":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[4]/label")).click();
                    break;
                case "Misku ukio":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[5]/label")).click();
                    break;
                case "Pramones":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[6]/label")).click();
                    break;
                case "Sandeliavimo":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[7]/label")).click();
                    break;
                case "Komercine":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[8]/label")).click();
                    break;
                case "Rekreacine":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[9]/label")).click();
                    break;
                case "Kita":
                    Utils.driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[16]/div/div[10]/label")).click();
                    break;

            }

        }
    }


}
