package techproed.day19_ExtentReport_WebTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.List;

public class C03_WebTables extends TestBase {
    /*
    Thead : Tablo Başlığı
    Tbody : Tablo Body'si
    Tr : Table Row(Satır)
    Td : Table Data(Sütun olarak adlandırılabilir)
     */
    /*
    WEBTABLE;
     <table> tagi ile baslar
        <thead> basliklaricin bu tag ile devam eder.
           <tr> basliklarin satiri
            <th> table head
              <td> basliktaki veriler
            <tbody> basliklar altindaki verileri temsil eder.
               <tr> table row(satir)
                 <tad> table data (tablodaki veri)
     */

    @Test
    public void test01() {
        extentReport("Chrome","WebTable");
        extentTest=extentReports.createTest("WebTable","Test Raporu");

        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        extentTest.info("Sayfaya gidildi");

        //    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Tablo 1");
        System.out.println(table1.getText());
        extentTest.info("Tablo1 yazdirildi.");

        //    Task 2 : 3. Satır verilerini yazdırın
        WebElement ucuncuSatir = driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("************************************************");
        System.out.println(ucuncuSatir.getText());
        extentTest.info("3.Satir verileri yazdirildi.");

        //    Task 3 : Son satırın verilerini yazdırın
        WebElement sonSatir = driver.findElement(By.xpath("(//table)[1]//tbody//tr[last()]")); //(//tbody)[1]//tr[last()] bu sekilde de alabiliriz.
                              //last() --> istenilene göre son satir ya da sütun bilgilerini verir.
        System.out.println("1.Tablo Son Satir Bilgileri : "+sonSatir.getText());
        extentTest.info("Son satir verileri yazdirildi.");

        System.out.println("****************************************************");

        //    Task 4 : 5. Sütun verilerini yazdırın
        WebElement besinciBaslik = driver.findElement(By.xpath("(//thead)[1]//th[5]"));
        System.out.println(besinciBaslik.getText());//--> besinci sütun basligi yazdiracak.
        List<WebElement> besinciSütun = driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
        besinciSütun.forEach(t-> System.out.println(t.getText()));
        extentTest.info("Besinci Sütun verileri yazdirildi");

        //Task 5 : 3. Satirdaki 1. ve 2. sütun bilgilerini yazdiriniz.
        System.out.println("****************************************");
        List<WebElement> ucuncuSatirBirinciveIkinci = driver.findElements(By.xpath("(//tbody)[1]//tr[3]//td[position()>=1 and position()<=2]"));
        ucuncuSatirBirinciveIkinci.forEach(t-> System.out.print(t.getText()+"\t"));
        extentTest.info("3.Satirdaki 1. ve 2. Sütun bilgileri yazdirildi.");


        //    Task 6 : Iki parametreli bir Java metodu oluşturalım: printData

        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.
        System.out.println();
        //WebElement satirSutün =driver.findElement(By.xpath("(//tbody)[1]//tr[2]//td[3]"));//fbach@yahoo.com
        System.out.println(printData(2, 3));
        extentTest.info("2.Satir 3.Sütun bilgileri yazdirildi.");

        //3.Satir 2.Sütun bilgisinin Jack olup olmadigini dogrulayin.
        printData(3,2);
        String actualData = printData(3,2);
        String expectedData = "Jack";
        Assert.assertNotEquals(expectedData,actualData);
        extentTest.fail("3.satir 2. sütun bilgisinin Jason oldugu görüldü.");//hata aldigimizda fail() methodunu kullaniyoruz.
        extentTest.pass("Sayfa Kapatildi.");
        extentReports.flush();
    }

    private String printData(int satir, int sütun) {
        WebElement satirSutün =driver.findElement(By.xpath("(//tbody)[1]//tr["+satir+"]//td["+sütun+"]"));
        return satirSutün.getText();
    }

    //ÖDEV
    //C03_WebTables class'ı için aldığımız rapora gidelim
    //NOT:driver.get("testOutput/extentReports/extentReport_09_53_35_26062023.html")
    //Başlığın Extent Report olduğunu test edelim
    //Rapor temasını dark yapalım
    //Dashboard bölümüne gidip tabloyu yazdırınız
    //Tester'ın "isminiz" olduğunu doğrulayalım
    //Sayfayı kapatalım
}
