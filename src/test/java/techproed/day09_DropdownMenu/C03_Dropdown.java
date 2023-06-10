package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_Dropdown {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01()  {
        //programming languages ddm den istediginiz 4 secenegi seciniz
        WebElement diller = driver.findElement(By.xpath("(//select)[6]"));
        Select select = new Select(diller);
        select.selectByIndex(0);
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.selectByIndex(4);
        //Eger sadece secili olan option'lari yani secenekleri yazdirmak istersek;
        select.getAllSelectedOptions().forEach(w-> System.out.println(w.getText())); //lambda ile yaptik.

        System.out.println("***********************************");
        //normal foreach ile cözüm
        for (WebElement e:select.getAllSelectedOptions()) {
            System.out.println(e.getText());
        }

        //Seceneklerden 4 tane sectigimizi dogrulayalim
        Assert.assertEquals(4,select.getAllSelectedOptions().size());

        System.out.println("****************************************");

        //Sectigimiz seceneklerden ilkini yazdiralim, ilk secenegin Java oldugunu dogrulayalim
        System.out.println("Secilen Seceneklerden Ilki = " + select.getFirstSelectedOption().getText());
        Assert.assertEquals("Java",select.getFirstSelectedOption().getText());

        bekle(3);
        //Sectigimiz seceneklerin hepsini kaldirmaik icin;
        select.deselectAll();

        //sendKeys() methodu ile istedigimiz bir secenegi gönderelim
        //diller.sendKeys("C#");

        //visibleText olarak secim yapacagimiz bir method olusturup programming languages ddm den bir secenek secelim.
        selectVisibleText(diller,"Java");
        bekle(2);

        //Index olarak secim yapacagimiz bir method olusturup programming languages ddm den bir secenek secelim.

        selectIndex(diller,2);
        bekle(2);

        //Value olarak secim yapacagimiz bir method olusturup programming languages ddm den bir secenek secelim.

        selectValue(diller,"js");
        bekle(2);


    }
    public void selectVisibleText(WebElement ddm, String text){

        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    public void selectIndex(WebElement ddm, int index){

        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    public void selectValue(WebElement ddm, String value){

        Select select = new Select(ddm);
        select.selectByValue(value);
    }

    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() throws Exception {
        bekle(3);
       driver.close();
    }
}
