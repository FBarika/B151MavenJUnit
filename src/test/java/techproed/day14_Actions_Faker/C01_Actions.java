package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C01_Actions extends TestBase {

    @Test
    public void test01() {
        //techpro sayfasına gidelim
         driver.get("https://techproeducation.com");
         driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//--> sayfada cikan reklami kapattik.

       //sayfanın altına doğru gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        // bir kez sendKeys yazip da kullanabilirz yada birden fazla sendKeys de yazip kullanabiliriz.
        bekle(2);

       //sayfanın üstüne doğru gidelim
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).perform();
    }

    @Test
    public void test02() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//--> sayfada cikan reklami kapattik.

        //sayfanın en altına scroll yapalim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END);// asagida build kullanmazsak burada .perform() kullanacagiz.
        // her action dan sonra isi hizli yapmasi icin build kullaniriz(bekle kullansak bile cok hizli yapar.)
        // ama normalde hepsinden sonra perform kullaniriz.-->build() kullanmazsak yani
        bekle(2);

        //sayfanın en üstüne scroll yapalim
        actions.sendKeys(Keys.HOME).build().perform();
        //build() --> methodu action'lari birlestirmek icin kullanilan methoddur.Birden fazla olusturdugumuz action objesini birbirine baglar.
        //release() --> methodu mouse serbest birakir.
        //Eger yapilan islemin cok hizli olmasini istemiyorsak build() kullanmak yerine her action'dan sonra perform() kullanmamiz gerekir.

    }

    @Test
    public void test03() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//--> sayfada cikan reklami kapattik.
        bekle(2);
        //sayfanın  altına dogru gidelim
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,1500).perform();// + asagiya indiriyor - yukariya cikariyor.
        bekle(2);

        //sayfanın  üstüne dogru gidelim
        actions.scrollByAmount(0,-1500).perform();
        bekle(2);


    }
}
