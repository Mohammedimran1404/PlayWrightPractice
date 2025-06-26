package PlayWrightPractice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class Test {
    public static void main(String[] args) {
        Playwright playwrightInstance = Playwright.create();
        Browser browser = playwrightInstance.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://kairostech.com/");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Explore")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Talk to our Experts")).click();
        page.locator("input[name=\"FIRSTNAME\"]").click();
        page.locator("input[name=\"FIRSTNAME\"]").fill("Test");
        page.locator("input[name=\"CONTACT_EMAIL\"]").click();
        page.locator("input[name=\"CONTACT_EMAIL\"]").fill("test@gmail.com");
        page.locator("input[name=\"COMPANYNAME\"]").click();
        page.locator("input[name=\"COMPANYNAME\"]").fill("Kairos");
        page.locator("input[name=\"PHONE\"]").click();
        page.locator("input[name=\"PHONE\"]").fill("123344");
        page.close();
        browser.close();
        playwrightInstance.close();

    }
}
