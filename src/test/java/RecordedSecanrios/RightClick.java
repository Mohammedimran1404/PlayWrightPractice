package RecordedSecanrios;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.MouseButton;

import javax.naming.Context;

public class RightClick {
    public static void main(String[] args) {
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(1900,1000));
        Page page=context.newPage();

        page.navigate("https://demo.automationtesting.in/Register.html");

        page.mouse().click(100, 200, new Mouse.ClickOptions().setButton(MouseButton.RIGHT));
    }
}
