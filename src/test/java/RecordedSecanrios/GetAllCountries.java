package RecordedSecanrios;

import com.microsoft.playwright.*;

public class GetAllCountries {
    public static void main(String[] args) {

      Playwright playwright=  Playwright.create();
     Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
     BrowserContext context =browser.newContext();
     Page page=context.newPage();
     page.navigate("https://cosmocode.io/automation-practice-webtable/");

      Locator AllCountriesNames= page.locator("//*[@id='countries'] //td[2]");
          int count=   AllCountriesNames.count()-1;
        System.out.println(count);
      for (int i=1;i<AllCountriesNames.count();i++){
          System.out.println(AllCountriesNames.nth(i).textContent());
      }

      page.close();
      browser.close();
      playwright.close();
    }
}
