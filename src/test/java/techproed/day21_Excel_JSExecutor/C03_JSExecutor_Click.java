package techproed.day21_Excel_JSExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_JSExecutor_Click extends TestBase {

    /*
    Bir web sayfasinda bazi webelementler olusturulurken Java Script kodlariyla olusturulmus olabilir. Bu Webelemntleri handle edebilmek icin
    JavaScriptExecutor arayüzünü kullanmamiz gerekir.
    Bir webelement javascript ile kodlari ile yazilmamis olsa da JavascriptExecutor ile o webelementi handle edebiliriz.Normal bildigimiz methodlardan
    daha yavas calisacagi icin bildigimiz methodlar isimizi görüyorsa onlari kullaniriz.
    <script> tagi ile olusturulmus olan webelementleri de js executor ile handle edebiliriz.
    */

    @Test
    public void test01() {
        //Amazon sayfasina gidiniz
        driver.get("https://amazon.com");
        //driver.findElement(By.xpath("(//*[@class='a-button-input'])[1]")).click();  --> sell butonunu kapatan uayriyi kapatmak icin kod.

        //sell linkinin resmini alalim.
        WebElement sellLinki = driver.findElement(By.xpath("//*[text()='Sell']"));
        webelementResmi(sellLinki);

        //Sell linkine js executor kullanarak tiklayiniz
        JavascriptExecutor js = (JavascriptExecutor) driver;// sell linkini js kodlariyla yazilmamasina ragmen js Executor kullanarak tikladik.
        js.executeScript("arguments[0].click();",sellLinki);//dezavantaji daha yavas calismasi olabilir ve executeScript icerisine noktasina virgülüne kadar yazmak lazim.

        //Basligin Sell icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanin resmini alalim
        tumSayfaResmi();

    }

    @Test
    public void test02() {
        //Amazon sayfasina gidiniz
        driver.get("https://amazon.com");

        //sell linkinin resmini alalim.
        WebElement sellLinki = driver.findElement(By.xpath("//*[text()='Sell']"));
        webelementResmi(sellLinki);

        //Sell linkine js executor kullanarak tiklayiniz
        sellLinki.click();//javascript ile click yapabildi ama resmi farkli aldi burda ise click yapamadi bile
        /*
           JS executor ile Webelementin önünde uyarı çıkmasına rağmen webelemente click yaptı çünkü kodlara direk ulaşıyor
           Normal kullandığımız click methodu burda önünde farklı bir element olduğu için ElementClickInterceptedException:
           hatası verdi.Dolayısıyla bu exception ile karşılaştığımızda da js executor ile bunu çözebiliriz
        */

        //Basligin Sell icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanin resmini alalim
        tumSayfaResmi();
    }

    @Test
    public void test03() {
        //Amazon sayfasina gidiniz
        driver.get("https://amazon.com");
        driver.findElement(By.xpath("(//*[@class='a-button-input'])[1]")).click();//--> uyari kapatildi.

        //sell linkinin resmini alalim.
        WebElement sellLinki = driver.findElement(By.xpath("//*[text()='Sell']"));
        bekle(2);
        webelementResmi(sellLinki);

        //Sell linkine js executor kullanarak tiklayiniz
        click(sellLinki);//-->Click() methodu ile normal click yapmayi denedifakat olmadi js executor ile click yapti.

        //Basligin Sell icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanin resmini alalim
        tumSayfaResmi();

    }
}
