package ssg.day01_getKomutlari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.List;

public class GetKomutlari extends TestBase {
    @Test
    public void getKomutlariTesti() {

        //https://www.kitapyurdu.com/ adresine gidiniz.
        driver.get("https://www.kitapyurdu.com/");

        //Anasayfanın açıldığını sayfa URL’si ile doğrulayınız.
        String expectedUrl = "https://www.kitapyurdu.com/";
        String actualUrl =driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        //Anasayfanın açıldığını sayfa başlığı ile doğrulayınız.
        //Sayfa basligi icin inspect ten head in icinden title dan buluyoruz.

        String expectedTitle ="Kitapyurdu, Kitapla buluşmanın en kolay yolu";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        //Anasayfada "Haftanın Yayınevi", "En Çok Satılanlar" ve "Ayın Yayınevleri" başlıklarının bulunduğunu doğrulayınız.
        String pageSource = driver.getPageSource();//incele dedigimizde karsimiza cikan bütün kodlar.
        Assert.assertTrue(pageSource.contains("Haftanın Yayınevi"));
        Assert.assertTrue(pageSource.contains("En Çok Satılanlar"));
        Assert.assertTrue(pageSource.contains("Ayın Yayınevleri"));

        //Üye girişi butonunun üzerindeki metnin "Giriş Yap" olduğunu doğrulayınız.
        WebElement girisButonuMetni = driver.findElement(By.xpath("//*[@class='menu-top-button login']"));
        String expectedMetin ="Giriş Yap";
        String actualMetin =girisButonuMetni.getText();
        Assert.assertEquals(expectedMetin,actualMetin);

        //“Üye Ol” butonunun linkinin "https://www.kitapyurdu.com/index.php?route=account/register" olduğunu doğrulayınız.
        WebElement uyeOlButonu = driver.findElement(By.linkText("Üye Ol"));
        String uyeOlHref = uyeOlButonu.getAttribute("href");
        System.out.println(uyeOlHref);
        Assert.assertEquals("https://www.kitapyurdu.com/index.php?route=account/register",uyeOlHref);

        //En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin span tagı içerisinde olduğunu doğrulayınız.
        List<WebElement> yazarIsmiListesi = driver.findElements(By.xpath("//span[@class='author line-clamp-2']"));
        for (WebElement w:yazarIsmiListesi) {
            Assert.assertEquals("span",w.getTagName());
        }

        //En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin font ailesinin "Arial, Helvetica, sans-serif" olduğunu doğrulayınız.
        for (WebElement yazarIsmi : yazarIsmiListesi){
            Assert.assertEquals("Arial, Helvetica, sans-serif", yazarIsmi.getCssValue("font-family"));
        }

        //Haftanın Yayınevi bölümündeki ilk kitabın resim genişliğinin 120, yüksekliğinin 174 olduğunu doğrulayınız.
        WebElement ilkKitapGenislikYukseklik= driver.findElement(By.xpath("//*[@alt='Kurtuluş Günü']"));
        int height= ilkKitapGenislikYukseklik.getSize().getHeight();
        int width= ilkKitapGenislikYukseklik.getSize().getWidth();
        Assert.assertEquals(height,174);
        Assert.assertEquals(width,120);

        //quit() ve close() metotları arasındaki farkı inceleyelim.
    }



}
