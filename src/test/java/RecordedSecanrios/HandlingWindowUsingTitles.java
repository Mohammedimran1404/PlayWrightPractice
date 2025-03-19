package RecordedSecanrios;

import com.microsoft.playwright.*;

import java.util.List;

public class HandlingWindowUsingTitles {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://freelance-learn-automation.vercel.app/login");
//page.pause();
        Locator allLinks = page.locator("//*[@class='social'] //*[@id='Layer_1']");
        for (int i = 0; i < allLinks.count(); i++) {
            allLinks.nth(i).click();
        }
        page.waitForTimeout(4000);
        List<Page> allPages = context.pages();
        Page targetPage = null;
        for (Page onePage : allPages) {
            System.out.println(onePage.title());
            if ("Selenium Webdriver questions and answers | Facebook".contains(onePage.title())) {
                System.out.println("Switching to: " + onePage.title());
                onePage.bringToFront(); // Switch to the matched tab
                targetPage = onePage;
                break;
            }
        }
        String strTitle = "Selenium Webdriver questions and answers | Facebook";
        System.out.println(targetPage.title());
        System.out.println(targetPage.title().equals(strTitle));
        page.bringToFront();
        playwright.close();
    }
}