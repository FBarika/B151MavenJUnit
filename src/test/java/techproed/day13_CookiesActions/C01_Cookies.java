package techproed.day13_CookiesActions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import techproed.utilities.TestBase;

import java.util.Arrays;
import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void test01() {

        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-tum cookie’leri listeleyin

        /*
        Cookie 'leri listelemek istersek
        driver.manage().getCookies() --> methoduyla bir Set ya da arrayList'e atarak listeleyebiliriz.
        */

        //Arrays.stream(driver.manage().getCookies().toArray()).forEach(System.out::println);--> lambda ile cookieleri yazdirdik.
        Set<Cookie> cookieSet = driver.manage().getCookies();
        int sayac = 1;
        for (Cookie w:cookieSet) {
            System.out.println(sayac+". cookie : "+w);
            System.out.println(sayac+". cookieName : "+w.getName());//--> Sadece cookilerin isimlerini aliriz.
            System.out.println(sayac+". cookieValue : "+w.getValue());//--> Sadece cookilerin value'larini aliriz.

            sayac++;
        }


        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        System.out.println("Cookielerin Sayisi = " + cookieSet.size());
        Assert.assertTrue(cookieSet.size()>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        //getCookieNamed() methodu ile bize verilen cookie isminin getValue() methoduyla gercek degerini actualCookieValue degiskenine assingn ettik.
        String expectedCookieValue = "USD";
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        cookieSet=driver.manage().getCookies();
        for (Cookie each:cookieSet) {
            System.out.println(each);
        }
        Assert.assertTrue(driver.manage().getCookieNamed("en sevdigim cookie").getValue().equals("cikolatali"));
        System.out.println(cookieSet.size());
        System.out.println("Cookielerin Sayisi =" + Arrays.stream(driver.manage().getCookies().toArray()).count());//lambda ile yazdirma


        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        int silinmedenÖnce=cookieSet.size();
        System.out.println("silinmedenÖnce = " + silinmedenÖnce);
        bekle(2);
        driver.manage().deleteCookieNamed("skin");//--> ismi skin olan cookie'yi sildik.
        bekle(2);
        cookieSet=driver.manage().getCookies();//-->//Silindikten sonra cookieSet'e yine atama yapiyoruz aksi taktirde fail aliriz

        int silindiktenSonra =cookieSet.size();
        System.out.println("silindiktenSonra = " + silindiktenSonra);
        Assert.assertEquals(1,(silinmedenÖnce-silindiktenSonra));



        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();//--> Tüm cookileri sildik
        cookieSet= driver.manage().getCookies();//Tekrar cookieSet'i güncelledik.
        Assert.assertTrue(cookieSet.isEmpty());//Ve cookieSet'in icinin bos oldugunu isEmpty() methoduyla test ettik.

    }


}
