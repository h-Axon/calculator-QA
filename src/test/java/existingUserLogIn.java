import org.example.Main;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class existingUserLogIn {
    @BeforeMethod
    public static void setUp(){
        Main.setUp(Main.URL);
    }

//    @AfterMethod
//    public static void closeBrowser (){
//        Main.closeBrowser();
//    }

    @Test(priority = 0)
    public static void positiveLogIn(){
        Main.fillLogInFields("Romas", "Ponas");
        Main.waitAndClick(Main.logInButton);
    }

    @Test(priority = 1)
    public static void negativeLogIn(){
        Main.fillLogInFields("Romas", "Kronas");
        Main.waitAndClick(Main.logInButton);
        String expectedResponseErrorText = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";
        String actualResponseErrorText = Main.getText(By.xpath("/html/body/div/form/div/span[2]"));
        Assert.assertEquals(actualResponseErrorText, expectedResponseErrorText);
    }
}
