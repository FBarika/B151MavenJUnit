package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    /*
    TIME_OUT_EXCEPTION
          Expilict wait kullanirken yanlis method ya da yanlis max. bekleme süresi gibi durumlarda org.openqa.selenium.TimeoutException aliriz.
     */
    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

       //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

       //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));
        /*
        org.openqa.selenium.TimeoutException: normalde helloWorldText webelementi 5-6 saniye civarında
     etkileşime gireken biz max. bekleme süresini 2 saniye verdiğimiz için bu hatayı aldık.Dolayisiyla bu exception i handle edebilmek icin dogru süreyi ve
     dogru methodu kullanmamiz gerekir.
         */

        Assert.assertEquals("Hello World!",helloWorldText.getText());
    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        // WebElement helloWorldText = driver.findElement(By.xpath("yanlis locate"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Yanlis Locate")));
        /*
          Yukaridaki örnekte max süreyi dogru vermemize ragmen yanlis locate aldigimiz icin yine TimeOutException hatasi aliriz.Dolayisiyla
          bu exception i handle edbilmek icin locate i dogru almaliyiz.
        */

    }

    @Test
    public void test03() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //checkBox yazan butona tiklayalim.
        driver.findElement(By.xpath("//*[@id='checkbox']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='ch']")));

        /*
        org.openqa.selenium.TimeoutException: Gorunur olan bir webelementi gorunur olmayana kadar bekleme methodunu kullandigimiz
        icin TimeoutException hatasi aldik.Yanlis methodu kullandigimiz icin bu hatayi aldik.
         */

        //checkBox 'in secili oldugunu dogrulayalim.(checkbox i locate etmeliyiz)
        WebElement checkBox = driver.findElement(By.xpath("//*[@id='ch']"));
        Assert.assertTrue(checkBox.isSelected());





    }
}
