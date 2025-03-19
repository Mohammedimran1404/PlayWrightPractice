package RecordedSecanrios;

import com.microsoft.playwright.*;

public class MaximizeScreen {
    public static void main(String[] args) {
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1100));
        Page page=context.newPage();
        page.navigate("https:www.amazon.com");
        playwright.close();
    }
}
