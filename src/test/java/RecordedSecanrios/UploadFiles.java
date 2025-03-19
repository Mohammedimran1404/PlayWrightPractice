package RecordedSecanrios;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadFiles {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(1000));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");

       Locator chooseFileButton= page.locator("[id='filesToUpload']");

       ElementHandle el=chooseFileButton.elementHandle();


        el.setInputFiles( Paths.get("C:\\Users\\ImranMohd-Kairos\\Downloads\\MohammedImran_Coverletter.pdf"));

        el.setInputFiles(new Path[0]);

        playwright.close();
    }
}
