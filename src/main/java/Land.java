import org.openqa.selenium.By;

public class Land extends Advertisement {
    private String [] purposes;

    public Land(String city, String microdistrict, String street, String phoNo, String area, String price, String[] purposes, String photo){
        super(city, microdistrict, street,  phoNo, area, price, photo);
        this.purposes = purposes;

    }

    public void fillAd(){
        Utils.driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=11&offer_type=1");
        this.fillGeneral();
        this.selectPurpose();


        submit();
    }

    public void selectPurpose() {

        for (int i = 0; i < purposes.length; i++) {
            switch (purposes[i]) {
                case "Namų valda":
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
                case "Miškų ūkio":
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
                default:
                    System.out.println("buvo paduota tai ko nera");

            }
        }
    }

}
