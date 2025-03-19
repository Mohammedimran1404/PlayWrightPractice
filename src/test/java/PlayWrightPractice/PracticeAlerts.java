package PlayWrightPractice;

import com.microsoft.playwright.*;

public class PracticeAlerts {
    public static void main(String[] args) {

        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        BrowserContext context =browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1080));
        Page page=context.newPage();

        page.navigate("https://demo.automationtesting.in/Alerts.html");

        page.onDialog(dialog -> {
            String strMessage=dialog.message();
            System.out.println(strMessage);
            dialog.accept();
        });

       Locator button =page.locator("//*[text()='Alert with OK & Cancel ']");
       Locator buttonOk=page.locator("[class='btn btn-primary']");

       button.click();
       buttonOk.click();
       playwright.close();
    }
}
