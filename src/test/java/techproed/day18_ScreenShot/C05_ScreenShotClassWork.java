package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C05_ScreenShotClassWork extends TestBase {

    @Test
    public void test01() throws IOException {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//-->Reklamı kapatır

        bekle(2);
        //sayfanın resmini alalım
        tumSayfaResmi();//--> Method ile tüm sayfanin resmini aldik.

        //Arama bölümünde java aratalım
        driver.findElement(By.id("elementor-search-form-9f26725")).sendKeys("java", Keys.ENTER);

        //ve sonuc yazısının resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("//h1"));
        webelementResmi(sonucYazisi);//--> Method ile webelement'in resmini aldik.

        //Yeni bir sekmede amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        //sayfanın resmini alalım
        tumSayfaResmi();//--> Method ile tüm sayfanin resmini aldik.

        //arama bölümde iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);

        //ve sonuc yazısının resmini alalım
        WebElement amazonSonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        webelementResmi(amazonSonucYazisi);

        //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım
        switchToWindow2(0);
        tumSayfaResmi();
    }
}
