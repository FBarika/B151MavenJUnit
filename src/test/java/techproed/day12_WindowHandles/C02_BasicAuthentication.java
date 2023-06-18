package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import techproed.utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {
    @Test
    public void test01() {


        //Aşağıdaki bilgileri kullanarak authentication yapınız:
        //    Url: https://the-internet.herokuapp.com/basic_auth
        //    Username: admin
        //    Password: admin

        //    Başarılı girişi doğrulayın.
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        bekle(3);

        //Basarili bir giristen sonra sonuc yazisinin "Congratulations!" yazısını icerdigini doğrulayın.
        String actualYazi = driver.findElement(By.xpath("//p")).getText();
        String expectedYazi ="Congratulations!";
        Assert.assertTrue(actualYazi.contains(expectedYazi));

        //Elemental Selenium yazisina tiklayalim
        driver.findElement(By.xpath("(//a)[2]")).click();

        //Basligin Elemental Selenium olmadigini dogrulayin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());//--> Acilan yeni pencereye gectik
        String actualTitle = driver.getTitle();
        String expectedTitle ="Elemental Selenium";
        Assert.assertNotEquals(actualTitle,expectedTitle);

        //DDM'den Java secelim.
        WebElement ddm = driver.findElement(By.xpath("//select"));
        Select select = new Select(ddm);
        select.selectByIndex(2);
        // selectVisibleText(ddm,"Java"); --> burada method ile yaptik.







    }




}
