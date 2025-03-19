package PlayWrightPractice;

import com.microsoft.playwright.*;

public class Practice {
    public static void main(String[] args) {

        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        Page page=browser.newPage();
        page.navigate("https://demo.automationtesting.in/Register.html");

        Locator l1 =page.getByPlaceholder("First Name");
        l1.pressSequentially("Automation Testing");
        playwright.close();

    }
}
