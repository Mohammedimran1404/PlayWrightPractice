package POC;

import com.microsoft.playwright.*;
import org.testng.Assert;

import java.nio.file.Paths;

public class SauceDemo {
    public static void main(String[] args) {

        Playwright playwright=Playwright.create();
        Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext context =browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("RecordVideo/")));
        Page page=context.newPage();
        page.navigate("https://www.saucedemo.com/v1/inventory.html");
        page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get("SauceDemo.png")));
        Locator lstButtonAddToCart=page.locator("[class='btn_primary btn_inventory']");
        Locator lstTextItemNames=page.locator("[class='inventory_item_name']");
        Locator buttonCart=page.locator("[fill='currentColor']");
        Locator buttonCheckOut=page.locator("[class='btn_action checkout_button']");
        Locator fieldFirstName=page.getByPlaceholder("First Name");
        Locator fieldLastName=page.getByPlaceholder("Last Name");
        Locator fieldZipCode=page.getByPlaceholder("Zip/Postal Code");
        Locator buttonContinue=page.locator("[type='submit']");
        Locator buttonFinish=page.locator("[class='btn_action cart_button']");
        Locator textHeader=page.locator("[class='complete-header']");
        Locator textPrice=page.locator("[class='inventory_item_price']");
        Locator textTotalPrice=page.locator("[class='summary_subtotal_label']");

//         page.pause();
        String[] lstStrSelectItem={"Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt"};
        double totalPrice = 0.0;
        for (int i=0;i<lstStrSelectItem.length;i++){
            for (int j=0;j<lstTextItemNames.count();j++){
                String itemName = lstTextItemNames.nth(j).textContent().trim();
                if(lstStrSelectItem[i].trim().equals(itemName)){

                    lstButtonAddToCart.nth(j).click();
                    String strGetPrice = textPrice.nth(j).textContent().replaceAll("[^0-9.]", "");
                    double itemPrice = Double.parseDouble(strGetPrice);
                    totalPrice+=itemPrice;
                    break;
                }

            }
        }
        System.out.println("Total price is "+totalPrice);
        buttonCart.click();
        buttonCheckOut.click();
        fieldFirstName.fill("Test");
        fieldLastName.fill("Automation");
        fieldZipCode.fill("1234");
        buttonContinue.click();
        buttonFinish.click();

        String strText="THANK YOU FOR YOUR ORDER";

        boolean value=false;
        if(strText.equals(textHeader.textContent().trim())){
            value=true;
        }
        Assert.assertTrue(value,"Text is not same");


        page.close();
        browser.close();
        playwright.close();

    }

}

