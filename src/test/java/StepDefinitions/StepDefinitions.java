package StepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {

    static WebDriver driver;
    String URL = "https://opensource-demo.orangehrmlive.com/";

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver(); // otwarcie przeglądarki chrome
        driver.manage().window().maximize(); // maksymalizuje okno przeglądarki
    }


    @Given("^User is on the login page")
    public void user_is_on_the_login_page() {
        driver.navigate().to(URL);
    }

    @When("^User enters login (.+)$")
    public void user_enters_login(String loginek)  {
        driver.findElement(By.id("txtUsername")).sendKeys(loginek);

    }

    @Then("^User is not logged in$")
    public void user_is_not_logged_in()  {
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials", driver.getCurrentUrl());
    }

    @And("^User enters password (.+)$")
    public void user_enters_password(String passwordzik) {
        driver.findElement(By.id("txtPassword")).sendKeys(passwordzik);
    }

    @And("^User clicks on Login button$")
    public void user_clicks_on_login_button() {
        driver.findElement(By.id("btnLogin")).click();
    }

    @And("Information about invalid credentials is displayed$")
    public void information_something_is_displayed() {
        System.out.println(driver.findElement(By.id("spanMessage")).getText());
        Assert.assertEquals("Invalid credentials",driver.findElement(By.id("spanMessage")).getText());

    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }



}
