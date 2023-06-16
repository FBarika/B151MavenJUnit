package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C03_WindowHandle extends TestBase {
    @Test
    public void windowHandle() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String tecproedWindowHandle = driver.getWindowHandle();
        bekle(2);

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle =driver.getTitle();
        String expectedTitle ="Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(actualTitle,expectedTitle);


        //Window 2'de(yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().//gecis yap
                newWindow(WindowType.WINDOW);//--> Yeni bir pencerede browseri tasir.
                //WindowType.TAB --> Yeni bir sekme acar.
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();
        bekle(2);

        //Window 3'te(yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();
        bekle(2);

        //techproeducation sayfasına geçiniz:
        /*
        Eger sayfaya gittikten sonra yeni sekme ya da yeni bir pencereyle baska sayfaya gittikten sonra tekrar ilk actiginiz sayfaya
        dönmek isterseniz,ilk sayfaya driver.get() methoduyla gittikten sonra String degisken handle degerini asseign ederseniz tekrar ilk
        acilan sayfaya dönmek istediginizde driver.switchTo().window(ilksayfanin handle degeri) ile gecis yapabilirsiniz.
        */
        /*
        WindowType.WINDOW ile de WindowType.TAB ile de driver' i her halukarda tasimiz oluruz.Birinde yeni pencerede acilirken digerinde yeni sekmede acilir
        */
        driver.switchTo().window(tecproedWindowHandle);
        bekle(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);
        bekle(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);
        bekle(2);
    }

    @Test
    public void test02() { // Burada TAB ile yaptik farkli sekmelerde actik yani.

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String tecproedWindowHandle = driver.getWindowHandle();
        bekle(2);

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle =driver.getTitle();
        String expectedTitle ="Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(actualTitle,expectedTitle);


        //Window 2'de(yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().//gecis yap
                newWindow(WindowType.TAB);//--> Yeni bir pencerede browseri tasir.
        //WindowType.TAB --> Yeni bir sekme acar.
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();
        bekle(2);

        //Window 3'te(yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();
        bekle(2);

        //techproeducation sayfasına geçiniz:
        /*
        Eger sayfaya gittikten sonra yeni sekme ya da yeni bir pencereyle baska sayfaya gittikten sonra tekrar ilk actiginiz sayfaya
        dönmek isterseniz,ilk sayfaya driver.get() methoduyla gittikten sonra String degisken handle degerini asseign ederseniz tekrar ilk
        acilan sayfaya dönmek istediginizde driver.switchTo().window(ilksayfanin handle degeri) ile gecis yapabilirsiniz.
        */
        /*
        WindowType.WINDOW ile de WindowType.TAB ile de driver' i her halukarda tasimiz oluruz.Birinde yeni pencerede acilirken digerinde yeni sekmede acilir
        */
        driver.switchTo().window(tecproedWindowHandle);
        bekle(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);
        bekle(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);
        bekle(2);
    }
}
