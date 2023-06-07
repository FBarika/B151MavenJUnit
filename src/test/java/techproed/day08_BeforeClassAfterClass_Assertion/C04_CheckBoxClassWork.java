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

public class C04_CheckBoxClassWork {
    /*
    a.Verilen web sayfasına gidin.
    https://the-internet.herokuapp.com/checkboxes
    b.Checkbox1 ve checkbox2 elementlerini locate edin.
    c.Checkbox1 seçili değilse onay kutusunu tıklayın
    d.Checkbox2 seçili değilse onay kutusunu tıklayın
     */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void checkBox() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //    b.Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1 = driver.findElement(By.xpath("//*[@type='checkbox'][1]"));
        // input ile alma yolu --> WebElement checkBox1 = driver.findElement(By.xpath("(//input)[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//*[@type='checkbox'][2]"));
        Thread.sleep(3000);
        //    c.Checkbox1 seçili değilse onay kutusunu tıklayın
        if(!checkBox1.isSelected()){ //secili degilse
            checkBox1.click(); //checkbox'i click yap.
        }

        Thread.sleep(3000);
        //    d.Checkbox2 seçili değilse onay kutusunu tıklayın
        if(!checkBox2.isSelected()){ //secili degilse
            checkBox2.click(); //checkbox'i click yap.
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
