package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void test01() {
        /*
        NO_SUCH_ELEMENT_EXCEPTION
        Bir Webelementin locate ni yanlis aldigimizda  elementi bulamayacagi icin bu exception i aliriz.
        */

        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='ssearch']")); //burda locate i bilerek bozduk.
        //normal locate imiz //*[@type='search'] bu sekilde iken nosuchelementexception alabilmek icin locate i bozduk //*[@type='ssearch']
        // ve exception i aldigimizi gördük.Dolayisiyla bu hatayi handle edebilmek icin düzgün locate almamiz gerekiyor.Webelement bir iframe icinde
        //olabilir.Bir butona tikladigimizda yeni bir pencere acilabilir ya da alert cikabilir. Bu gibi durumlarda da nosuchelementexception aliriz.
        aramaKutusu.sendKeys("qa", Keys.ENTER);

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));

    }

    @Test
    public void test02() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.cssSelector("//*[@type='search']"));

        /*
        org.openqa.selenium.InvalidSelectorException: xpath ile aldigimiz bir webelementin locate ini cssSelector locator ile kullanirsak
        bu exception i aliriz.Dolayisiyla bunu handle etmek icin dogru locator'i kullanmamiz gerekir.
        */
        aramaKutusu.sendKeys("qa", Keys.ENTER);

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));

    }
}
