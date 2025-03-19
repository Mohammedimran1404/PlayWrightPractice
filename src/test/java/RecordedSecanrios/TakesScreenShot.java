package RecordedSecanrios;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class TakesScreenShot {
    public static void main(String[] args) {
        Playwright playwright=Playwright.create();
       Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
       BrowserContext context =browser.newContext(new Browser.NewContextOptions().setViewportSize(1900,1080));
       Page page=context.newPage();
       page.navigate("https://www.flipkart.com");
       page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")).setFullPage(true));
       page.locator("//*[@alt='Mobiles']").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("ParticularImage.png")));
       context.close();
       playwright.close();
    }
}
