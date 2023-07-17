package techproed.day21_Excel_JSExecutor;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import techproed.utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class C01_ReadExcel extends TestBase {


    @Test
    public void test01() throws IOException {

        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(1));

        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String satirUcSütunBir = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println("3. Satir 1. Sütun Bilgisi = "+satirUcSütunBir);
        Assert.assertEquals("France",satirUcSütunBir);

        //Kullanılan satır sayısın bulun
        System.out.println("Kullanilan Satir Sayisi : "+workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        //Not: getPhysicalNumberOfRows() methodu kullanilan yani ici dolu olan satirlarin sayisini verir. Index 1'den baslar.

        //Sayfadaki satir sayisini yazdiriniz.
        System.out.println("Sayfadaki Satir Sayisi : "+workbook.getSheet("Sheet1").getLastRowNum());
        //Not: getLastRowNum() methodu sayfadaki son satirin sira numarasini verir ve index 0(sifir) dan baslar.

        //Ülke-Başkent şeklinde verileri yazdırın
        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j < workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells(); j++) {
                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j) + "\t");
            }
            System.out.println();
        }

    }

    @Test
    public void test02() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Map<String,String> ulkeBaskent = new LinkedHashMap<>();
        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            String ulke = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String sehir = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            ulkeBaskent.put(ulke,sehir+"\n");

        }
        System.out.println(ulkeBaskent);
    }

    @Test
    public void test03() throws IOException {

        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Map<String,String> ulkeBaskent = new LinkedHashMap<>();
        for (int i = 0; i <= workbook.getSheet("Sheet1").getLastRowNum()+1; i++) {
            if (workbook.getSheet("Sheet1").getRow(i) != null) {//--> Daha asagiya satir ekleyip aralarda bosluk oldugunda if yapmazsak bos satirlardan dolayi nullpointerexception atacak.
                String ulke = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
                String sehir = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
                ulkeBaskent.put(ulke, sehir + "\n");
            }
        }
        System.out.println(ulkeBaskent);
        /*
        Döngüde bos olan hücreye geldigi icin null pointerexception hatasi aliyoruz.
        if blogu icinde bos olmayan satirlari al diyerek (workbook.getSheet("Sheet1").getRow(i) != null) bu sorunu cözmüs oluyoruz.
         */

        //Ödev yukaridaki ilk 2 teste if ekle !!!!!!!!!!!!
    }
}
