package steps;

import com.microsoft.playwright.*;
import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginSteps {
    private Playwright playwright;
    private Browser browser;
    private Page page;
    private LoginPage loginPage;

    @Given("I navigate to the login page")
    public void navigateToLogin() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        loginPage = new LoginPage(page);
        page.navigate("https://testsolutions.de/");
    }

    @When("I enter username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void clickLogin() {
        loginPage.clickLoginButton();
    }

    @Then("I should see the dashboard")
    public void verifyDashboard() {
        assert page.url().contains("/dashboard");
        browser.close();
        playwright.close();
    }

}
