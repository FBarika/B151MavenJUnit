package techproed.day19_ExtentReport_WebTables;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReport extends TestBase {

    /*
    EXTENTREPORT;
       1-ExtendReport(aventstack) kullanabilmek icin öncelikle mvn adresinden 4.0.9 versiyon numarali
       dependency'i pom.xml dosyamiza ekleriz.
       2-ExtentReports class'insan  class seviyesinde obje olustururuz
       3-ExtentHtmlReporter class'insan  class seviyesinde obje olustururuz
       4-ExtentTest class'insan  class seviyesinde obje olustururuz
    */
    // ExtentReport diyince aklimiza 3 class gelmeli!!! ==> ExtentReports, ExtentHtmlReporter, ExtentTest
    ExtentReports extentReports;//--> Raporlamayi baslatmak icin kullanilan class
    ExtentHtmlReporter extentHtmlReporter;//--> Raporu HTML formatinda düzenler.
    ExtentTest extentTest;//--> Test adimlarinda eklemek istedigimiz bilgileri bu class ile olustururuz.
    @Test
    public void test01() {
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "testOutput/extentReports/extentReport"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);//--> HTML formatinda raporlamayi baslatacak.

        //Raporda gözükmesini istedigimiz icin bilgiler icin
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Barika");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");

        extentTest=extentReports.createTest("ExtentTest","Test Raporu");

        /*
          Testlerimiz bittiginde bizden bir rapor istenebilir. Karsimizdaki teknik terimleri bilmeyebilir ama Extent Class' larini kullanrak
          testle ilgili bilgileri rapora ekleyebiliriz
        */

        //amazon sayfasina gidelim
        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasina gidildi");

        //Basligin Amazon icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        extentTest.info("Basligin Amazon icerdigi test edildi.");

        //arama kutusunda iphone aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratildi.");


        //sonuc yazisini konsola yazdiralim
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("sonuc yazisi :" + sonucYazisi.getText());
        extentTest.info("Sonuc yazisi konsola yazdirildi.");
        extentTest.pass("Sayfa kapatildi.");
        /*
        extentTest objesi ile info() methodu kullanarak her stepte ne yaptigimizla alakali bilgi yazabiliriz.
        Testimizin en sonunda testin bittigini ifade eden pass() methodu ile testimizle alakali son bilgiyi
        ekleyebiliriz.
         Ve son olarak actions daki gibi perform() methodu gibi extentReport objesi ile flush() methodu kullanarak
         raporu sonlandiririz.
         */
        extentReports.flush();//--> bu methodu kullanmazsak raporumuz olusmaz.


    }













}
