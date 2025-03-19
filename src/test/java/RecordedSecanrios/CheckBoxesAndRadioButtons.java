package RecordedSecanrios;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.MouseButton;

import java.nio.file.Paths;

public class CheckBoxesAndRadioButtons {
    public static void main(String[] args) {
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

       BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1900,1080).setRecordVideoDir(Paths.get("RecordVideo/")));
       Page page=context.newPage();

       page.navigate("https://demo.automationtesting.in/Register.html");

//       page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("CheckBox.png")).setQuality(1080).setFullPage(true));

       Locator lstRdoBtns=page.locator("[type='checkbox']");
        Locator lstChkBoxNames=page.locator("[class='checks']");

       for (int i=0;i<lstChkBoxNames.count();i++){
           if("Cricket".equalsIgnoreCase(lstChkBoxNames.nth(i).textContent().trim())){
               lstRdoBtns.nth(i).setChecked(true);
           }
       }

       browser.close();
//       playwright.close();
    }
}
