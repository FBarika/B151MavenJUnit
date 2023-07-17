package techproed.day21_Excel_JSExecutor;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import techproed.utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_ExcelWrite extends TestBase {

    /*
Bir "NÜFUS" sütunu oluşturup başkent nüfuslarını excel doyasına yazınız:
(D.C: 712816, Paris: 2161000, London: 8982000, Ankara: 5663000 ...)
  */

    @Test
    public void test01() throws IOException {
        //-->Bir hücreye veri ekleyebilmek icin belirtmis oldugumuz satirdan sonra hangi hücreye(cell) ekleme yapacaksak
        //createCell(cell numarasi) methodu ile cell icine eklenecek veri icin setCellValue() methodu kullanarak istedigimiz veriyi ekleyebiliriz.

        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        workbook.getSheet("Sheet1").getRow(0).createCell(2).setCellValue("NÜFUS");
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue(712816);
        workbook.getSheet("Sheet1").getRow(2).createCell(2).setCellValue(2161000);
        workbook.getSheet("Sheet1").getRow(3).createCell(2).setCellValue(8982000);
        workbook.getSheet("Sheet1").getRow(4).createCell(2).setCellValue(5663000);

        /*
        Excel'e veri ekleme isleminden sonra FileOutputStream ile ekledigimiz verileri workbook objesi ile write() methodu kullanarak kaydederiz.
        Bu sekilde Excel'e veriler kaydedilmis olur. SOnra yapacagimiz farkli islemlerde hata almamamiz icin fos(FileOutputStream).close()
        ve workbook.close() methodlariyla yaptigimiz islemleri sonlandirmis oluruz.
         */
        FileOutputStream fos = new FileOutputStream("src/test/java/techproed/resources/Capitals.xlsx");
        workbook.write(fos);
        fos.close();
        workbook.close();

        /*
        Excel'e veri ekleme isleminden sonra FileOutputStream ile ekledigimiz verileri kaydederiz
         */







    }




}
