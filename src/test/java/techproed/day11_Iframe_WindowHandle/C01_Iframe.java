package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_Iframe extends TestBase {
    /*
    Bir HTML dökümaninin icine yerlestirilmis baska bir HTML dökümanina inline frame yani IFRAME denir.
    Bir sayfada iframe varsa iframe icindeki Webelementi handle edebilmek icin switchTo() methoduyla iframe gecis yapmamiz gerekir.
    Eger gecis yapmazsak nosuchelementexception aliriz.

    Alert'ten farki; alert ciktiginda hicbir webelementi locate edemeyiz.Iframe olsa da locate ederiz fakat handle edemeyiz.
     */




    @Test
    public void test01() {

        //➢ https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //➢    Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin   oldugunu test edelim
        String metin = driver.findElement(By.xpath("(//p)[1]")).getText();
        System.out.println(metin);
        Assert.assertTrue(metin.contains("black border"));

        //➢    Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);//--> gecis yapmazsak nosuchelementexception hatasi aliriz.
        String ApplicationslistsYazisi = driver.findElement(By.xpath("//h1")).getText();
        System.out.println(ApplicationslistsYazisi);
        Assert.assertEquals("Applications lists",ApplicationslistsYazisi);

        //➢    Son olarak sayfa basliginda iframe yazisinin görünür oldugunu test ediniz.
        driver.switchTo().defaultContent();
        //driver.get(driver.getCurrentUrl());// bu da iframe cikis yapan bir yöntem sayfayi refrash yapar yani. driver.navigate().refresh() de ayni seyi yapar.
        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());

        /*
            Eğer iki tane iframe olsaydı ve 2. frame'e geçmek isteseydik index'i 1 almam gerekicekti
        <body>
	            <iframe id="outerIframe" src="https://www.w3schools.com"> --> driver.switchTo().frame("outerIframe")
		            <iframe id="innerIframe" src="https://www.google.com"></iframe> --> bu örnekte parentFrame ile bir üst frame geçiş yapabiliriz
	            </iframe>
            </body>

          İstersek WebElement frame = driver.findElement(By.xpath("//*[@id='outerIframe'")) bu şekilde locate ettiğimiz
        iframe'e driver.switchTo().frame(frame) geçiş yapabiliriz.
         */

        /*Nested iframe' lerde defaultContent ile refresh hangi iframe' de olursa olsun direk anasayfaya gecerken
        parentFrame sadece bir ust frame' e gecer
         */


    }












}
