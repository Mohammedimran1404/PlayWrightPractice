package PlayWrightPractice;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUpload {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1900, 1080).setRecordVideoDir(Paths.get("RecordVideo/")));
        Page page = context.newPage();
        page.navigate("https://demo.automationtesting.in/FileUpload.html");

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("FileUpload.png")).setFullPage(true));

        Locator buttonBrowse = page.locator("input[type='file']");
//        buttonBrowse.click();

        ElementHandle el = buttonBrowse.elementHandle();

        el.setInputFiles(Paths.get("C:/Users/ImranMohd-Kairos/Downloads/MohammedImran_Coverletter.pdf"));
        el.setInputFiles(new Path[0]);
        System.out.println("success");
        playwright.close();

    }
}
