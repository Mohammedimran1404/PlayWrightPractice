package PlayWrightPractice;

import com.microsoft.playwright.*;

import java.util.regex.Pattern;

public class PracticeFrames {
    public static void main(String[] args) {

        Playwright playwright=Playwright.create();
       Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
       BrowserContext  context=browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1080));
       Page page=context.newPage();
       page.navigate("https://demo.automationtesting.in/Frames.html");

       page.getByText("Iframe with in an Iframe").click();

      Frame frame = page.frameByUrl(Pattern.compile(".*MultipleFrames.*"));
         FrameLocator insideFrame=frame.frameLocator("//*[@src='SingleFrame.html']").last();

         insideFrame.locator("//*[@type='text']").fill("Hi");

         playwright.close();
    }
}
