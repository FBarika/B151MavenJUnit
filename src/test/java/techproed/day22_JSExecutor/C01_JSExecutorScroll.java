package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_JSExecutorScroll extends TestBase {

    @Test
    public void test01() {
        /*
        Actions classindaki gibi js executor ile de sayfada scroll islemi yapabilriz.Bir we locate edip o webelement
        görünür olana kadar scroll yapabiliriz.
        "arguments[0].scrollIntoView(true);",Webelement --> Bu script kodu ile belirtmis oldugumuz webelemente scroll yapariz.
         */

        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();// reklami kapatiyor.

        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weofferWE = driver.findElement(By.xpath("//*[text()='we offer']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",weofferWE);
        bekle(2);
        webelementResmi(weofferWE);

        //Aynı sayfada "Enroll Free Course"elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFreeWE = driver.findElement(By.xpath("//*[.='Enroll Free Course']"));
        js.executeScript("arguments[0].scrollIntoView(true);",enrollFreeWE);
        bekle(2);
        webelementResmi(enrollFreeWE);

        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUs = driver.findElement(By.xpath("//*[text()='WHY US?']"));
        js.executeScript("arguments[0].scrollIntoView(true);",whyUs);
        bekle(2);
        webelementResmi(whyUs);

        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        js.executeScript("arguments[0].scrollIntoView(true);",enrollFreeWE);
        bekle(2);
        webelementResmi(enrollFreeWE);

        //Sayfayı en alta scroll yapalım
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");// sayfanin en altina indirir.

        //Sayfayi en üste scroll yapalım
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");//sayfanin en üstüne cikarir

    }

    @Test
    public void test02() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();// reklami kapatiyor.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,2000)");//-->x=0,y=2000 pixel olarak bir noktaya scroll yapar

    }

    @Test
    public void test03() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();// reklami kapatiyor.

        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weofferWE = driver.findElement(By.xpath("//*[text()='we offer']"));
        jsScrollWE(weofferWE);
        bekle(2);
        webelementResmi(weofferWE);

        //Aynı sayfada "Enroll Free Course"elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFreeWE = driver.findElement(By.xpath("//*[.='Enroll Free Course']"));
        jsScrollWE(enrollFreeWE);
        bekle(2);
        webelementResmi(enrollFreeWE);

        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUs = driver.findElement(By.xpath("//*[text()='WHY US?']"));
        jsScrollWE(whyUs);
        bekle(2);
        webelementResmi(whyUs);

        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        jsScrollWE(enrollFreeWE);
        bekle(2);
        webelementResmi(enrollFreeWE);

        //Sayfayı en alta scroll yapalım
        scrollEnd();
        bekle(2);

        //Sayfayi en üste scroll yapalım
        scrollHome();

    }
}
