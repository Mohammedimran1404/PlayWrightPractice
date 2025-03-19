package RecordedSecanrios;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.nio.file.Paths;

public class SelectDropDowns {
    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("RecordVideo/")));
        Page page = context.newPage();
        page.navigate("https://demo.automationtesting.in/Register.html");

//        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("DrpDownPage.jpeg")).setQuality(50).setFullPage(true));

        Locator drpDownSkills = page.locator("[id='Skills']");

        drpDownSkills.scrollIntoViewIfNeeded();
        Thread.sleep(4000);

// select using values
//        drpDownSkills.selectOption("APIs");
        Thread.sleep(4000);

        drpDownSkills.selectOption(new SelectOption().setValue("APIs"));

        // select using visible text
        drpDownSkills.selectOption(new SelectOption().setLabel("Adobe Photoshop"));
        Thread.sleep(4000);

        drpDownSkills.selectOption(new SelectOption().setIndex(3));

        browser.close();
        playwright.close();


    }
}
