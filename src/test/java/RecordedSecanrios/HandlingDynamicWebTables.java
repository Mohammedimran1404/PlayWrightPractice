package RecordedSecanrios;

import com.microsoft.playwright.*;

import java.util.List;

public class HandlingDynamicWebTables {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
//        BrowserContext context = browser.newContext();
        Page page = browser.newPage();
        page.navigate("https://cosmocode.io/automation-practice-webtable/");
        Locator lstCountriesNames = page.locator("//*[@id='countries'] //td[2] //strong");
        Locator lstChkBoxes = page.locator("//*[@type='checkbox']");
//        lstCountriesNames.nth(0).scrollIntoViewIfNeeded();
//        page.waitForTimeout(4000);
//        page.pause();
        String strCountries = "Afghanistan & Andorra";
        String[] strSplitCountries = strCountries.split("&");
        for (String strCountry : strSplitCountries) {
            for (int j = 0; j < lstCountriesNames.count(); j++) {
                if (strCountry.trim().equals(lstCountriesNames.nth(j+1).textContent().trim())) {
//                    page.waitForTimeout(3000);
                    System.out.println(lstCountriesNames.nth(j+1).textContent());
                    lstChkBoxes.nth(j).click();
                    break;
                }
            }
        }

        Locator lstCountries = page.locator("//*[@id='countries'] //tr");
        List<String> table = lstCountries.locator(":scope").allInnerTexts();

        for (String strRow : table) {
            System.out.println(strRow);
        }

        browser.close();
        playwright.close();
    }
}
