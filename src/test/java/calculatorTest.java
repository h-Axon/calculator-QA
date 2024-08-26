import org.example.Main;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class calculatorTest {

    static String sk1String;
    static String sk2String;
    static String operationString = "*";

    @BeforeMethod
    public static void setUp(){
        Main.setUp(Main.URL);
    }

    @AfterMethod
    public static void closeBrowser (){
        Main.closeBrowser();
    }

    @Test(priority = 0)
    public static void positiveCalculatorTest(){
        Main.fillLogInFields("Romas", "Ponas");
        Main.waitAndClick(Main.logInButton);
        sk1String = "2";
        sk2String = "8";
        Main.waitAndClick(Main.calculatorPageButton);
        Main.calculatorValues(sk1String, sk2String, operationString);
        Main.selectDropDownByValue(Main.operationDropDownButton, operationString);
        Main.waitAndClick(Main.calculateNumbersButton);
    }

    @Test(priority = 1)
    public static void negativeCalculatorTest(){
        Main.fillLogInFields("Romas", "Ponas");
        Main.waitAndClick(Main.logInButton);
        sk1String = "2";
        sk2String = "-8";
        Main.waitAndClick(Main.calculatorPageButton);
        Main.calculatorValues(sk1String, sk2String, operationString);
        Main.selectDropDownByValue(Main.operationDropDownButton, operationString);
        Main.waitAndClick(Main.calculateNumbersButton);
    }
}
