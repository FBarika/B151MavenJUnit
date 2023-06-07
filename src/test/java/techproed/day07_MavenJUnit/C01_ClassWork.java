package techproed.day07_MavenJUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01_ClassWork {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--lang=en");
        WebDriver driver = new ChromeDriver(opt);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2.Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();

        //3.Login alanine “username” yazdirin
        //4.Password alanine “password” yazdirin
        //5.Sign in buttonuna tiklayin
        WebElement login = driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username", Keys.TAB,"password",Keys.ENTER);
        Thread.sleep(3000);
        driver.navigate().back();

        //6.Online Banking altinda Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()=.])[11]")).click();
        //--> (//*[text()=.])[11] Bu sekilde text ile aldigimiz bir xpath'de text degisse bile biz o webelementi handle edebiliriz.
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        //driver.findElement(By.xpath("(//h4)[4]//span")); bu da olur tag ile alma //span koyarak span child ina inerek yaptik.


        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //8.tarih kismina “2020-09-10” yazdirin
        //9.Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='sp_amount']")).sendKeys("1000",Keys.TAB,"2020-09-10",Keys.TAB,Keys.TAB,Keys.ENTER);
        //css ile alma -->driver.findElement(By.cssSelector("#sp_amount")).sendKeys("1000");


        //10.“The payment was successfully submitted.” mesajinin ciktigini control edin
        String istenilen ="The payment was successfully submitted.";
        String sonucYazisi = driver.findElement(By.xpath("(//*[text()=.])[18]")).getText();
        //--> (//span)[1] bu sekilde tag la da alabilirz.

        if(sonucYazisi.equals(istenilen)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //2.YOL Webelementin görünür olup olmadigini dogrulamak icin yaptik.
       WebElement sonucYazisi2 = driver.findElement(By.xpath("(//*[text()=.])[18]"));

       if(sonucYazisi2.isDisplayed()){ // görünür olduguna bakarak kontrol ettik.
           System.out.println("Test PASSED");
       }else System.out.println("Test FAILED");



    }
}
