import org.example.Main;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class authorizationTest {
    @BeforeMethod
    public static void setUp(){
        Main.setUp(Main.URL);
    }

    @AfterMethod
    public static void closeBrowser (){
        Main.closeBrowser();
    }

    @Test(priority = 0)
    public static void positiveAuthorizationTest(){
        Main.fillLogInFields("Romas", "Ponas");
        Main.waitAndClick(Main.logInButton);
        String recordsTablePageUrl = "http://localhost:8080/skaiciai";
        Main.browser.get(recordsTablePageUrl);
    }

    @Test(priority = 1)
    public static void negativeAuthorizationTest(){
        String recordsTablePageUrl = "http://localhost:8080/skaiciai";
        Main.browser.get(recordsTablePageUrl);
    }
}