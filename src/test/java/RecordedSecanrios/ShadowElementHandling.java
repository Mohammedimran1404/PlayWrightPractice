package RecordedSecanrios;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowElementHandling {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://books-pwakit.appspot.com/");

//      page.locator("[apptitle='BOOKS'] [aria-label='Search Books']").fill("Books");
        page.locator("[aria-label='Search Books']").fill("Books");
        playwright.close();
    }

}
