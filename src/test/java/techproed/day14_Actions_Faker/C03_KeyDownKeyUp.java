package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {

    @Test
    public void test01() {
        //Google anasayfasina gidelim
        driver.get("https://google.com");
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();// cookie si kabul ettim burda
        //arama kutusunda shift tusuna basili olarak selenium yazdiralim ve shift tusunu serbest birakarak Java yazdiralim.
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT).//--> arama kutusunda shift tusuna bastik
                sendKeys("selenium").//--> selenium metnini shift tusuna basili kaldigi icin büyük yazdi.
                keyUp(Keys.SHIFT).//--> shift tusunu serbest biraktik
                sendKeys("-java",Keys.ENTER).//--> bu kismi shift i serbest biraktigimiz icin kücük yazdi.
                perform();

    }

    @Test
    public void test02() {
        //Google anasayfasina gidelim
        driver.get("https://google.com");
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();

        //arama kutusunda shift tusuna basili olarak selenium yazdiralim ve shift tusunu serbest birakarak Java yazdiralim.
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"-java",Keys.ENTER);

        /*
        Mouse islemleri icin actions classini kullanmamiz gerekir. Fakat bir metin kutusundaki klavye islemleri icin actions classina kullanmadan
        sendKeys() methodu ile de istedigimiz bir metni büyük yazdirabilir hatta birden fazla klavye tuslarina bastirabiliriz. Yukaridaki örnekte
        sendKeys() methodu ile Keys.Shift diyerek sonrasinda yazdirmak istedigimiz metni kücük harfle yazmamiza ragmen büyük harflerle yazdirdi,
        tekrar Keys.Shift kullanarak shift tusunu serbest birakmis olduk.
         */

    }

    @Test
    public void test03() {
        //google sayfasına gidelim
        driver.get("https://google.com");
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();

        // Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Selenium",Keys.ENTER);

        // Sayfayı bekleyin
        bekle(4);

        /*StaleElementReferenceException daha once locate'ini aldigimiz weblementin locate'i sayfa
        yenilendigi icin degismis ve onceden aldigimiz locate ile isleme devam edince bu exeption'i aldik.
        */

        // Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.xpath("//*[@class='gLFyf']"))//--> sayfa yenilendigi icin tekrar locate aldik.
                .sendKeys(Keys.CONTROL,"a");//--> Metni kesebilmemiz icin önce ctrl+a kesmemiz gerekir.
        bekle(2);
        driver.findElement(By.xpath("//*[@class='gLFyf']"))
                .sendKeys(Keys.CONTROL,"x");//--< secilen metni ctrl+x ile kestik.
        bekle(2);

        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("https://google.com");
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"v",Keys.ENTER);//--> Kestigimiz metni ctrl+v tusu ile tekrar arama kutusuna yapistirdik ve arattik.

    }


}
