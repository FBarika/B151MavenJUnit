package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTest extends TestBase {
    @Test
    public void test01() {



        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        bekle(2); //--> indirme süresini göz önüne bulundurarak bekle koyduk.
        //b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("(//a)[3]")).click();

        /*
        indirmemizi istedigi dosyayi locate edip tikladik ve dosyamiz download klasörüne indi.
        */

        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\Barika\\Downloads\\b10 all test cases, code.docx";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        String filePath = "C:\\Users\\Barika\\Downloads\\b10 all test cases, code.docx";
        try {
            Files.delete(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println("Dosya bulunamadi.");
        }
        //Dosyayi daha önce indirdigimiz icin ve tekrar testi calistirdigimizda yine ayni dosyayi indirecegi icin burda dosyayi sildik.
    }
}
