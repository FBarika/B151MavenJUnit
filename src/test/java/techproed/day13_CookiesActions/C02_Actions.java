package techproed.day13_CookiesActions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void tets01() {
        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sag tıklayın
        WebElement kutu = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(kutu).// sag click yapma methodu kullandik.Argüman olarak webelemntin locate 'ini yazdik.
                perform();// actions objemizle yapacagimiz islemi uygulamasi icin veya sonlandirmasi icin perform() kullaniriz.

        //Alert'te cikan yazinin"You selected a context menu"oldugunu test edin
        Assert.assertEquals("You selected a context menu",getTextAlert());
        //TestBase deki getTextAlert() methodu kullandik --> driver.switchTo().alert().getText();

        //Tamam diyerek alert'i kapatın
        acceptAlert();// --> TestBase deki methodu kullandik --> driver.switchTo().alert().accept()
    }
}
