package techproed.day08_BeforeClassAfterClass_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButtonClassWork {
    /*
    -https://www.facebook.com adresine gidin
    -Cookies’i kabul edin
    -“Create an Account” button’una basin
    -“radio buttons” elementlerini locate edin
    -Secili degilse cinsiyet butonundan size uygun olani secin
     */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }



    @Test
    public void radioButton() {
        //    -https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        //    -Cookies’i kabul edin
        driver.findElement(By.xpath("(//*[@type='submit'])[3]")).click();

        //    -“Create an Account” button’una basin
        driver.findElement(By.xpath("(//div)[22]")).click(); //(//div//a)[3] bu sekilde de alinabilir.

        //    -“radio buttons” elementlerini locate edin
        WebElement female = driver.findElement(By.xpath("(//*[@type='radio'])[1]"));
        WebElement male = driver.findElement(By.xpath("(//*[@type='radio'])[2]"));
        WebElement ozel = driver.findElement(By.xpath("(//*[@type='radio'])[3]"));

        //    -Secili degilse cinsiyet butonundan size uygun olani secin
        if(!female.isSelected()){
            female.click();
        }

    }
    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
