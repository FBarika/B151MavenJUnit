package techproed.day08_BeforeClassAfterClass_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void setUp() throws Exception { //test1 methodundan önce 1 kez calisti.

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://techproeducation.com");
    }

    @Test
    public void test1() throws InterruptedException { //Test1 calisti ve browser acik kaldi.
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("qa", Keys.ENTER);

    }

    @Test
    public void test2() throws InterruptedException { //yeni bir browserda tes2 methodu calisti.Bu method'dan önce before methodu oldugu icin önce before calisti.
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("developer", Keys.ENTER);
    }

    @AfterClass
    public static void tearDown() throws Exception { //En son bir kez AfterClass methodu calistigi icin son acilan browser kapandi.
        driver.close();
    }
}
