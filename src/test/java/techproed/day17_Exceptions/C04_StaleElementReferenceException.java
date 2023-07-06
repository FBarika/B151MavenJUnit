package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.List;

public class C04_StaleElementReferenceException extends TestBase {
    /*
    STALE_ELEMENT_REFERENCE_EXCEPTION
    Bir Webelementin sayfayi refresh(yenileme) ya da back-forward yapma sonucundan eskimesi (bayatlamasi) durumunda bu exceptioni
    aliriz yani driver sayfayi yeniden olusturdugunda elementin locate i ayni olmasina ragmen tekrar o elementin locate ni almamizi ister
    almadigimiz takdirde locate i eskimis olarak görür ve staleelementexception hatasi verir.
     */

    @Test
    public void test01() {
        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //arama kutusunda qa aratalim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        driver.navigate().refresh();
        /*
        org.openqa.selenium.StaleElementReferenceException hatasi aldik cünkü refresh() yaptiktan sonra tekrar locate almadik.Dolayisiyla
        bu hatayi handle edebilmemiz icin refresh yaptiktan sonra tekrar locate almaliyiz.
         */

        aramaKutusu.sendKeys("qa", Keys.ENTER);//--> aramaKutusu locate i eskidigi icin sendKeys() methodunu kullanamadi.

        //sayfa basliginin qa icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));

    }

    @Test
    public void test02() {
        /*
         Bu test methodunda test01 methodundaki staleelementreference hatasini nasil handle ettigimizi
         gosterdik
         */
        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //arama kutusunda qa aratalim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        driver.navigate().refresh();

        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("qa", Keys.ENTER);

        //sayfa basliginin qa icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));

    }

    @Test
    public void test03() {
        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //arama kutusunda qa aratalim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        aramaKutusu.sendKeys("developer",Keys.ENTER);

        driver.navigate().back();
        //driver.navigate().forward();
        /*
        org.openqa.selenium.StaleElementReferenceException: back-forward sonrasinda da bu hatayi aldik.
         */

        aramaKutusu.sendKeys("qa", Keys.ENTER);

        //sayfa basliginin qa icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));

    }

    @Test
    public void test04() {
        //amazon sayfasina gidelim
        driver.get("https://amazon.com");

        //arama kutusuna iphone aratalim
        WebElement aranaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aranaKutusu.sendKeys("iphone",Keys.ENTER);

        //cikan sonuclardan ilk besine tiklayip her urunun basligini konsola yazdiralim

        List<WebElement> ürünler = driver.findElements(By.xpath("//h2"));

        for (int i = 0; i < ürünler.size(); i++) {

            ürünler.get(i).click();
            bekle(2);
            System.out.println(driver.getTitle());
            driver.navigate().back();//-->org.openqa.selenium.StaleElementReferenceException
            bekle(2);
            if(i==4){
                break;
            }
            ürünler=driver.findElements(By.xpath("//h2"));// staleelementrefernceexception hatasini handle ettik.tekrar locate aldik yani

        }

    }
}
