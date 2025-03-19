package RecordedSecanrios;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.MouseButton;

public class BrowserContextPractice {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

        BrowserContext context = browser.newContext();
        BrowserContext context1 = browser.newContext();

        Page page = context.newPage();
        Page page1 = context1.newPage();

        page.navigate("https://www.amazon.com");
        page1.navigate("https://www.flipkart.com");
        Thread.sleep(4000);
        String strFirstTitle = page.title();
        System.out.println(strFirstTitle);
        String strSecondTitle = page1.title();
        System.out.println(strSecondTitle);


        context.close();
        context1.close();
        browser.close();
        playwright.close();

    }
}
