package PlayWrightPractice;

import com.microsoft.playwright.*;
import org.testng.Assert;


public class LoginFunctionalitySauceDemo {
    public static void main(String[] args) {

        Playwright  playwrightInstance = Playwright.create();
        Browser  browser = playwrightInstance.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page  page = browserContext.newPage();


        page.navigate("https://www.saucedemo.com/");

        Locator USERNAME_TEXT_FIELD = page.locator("[id='user-name']");
        Locator PASSWORD_TEXT_FIELD = page.locator("[id='password']");
        Locator LOGIN_BUTTON = page.locator("[id='login-button']");
        Locator BUTTON_SHOPPING_CART = page.locator("[class='shopping_cart_link']");
        Locator BUTTON_REMOVE = page.locator("[id='remove-sauce-labs-backpack']");
        Locator LST_ADDTOCART_BUTTON = page.locator("[class^='btn btn_primary btn_small btn_inventory']");
        Locator LST_INVENTORY_NAMES = page.locator("[class^='inventory_item_name']");


        boolean value = "Swag Labs".equals(page.title());
        System.out.println(page.title());
        Assert.assertTrue(value);


        USERNAME_TEXT_FIELD.fill("standard_user");
        PASSWORD_TEXT_FIELD.fill("secret_sauce");
        LOGIN_BUTTON.click();
        boolean flag = false;

          LST_INVENTORY_NAMES.nth(0).waitFor();
          int count=LST_INVENTORY_NAMES.count();
        System.out.println(count);
        for (int i = 0; i < LST_ADDTOCART_BUTTON.count(); i++) {
            System.out.println(LST_INVENTORY_NAMES.nth(i).textContent());
            if (LST_INVENTORY_NAMES.nth(i).textContent().equals("Sauce Labs Backpack")) {
                LST_ADDTOCART_BUTTON.nth(i).click();
                flag = true;
            }

        }
        if (!flag) {
            Assert.assertTrue(flag, "Values are not correct");
        }

        BUTTON_SHOPPING_CART.click();
        BUTTON_REMOVE.click();


        page.close();
        browser.close();
        playwrightInstance.close();


    }
}
