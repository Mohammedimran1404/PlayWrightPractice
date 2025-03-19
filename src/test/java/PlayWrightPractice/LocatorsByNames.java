package PlayWrightPractice;

import com.microsoft.playwright.*;

public class LocatorsByNames {
    public static void main(String[] args) {

        Playwright playwright=Playwright.create();
       Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
       Page page =browser.newPage();
       page.navigate("https://www.orangehrm.com/en/contact-sales");

       Locator fieldFullName=page.getByPlaceholder("Your Full Name*");

       fieldFullName.fill("Testing");
//       browser.close();
    }
}
