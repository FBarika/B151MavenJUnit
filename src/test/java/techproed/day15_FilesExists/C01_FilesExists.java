package techproed.day15_FilesExists;


import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FilesExists {

    @Test
    public void test01() {
        /*
        Bir web sitesini test ettigimizde download islemi yapildigi zaman dosyanin bilgisayarimiza inip inmedigini kontrol etmek
        varligini dogrulayabilmek icin ya da bilgisayarimizdaki herhangi bir dosyanin varligini dogrulayabilmek icin;
             Files classindan exists() methodonu kullanarak parametre olarak Paths.get(dosyaYolu) methodunu kullanarak
             dosyanin varligini test edebiliriz.  --> Files.exists(Paths.get(dosyaYolu)
             Dolyasiyla bu isleme baslamadan önce varligini test edecegimiz dosyanin yolunu String bir degiskene assingn ederiz.
         */

        String dosyaYolu = "C:/Users/Barika/Desktop/resim 1.jpg";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//--> dosya varsa True yoksa False döner.
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }

    @Test
    public void test02() {
        String dosyaYolu ="C:/Users/Barika/Desktop/0.jpg";//--> "C" den önce ve en sondaki cift tirnaktan önce /" olmayacak
        //"C:\Users\Barika\Desktop\0.jpg" önce yorum icine yolu alip sonra String e assign etmek daha kolay
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }

    @Test
    public void test03() {
        /*
        Bir server'da farkli isletim sistemleri ile ayni anda dosya varligini test etmek istedigimiz zaman, daha dinamik
   olmasi acisindan System.getProoerty("os.name") bu sekilde isletim sistemini alir
   her isletim sisteminin kullanici yolu farkli olacagindan System.getProoerty("user.home") bilgisayarimizdaki
   kullanici yolunu bu sekilde alip String bir degiskene farkliYol ismi ile System.getProoerty("user.home") atayarak
   her seferinde farkli yollari almayla ugrasmamiz oluruz. Dosya diyelim ki masa ustunde ve her isletim sisteminde
   bize ayni yolu verecegi icin bunu da ortak yol olarak bir String'e assing ederiz.

         */
        /*
        Windows 10 sürümlerinden önceki sürümler icin pratik olarak dosya yolu almak istersek, yolunu almak istedigimiz
         dosyanin üzerine gelip shift+sag click tusuna basarak "yol olarak kopyala" secenegi ile dosya yolunu kopyalayabiliriz.
         */
        //--> Dosya Yolumuz : //"C:\Users\Barika\Desktop\0.jpg"
        String farkliYol = "";
        String isletimSistemiAdi = System.getProperty("os.name");//--> isletim sistemimizin adini verir.
        System.out.println(isletimSistemiAdi);
        System.out.println(System.getProperty("user.home"));//--> Bilgisayarimizdaki kullanici yolunu verir.

        if(isletimSistemiAdi.contains("Win")){
            farkliYol=System.getProperty("user.home");//--> Windows 10
        }else if(isletimSistemiAdi.contains("mac")){
            farkliYol="/Users/aycapolatkamali"; //--> Mac isletim sistemi yolu
        }
        String ortakYol ="/Desktop/0.jpg";
        String dosyaYolu = farkliYol+ortakYol;
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        try {
            Files.delete(Paths.get(dosyaYolu));//-->Bu sekilde belirtmis oldugumuz dosyayi  sileriz.
        } catch (IOException e) {
            System.out.println("Dosya bulunamadi");
        }
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));//--> Sildigimiz icin AssertFalse kullandik.

        //Sildigimiz dosya isminde yeni bir dosya olusturalim. Burada hata alicam cünkü forografi sildim tekrar getiremedim geri.!!!!
        try {
            Files.createFile(Paths.get(dosyaYolu));//--> Belirtmis oldugumuz dosyayi olusturduk.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
        Her seferinde test ettigimiz sayfada download islemi yapiliyorsa gereksiz dosya kalabaligini önlemek icin yukaridaki delete islemini
        kullanabliriz.
         */


    }

    @Test
    public void test04() {
        /*
        Yukaridaki methodlarla bilgisayarimizdaki dosya yolunun varligini Files.exists() methoduyla test etmistik.
        Ayni islemi asagidaki örnekteki gibi File classindan obje olusturarak da yapabiliriz.
         */
        String dosyaYolu ="C:\\Users\\Barika\\Desktop\\barika.txt";
        File file = new File (dosyaYolu);
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
        file.delete();


    }
}
