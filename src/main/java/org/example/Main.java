package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class Main {

    public static WebDriver browser;

    public static final String URL = "http://localhost:8080/prisijungti";

    public static final int SECONDS_TO_WAIT = 5;

    public static By textError = By.id("password.errors");

    //registration

    public static By registrationButton = By.xpath("/html/body/div/form/div/h4/a");
    public static By usernameField = By.id("username");
    public static By passwordField = By.id("password");
    public static By passwordConfirmField = By.id("passwordConfirm");
    public static By createNewUserButton = By.xpath("//*[@id=\"userForm\"]/button");

    //login
    public static By logInUserField = By.name("username");
    public static By logInPassField = By.name("password");
    public static By logInButton = By.xpath("//*[text()='Prisijungti']");

    //calculator
    public static By calculatorPageButton = By.cssSelector("[href='http://localhost:8080/'");
    public static By firstNumberField = By.id("sk1");
    public static By secondNumberField = By.id("sk2");
    public static By operationDropDownButton = By.name("zenklas");
    public static By calculateNumbersButton = By.cssSelector("input[value='skaičiuoti']");

    public static void setUp(String url){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver128.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-search-engine-choice-screen");

        browser = new ChromeDriver(chromeOptions);
        browser.get(url);
    }

    public static void closeBrowser(){
        browser.quit();
    }

    public static void waitUntilElementIsVisible(By by){
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(SECONDS_TO_WAIT));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public static void clickOnElement(By by){
        browser.findElement(by).click();
    }

    public static void waitAndClick(By by){
        waitUntilElementIsVisible(by);
        clickOnElement(by);
    }

    public static void sendKeysToFieldBox(By by, String key){
        waitUntilElementIsVisible(by);
        browser.findElement(by);
        browser.findElement(by).sendKeys(key);
    }

    public static void registrationInput(String userName, String userPassword){
        sendKeysToFieldBox(Main.usernameField, userName);
        sendKeysToFieldBox(Main.passwordField, userPassword);
        sendKeysToFieldBox(Main.passwordConfirmField, userPassword);
    }

    public static void fillLogInFields(String userName, String userPassword){
        sendKeysToFieldBox(Main.logInUserField, userName);
        sendKeysToFieldBox(Main.logInPassField, userPassword);

    }

    public static void selectDropDownByValue(By by, String value){
        waitUntilElementIsVisible(by);
        Select select = new Select(browser.findElement(by));
        select.selectByValue(value);
    }

    public static void calculatorValues(String numberOneString, String numberTwoString, String operationString){
        Main.sendKeysToFieldBox(Main.firstNumberField, numberOneString);
        Main.sendKeysToFieldBox(Main.secondNumberField, numberTwoString);
        Main.selectDropDownByValue(Main.operationDropDownButton, operationString);
    }

    public static String getText(By by){
        waitUntilElementIsVisible(by);
        return browser.findElement(by).getText();
    }

    public static String usernameGenerator(){
        Random random = new Random();
        return "user_" + random.nextInt(10000);
    }

    public static void main(String[] args) {

    }
}