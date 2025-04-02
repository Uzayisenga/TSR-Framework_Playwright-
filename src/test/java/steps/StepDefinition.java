package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

public class StepDefinition {
    private WebDriver driver;



    @BeforeSuite

    public void setUp() {

        String value = new String();
        String key = new String();
        System.setProperty(key,value);
        driver = new FirefoxDriver();
    }
    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    // === Login Steps ===



//    @Then("I should see the dashboard")
//    public void verifyDashboard() {
//        assertTrue(driver.getCurrentUrl().contains("/dashboard"));
//    }
//
//    @Then("I should see an error message {string}")
//    public void verifyErrorMessage(String message) {
//        WebElement error = driver.findElement(By.cssSelector(".error-message"));
//        assertEquals(message, error.getText());
//    }
//
//    // === Search Steps ===
//    @Given("I am on the homepage")
//    public void navigateToHomepage() {
//        driver.get("https://example.com");
//    }
//
//    @When("I search for {string}")
//    public void searchForProduct(String term) {
//        driver.findElement(By.id("search-box")).sendKeys(term);
//        driver.findElement(By.id("search-btn")).click();
//    }
//
//    @Then("I should see at least {int} results")
//    public void verifySearchResults(int count) {
//        int results = driver.findElements(By.cssSelector(".product-item")).size();
//        assertTrue(results >= count);
//    }
//
//    // === Checkout Steps ===
//    @When("I add the product to the cart")
//    public void addToCart() {
//        driver.findElement(By.id("add-to-cart-btn")).click();
//    }
//
//    @Then("The cart count should increase by {int}")
//    public void verifyCartCount(int count) {
//        WebElement cart = driver.findElement(By.id("cart-count"));
//        assertEquals(count, Integer.parseInt(cart.getText()));
//    }
//
//    @After
//    public void teardown() {
//        driver.quit();
//    }
}