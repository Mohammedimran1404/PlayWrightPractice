package RecordedSecanrios;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class FirstRecordedScenarios {
    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        BrowserContext context = browser.newContext();

// Start tracing before creating / navigating a page.
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
        Page page = context.newPage();
        page.navigate("https://www.saucedemo.com/");
        page.locator("[data-test=\"username\"]").click();
        page.locator("[data-test=\"username\"]").fill("standard_user");
        page.locator("[data-test=\"password\"]").click();
//            page.pause();
        page.locator("[data-test=\"password\"]").fill("secret_sauce");
//        page.keyboard().press("Backspace");
        page.locator("[data-test=\"login-button\"]").click();
        page.locator("[data-test=\"add-to-cart-sauce-labs-backpack\"]").click();
//            Thread.sleep(2000);
        page.locator("[data-test=\"add-to-cart-sauce-labs-bike-light\"]").click();
//            Thread.sleep(2000);
        page.locator("[data-test=\"shopping-cart-link\"]").click();
//            Thread.sleep(2000);
        page.locator("[data-test=\"checkout\"]").click();
//            Thread.sleep(2000);
        page.locator("[data-test=\"cancel\"]").click();
//            Thread.sleep(2000);
        page.locator("[data-test=\"remove-sauce-labs-bike-light\"]").click();
//            Thread.sleep(2000);
        page.locator("[data-test=\"remove-sauce-labs-backpack\"]").click();
//            Thread.sleep(2000);

        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));

        browser.close();
        playwright.close();
    }
}



