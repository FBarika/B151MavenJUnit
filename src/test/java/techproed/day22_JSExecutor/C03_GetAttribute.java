package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_GetAttribute extends TestBase {

    @Test
    public void test01() {

        //  https://www.carettahotel.com/ a gidiniz
        driver.get("https://www.carettahotel.com/");
        bekle(2);
        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        bekle(2);
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();

        //  Tarih kısmını JS ile locate ediniz.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement date = (WebElement) js.executeScript("return document.getElementById('checkin_date')");
        //WebElement date = (WebElement) js.executeScript("return document.querySelector(\"input[id='checkin_date']\")");

        /*
        Java Script kodlariyla yazilmis webelementleri bizim bildigimiz findElement() locate edemeyebiliriz.
        js Executor kullanarak ister html ister java script ile yazilmis olsun, bir webelementin locateni Js Executor ile alabilirz.
        Yukaridaki örnekte sayfadaki tarih webelementini js Executor ile locate ettik.
         */
        date.clear();
        date.sendKeys("5/25/2023");

        //  Date webelementinin Attribute degerlerini yazdiralim.
        String idAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').id").toString();
        String typeAttributeDegeri =js.executeScript("return document.getElementById('checkin_date').type").toString();
        String nameAttributeDegeri =js.executeScript("return document.getElementById('checkin_date').name").toString();
        String valueAttributeDegeri =js.executeScript("return document.getElementById('checkin_date').value").toString();
        System.out.println("idAttributeDegeri = " + idAttributeDegeri);
        System.out.println("typeAttributeDegeri = " + typeAttributeDegeri);
        System.out.println("nameAttributeDegeri = " + nameAttributeDegeri);
        System.out.println("valueAttributeDegeri = " + valueAttributeDegeri);

        /*
        Js Executor ile ettribute degerlerini yazdirabilmek icin js ile locate ettigimiz webelementin sonuna yukaridaki örnekteki
        gibi hangi attribute degeri yazdirmak istersek onun attribute degerini aliriz.
         */


    }

    @Test
    public void test02() {

        //https://www.priceline.com/ adresine gidiniz
        driver.get("https://www.priceline.com/");
        driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();//cerezi kabul ettik.

        //Submit butonunun rengini Kirmizi yazınız
        WebElement buton = driver.findElement(By.xpath("//div[text()='Find Your Hotel']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.color='red';",buton);

    }
}
