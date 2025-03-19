package PlayWrightPractice;

import com.microsoft.playwright.*;
import org.testng.Assert;

public class FirstPlayWrightProgram {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.saucedemo.com");
        String strExpTitle = "Swag Labs";
        String Title = page.title();
        boolean value = false;
        if (strExpTitle.equals(Title)) {
            value = true;
        }
        Assert.assertTrue(value);

        Locator USERNAME_TEXT_FIELD = page.locator("[id='user-name']");
        Locator PASSWORD_TEXT_FIELD = page.locator("[id='password']");
        Locator LOGIN_BUTTON = page.locator("[id='login-button']");
        Locator ADDTOCART_BUTTON = page.locator("text=ADD To CART");
        USERNAME_TEXT_FIELD.fill("standard_user");
        PASSWORD_TEXT_FIELD.fill("secret_sauce");
        LOGIN_BUTTON.click();

        ADDTOCART_BUTTON.first().click();

//        browser.close();
//        playwright.close();


    }
}
