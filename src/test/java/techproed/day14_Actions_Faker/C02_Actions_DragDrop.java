package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C02_Actions_DragDrop extends TestBase {
    @Test
    public void test01() {

        //Given user is on https://jqueryui.com/droppable/ --> adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelemnti üzerine birakalim
        /*
        drag ve drop elementleri iframe icinde oldugu icin iframe gecis yapmaliyiz.
        */
        driver.switchTo().frame(0); //iframe xpath e baktigimizda bir tane oldugu icin 0 index le alabildik direkt.


        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
        /*
        Eger bir hareketli webelementi tutup baska bir webelementin üzerine birakmak istersek
        sürüklemek istedigimiz we'tin locateni alip üzerine birakacagimiz we'tin locateni de alarak
        dragAndDrop(kaynak,hedef) methodu ile islemi gerceklestirebiliriz.
         */

    }

    @Test
    public void test02() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
    /*
    drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
     */
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).//--> Bu method ile web elemente mouse ile basili tuttuk
                moveToElement(drop).// --> Bu method ile basili tuttugumuz we'ti diger we'tin üzerine götürdük.
                release().//--> Bu method ile basili tuttugumuz we'ti serbest biraktik
                perform();//--> islemi sonlandirdik.

    }

    @Test
    public void test03() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
    /*
    drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
     */
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).
                moveByOffset(84,28).//deneme yanilma ile koordinatlar bulundu.
                release().
                perform();//belirtmis oldugumuz kordinatlara we'ti tasir.


    }
}
