package RecordedSecanrios;

import com.microsoft.playwright.*;

public class VisibleLocators {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

        Page page = browser.newPage();

        page.navigate("https://www.flipkart.com");

        Locator allLinks = page.locator("a:visible");
        int count = allLinks.count();
        System.out.println(count);
        for (int i = 0; i < allLinks.count(); i++) {
            System.out.println(allLinks.nth(i).textContent());
        }
//        List<String> allLinks =page.locator("a:visible").allInnerTexts();
//
//        System.out.println(allLinks.size());
//        for (int i=0;i<allLinks.size();i++){
//            System.out.println(allLinks.get(i));
//    }

      browser.close();
      playwright.close();
    }
}
