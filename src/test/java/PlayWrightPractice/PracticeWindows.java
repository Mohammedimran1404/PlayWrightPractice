package PlayWrightPractice;

import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.List;

public class PracticeWindows {
    public static void main(String[] args) {

        Playwright playwright=Playwright.create();
        Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
       BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1080).setRecordVideoDir(Paths.get("RecordVideo/")));
       Page page =context.newPage();
       page.navigate("https://demo.automationtesting.in/Windows.html");
        page.getByText("Open New Seperate Windows").click();
        page.locator("[class='btn btn-primary']").click();
       String strExpTitle="Selenium";
       List<Page> allPages =context.pages();
       for (Page onepage:allPages){
           if(strExpTitle.equals(onepage.title())){
               onepage.bringToFront();
               onepage.close();
           }
           page.bringToFront();
           page.getByText("Open New Tabbed Windows ").click();
           System.out.println(page.getByText("Open New Tabbed Windows ").textContent());
           playwright.close();

       }
    }
}
