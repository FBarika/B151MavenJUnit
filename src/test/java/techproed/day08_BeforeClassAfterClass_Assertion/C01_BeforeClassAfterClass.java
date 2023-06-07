package techproed.day08_BeforeClassAfterClass_Assertion;

import org.junit.*;

public class C01_BeforeClassAfterClass {

    /*
    @BeforeClass ve @AfterClass methodlari static olmak zorundadir
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Her classtan önce BeforeClass Method'u bir kez calisir.");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Her classtan sonra AfterClass Method'u bir kez calisir.");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her method'dan önce Before method'u bir kez calisir.");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her methodtan sonra After(tearDown) methodu bir kez calisir.");
    }

    @Test
    public void Test1() {
        System.out.println("Test1 methodu calisti.");
    }

    @Test
    public void Test2() {
        System.out.println("Test2 methodu calisti.");
    }

    @Test
    public void Test3() {
        System.out.println("Test3 methodu calisti.");
    }




}
