package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;
         /*
       Eger bir sayfadaki bir butona tikladigimizda bir uyari penceresi cikiyorsa ve bu cikan pencereye sag click yapip
       locate alamiyorsak bu bir JavaScript Alert tür. Js Alert'U handle edebilmek icin driverimizi o
       pencereye gecirmemiz gerekir.Bunun icin driver objemizi kullanarak switchTo() methoduyla alert() methodu
       kullanarak js alert'e gecis yapmis oluruz.Accept() ya da dismiss() methodlariyla js Alert'ü
       onaylar ya da iptal ederek kapatiriz.
        */





public class C02_Alerts  extends TestBase {
    @Test
    public void test01() {
        //Bir metod olusturun: acceptAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        bekle(3);
        driver.switchTo().//gecmek icin kullanilan method
                alert().//alert'e gecis yapar.
                accept();//cikan alert'te ok ya da tamam butonuna tiklar.
        bekle(2);
        WebElement result = driver.findElement(By.id("result"));
        String istenenYazi ="You successfully clicked an alert";
        Assert.assertEquals(result.getText(),istenenYazi);


    }

    @Test
    public void test02() {
                 //Bir metod olusturun: dismissAlert
                 //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
                 driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

                 //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
                 driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
                 bekle(3);
                 driver.switchTo().
                         alert().
                         dismiss();//js alert'teki iptal butonuna basar.

                 WebElement result = driver.findElement(By.id("result"));
                 String istenenYazi ="successfully";
                 Assert.assertFalse(result.getText().contains(istenenYazi));

    }

    @Test @Ignore //--> Çalışmasını istemediğimiz test notasyonundan sonra (@Test) @Ignore notasyonu kullanırız
    public void test03() {
        //Bir metod olusturun: sendKeysAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        bekle(3);

        driver.switchTo().
                alert().sendKeys("Barika");
        bekle(2);
        driver.switchTo().alert().accept();
        bekle(3);

        WebElement result = driver.findElement(By.id("result"));
        String girilenMetin ="Barika";
        Assert.assertTrue(result.getText().contains(girilenMetin));
        bekle(3);









    }
}
