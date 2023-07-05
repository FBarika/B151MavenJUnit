package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_FileUploadTest extends TestBase {

    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        /*
        Eger dosyaSec butonuna basmamiz istenirse ve otomasyon ile bu butona click yapmak istedigimizde exception aliyorsak,
        direkt upload yapmak istedigimiz dosya yolunu alip sendKeys() methodu ile dosyayi sayfaya upload yapabiliriz.

        Eger upload ya da dosyaSec butonuna tikladiginizda windows penceresi aciliyorsa o webelemnte sendKeys() methodu ile dosya
        gönderemeyebilirsiniz.Böyle bir durum ile karsilasirsaniz Robot classindan obje ile methodlar kullanarak bunu asabilirsiniz.
         */
        String dosyaYolu ="C:\\Users\\Barika\\Desktop\\barika.txt";
        //chooseFile butonuna basalim
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        //dosyaSec.click();
        //Yuklemek istediginiz dosyayi secelim.
        dosyaSec.sendKeys(dosyaYolu);
        bekle(2);


        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        bekle(2);

        //"File Uploaded!" textinin goruntulendigini test edelim.
        WebElement text = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(text.isDisplayed());
    }
}
