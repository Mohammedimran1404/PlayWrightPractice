package POC;

import com.microsoft.playwright.*;
import org.testng.Assert;

import java.nio.file.Paths;
import java.util.Random;

public class RoyalEnfieldTest {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("RecordVideo/")));
        Page page = context.newPage();
        page.navigate("https://re.crm8.dynamics.com");
        page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get("Enquiry.png")));

        page.locator("[name='loginfmt']").fill("111-SM@dealer.royalenfield.com");
        page.locator("[id^='idSIButton']").click();
        page.locator("[name='passwd']").fill("Royal@12345");
        page.locator("[id^='idSIButton']").click();
        page.locator("[id^='idSIButton']").click();
        Thread.sleep(10000);
        FrameLocator frameLocator = page.frameLocator("iframe[id='AppLandingPage']");
        frameLocator.locator("[title^='Streamline your dealership operations']").click();
        page.locator("//*[text()='Enquiries']").click();
        page.locator("[title='New']").click();
        page.locator("[aria-label='Type of Enquiry']").click();
        Locator lstWalkin = page.locator("[id^='fluent-option']");
        String strValue = "Walk in";
        for (int i = 0; i < lstWalkin.count(); i++) {
            if (strValue.equalsIgnoreCase(lstWalkin.nth(i).textContent())) {
                Thread.sleep(2000);
                lstWalkin.nth(i).click();
                break;
            }
        }
        try {
            page.locator("[id^='confirmButton']").click();
        }
        catch (Exception e){

        }
        int startingDigit = 9;
        if (startingDigit < 1 || startingDigit > 9) {
            throw new IllegalArgumentException("Starting digit must be between 1 and 9.");
        }

        StringBuilder number = new StringBuilder();
        number.append(startingDigit); // Set starting digit

        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            number.append(random.nextInt(10)); // Append remaining 9 random digits (0–9)
        }

        page.locator("[aria-label='Mobile Phone']").click();
        page.locator("[aria-label='Mobile Phone']").fill(number.toString());
        page.locator("[id*='firstname.fieldControl'][aria-label='First Name']").click();
        page.locator("[id*='firstname.fieldControl'][aria-label='First Name']").fill("TestAutomation");
        page.locator("[aria-label='Email']").click();
        page.locator("[aria-label='Email']").fill("Test@gmail.com");
        page.locator("[aria-label='Postal Code, Lookup']").scrollIntoViewIfNeeded();
        page.locator("[aria-label='Postal Code, Lookup']").click();
        Thread.sleep(2000);
        page.locator("[aria-label='Postal Code, Lookup']").fill("500049");
        page.locator("[aria-label='Search records for Postal Code, Lookup field']").click();
        page.locator("(//*[contains(@data-id,'xrm_postalcode.fieldControl-LookupResultsDropdown_xrm_postalcode_infoContaine')])[1]").click();
        page.locator("[aria-label='Main Consideration Model, Lookup']").click();
        Thread.sleep(2000);
        page.locator("[aria-label='Main Consideration Model, Lookup']").fill("VCDD60TK");
        page.locator("[aria-label='Search records for Main Consideration Model, Lookup field']").click();
        page.locator("[data-id='xrm_modelbookedid.fieldControl-LookupResultsDropdown_xrm_modelbookedid_infoContainer']").click();

        page.locator("[aria-label='Purchase Timeframe']").click();
        String strPurchaseFrame = "Within 30 days";
        Locator lstPurchaseFrame = page.locator("[id^='fluent-option']");
        for (int i = 0; i < lstPurchaseFrame.count(); i++) {
            if (lstPurchaseFrame.nth(i).textContent().trim().equals(strPurchaseFrame)) {
                Thread.sleep(2000);
                lstPurchaseFrame.nth(i).click();
                break;
            }
        }
        page.locator("[data-id='xrm_testridetaken.fieldControl-option-set-select']").scrollIntoViewIfNeeded();
        page.locator("[aria-label='Opted to Finance?']").scrollIntoViewIfNeeded();
        page.locator("[aria-label='Opted to Finance?']").click();
        Locator lstOptedFinance = page.locator("[id^='fluent-option']");
        for (int i = 0; i < lstOptedFinance.count(); i++) {
            if (lstOptedFinance.nth(i).textContent().trim().equals("No")) {
                Thread.sleep(2000);
                lstOptedFinance.nth(i).click();
                break;
            }
        }

        page.locator("[data-id='xrm_testridetaken.fieldControl-option-set-select']").click();
        Locator lstTestRide = page.locator("[id^='fluent-option']");
        for (int i = 0; i < lstTestRide.count(); i++) {
            if (lstTestRide.nth(i).textContent().trim().equals("No")) {
                Thread.sleep(2000);
                lstTestRide.nth(i).click();
                break;
            }
        }

        page.locator("[aria-label='Test Ride Denial Reasons']").click();
        Locator lstTestRideReasons = page.locator("[id^='fluent-option']");
        for (int i = 0; i < lstTestRideReasons.count(); i++) {
            if (lstTestRideReasons.nth(i).textContent().trim().equals("Take test ride later")) {
                Thread.sleep(2000);
                lstTestRideReasons.nth(i).click();
                break;
            }
        }

        page.locator("[aria-label='OTHER CUSTOMER DETAILS']").click();
        page.locator("[aria-label='Enquiry Category']").click();
        Locator lstEnquiryCategory = page.locator("[id^='fluent-option']");
        for (int i = 0; i < lstEnquiryCategory.count(); i++) {
            if (lstEnquiryCategory.nth(i).textContent().trim().equals("Normal")) {
                Thread.sleep(2000);
                lstEnquiryCategory.nth(i).click();
                break;
            }
        }

        page.locator("[title='Save']").click();
        Thread.sleep(10000);

        Locator enquiryNumber = page.locator("(//div[contains(text(), 'ENQ')])[1]");
        boolean value = enquiryNumber.textContent().contains("ENQ");
        System.out.println(enquiryNumber.textContent());
        Assert.assertTrue(value, "Enquiry number is not generated or wrong enquiry number");

        context.close();
        playwright.close();

    }

}
