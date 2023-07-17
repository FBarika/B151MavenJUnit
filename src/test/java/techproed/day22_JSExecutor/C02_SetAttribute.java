package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_SetAttribute extends TestBase {

    @Test
    public void test01() {

        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();// reklami kapatiyor.

        //Arama kutusuna QA yaz
        /*
        <input> tag'ina sahip webelementlere deger gönderirken sendKeys() methodu kullaniriz.
        sendKeys() methodu ile deger gönderemedigimiz durumlarda js executor ile rahatlikla deger göndeririz.
        <input> taglarina value attributu degeri, arama kutusu icindeki veriyi temsil eder.
        */

        WebElement  aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='QA'",aramaKutusu);//--> value attribute deger QA yazdir.

    }

    @Test
    public void test02() {
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();// reklami kapatiyor.

        //Arama kutusuna QA yaz
        WebElement  aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        jsSendKeys("QA",aramaKutusu);

    }

    @Test
    public void test03() {
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();// reklami kapatiyor.

        //Arama kutusuna QA yaz
        /*
        JS Executor bir attribute deger atayabiliriz.Asagidaki örnekteki gibi.
        Sayfadaki arama kutusunu locate edip arama kutusunun value attributune 'QA' degerini atariz.
         */
        WebElement  aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','QA')",aramaKutusu);

    }

    @Test
    public void test04() {
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();// reklami kapatiyor.

        //Arama kutusuna QA yaz
        WebElement  aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('id','barika')",aramaKutusu);//burada geçici süreliğine attribute degerlerini değiştirebildik

        //-->elementor-search-form-9f26725 normalde id attribute degeri
        driver.findElement(By.id("barika")).sendKeys("QA", Keys.ENTER);

    }

    @Test
    public void test05() {
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();// reklami kapatiyor.

        //Arama kutusuna QA yaz
        WebElement  aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        jsSetAttribute("value","QA",aramaKutusu);//Method ile attribute degerini set ettik.

    }
}
