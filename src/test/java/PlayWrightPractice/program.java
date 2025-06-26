package PlayWrightPractice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.testng.Assert;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class program {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("RecordVideo/")));
        Page page = context.newPage();
        page.navigate("https://demo.automationtesting.in/Register.html");

        page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get("LoginPage.png")));

        Locator fieldFirstName = page.getByPlaceholder("First Name");
        Locator fieldLastName = page.getByPlaceholder("Last Name");
        Locator fieldAddress = page.locator("[ng-model='Adress']");
        Locator fieldEmail = page.locator("[type='email']");
        Locator filedPhoneNumber = page.locator("[type='tel']");
        Locator lstGenderRdoBtns = page.locator("[type='radio']");
        Locator lstHobbiesRdoBtns = page.locator("[type='checkbox']");
        Locator lstHobbiesNames = page.locator("[class='checks']");
        Locator fieldLanguages = page.locator("[id='msdd']");
        Locator lstLanguagesNames = page.locator("[style='text-decoration:none']");
        Locator drpDownSkills = page.locator("[id='Skills']");
        Locator fieldCountry = page.locator("[class='select2-selection select2-selection--single']");
        Locator lstCountries = page.locator("[role='treeitem']");
        Locator fieldYear = page.locator("[placeholder='Year']");
        Locator fieldMonth = page.locator("[placeholder='Month']");
        Locator fieldDay = page.locator("[placeholder='Day']");
        Locator fieldPassword = page.locator("[id='firstpassword']");
        Locator fieldConfirmPassword = page.locator("[id='secondpassword']");
        Locator fileUpload = page.locator("[id='imagesrc']");
        Locator buttonRefresh = page.locator("[value='Refresh']");

        fieldFirstName.fill("Test");
        fieldLastName.fill("Automation");
        fieldAddress.fill("Hyderabad");
        fieldEmail.fill("Test@gmail.com");
        filedPhoneNumber.fill("1234567890");

        String strRdoNumbers = "1";
        int numberRdoButton = Integer.parseInt(strRdoNumbers) - 1;
        lstGenderRdoBtns.nth(numberRdoButton).setChecked(true);
        assertThat(lstGenderRdoBtns.nth(numberRdoButton)).isChecked();
        String strHobbieName = "Cricket";

        for (int i = 0; i < lstHobbiesNames.count(); i++) {
            if (strHobbieName.equals(lstHobbiesNames.nth(i).textContent().trim())) {
                lstHobbiesRdoBtns.nth(i).check();
                assertThat(lstGenderRdoBtns.nth(i)).isChecked();
            }
        }

        fieldLanguages.click();
        String strLanguage = "Turkish";

        for (int i = 0; i < lstLanguagesNames.count(); i++) {
            if (strLanguage.equals(lstLanguagesNames.nth(i).textContent())) {
                lstLanguagesNames.nth(i).scrollIntoViewIfNeeded();
                lstLanguagesNames.nth(i).click();
            }
        }
        page.locator("//*[text()='Register']").last().click();

        drpDownSkills.selectOption(new SelectOption().setLabel("APIs"));
        fieldCountry.click();

        String strCountryName = "India";
        for (int i = 0; i < lstCountries.count(); i++) {
            if (strCountryName.equalsIgnoreCase(lstCountries.nth(i).textContent())) {
                lstCountries.nth(i).click();
            }
        }

        fieldYear.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("fieldYear.png")));

        fieldYear.selectOption(new SelectOption().setLabel("2000"));

        fieldMonth.selectOption(new SelectOption().setValue("January"));
        fieldDay.selectOption(new SelectOption().setLabel("2"));
        fieldPassword.fill("12qarst");
        fieldConfirmPassword.fill("12qarst");
        fileUpload.setInputFiles(Paths.get("C:/Users/ImranMohd-Kairos/Downloads/MohammedImran_Coverletter.pdf"));
        fieldFirstName.scrollIntoViewIfNeeded();
        page.mouse().move(575,88);

//        buttonRefresh.click();
        playwright.close();



    }


}
