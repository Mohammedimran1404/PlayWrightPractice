package RecordedSecanrios;

import com.microsoft.playwright.*;

public class HandlingAlerts {
    public static void main(String[] args) {

        Playwright playwright=Playwright.create();
        Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        BrowserContext context =browser.newContext();
        Page page=context.newPage();
        page.navigate("https://testpages.herokuapp.com/styled/alerts/alert-test.html");

       Locator alertButton= page.locator("[value='Show prompt box']");

        page.onDialog(dialog -> {
            String strMessage=dialog.message();
            System.out.println(strMessage);

//            dialog.accept("i am prompt alert");
//            dialog.accept();
        });

       alertButton.click();




//playwright.close();
    }
}
