package pages;
import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    // Locators
    private String usernameField = "#user-name";
    private String passwordField = "#password";
    private String loginButton = "#login-button";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void enterUsername(String username) {
        page.fill(usernameField, username);
    }

    public void enterPassword(String password) {
        page.fill(passwordField, password);
    }

    public void clickLoginButton() {
        page.click(loginButton);
    }
}