import org.example.Main;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class newUserRegistration {
    @BeforeMethod
    public static void setUp(){
        Main.setUp(Main.URL);
    }

    @AfterMethod
    public static void closeBrowser (){
        Main.closeBrowser();
    }

    @Test(priority = 0)
    public static void positiveUserRegistration (){
        Main.waitAndClick(Main.registrationButton);
        Main.registrationInput(Main.usernameGenerator(), "gog_456");
        Main.waitAndClick(Main.createNewUserButton);
    }

    @Test(priority = 1)
    public static void negativeUserRegistration(){
        Main.waitAndClick(Main.registrationButton);
        Main.registrationInput(Main.usernameGenerator(), "g");
        Main.waitAndClick(Main.createNewUserButton);
    }
}
