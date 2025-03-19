package RecordedSecanrios;

import com.microsoft.playwright.*;

import java.util.regex.Pattern;

public class DifferentWaysFrameHandling {
    public static void main(String[] args) {

        Playwright playwright=Playwright.create();
       Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
       Page page=browser.newPage();
        DifferentWaysFrameHandling d=new DifferentWaysFrameHandling();
       page.navigate("https://www.hyrtutorials.com/p/frames-practice.html");
  // frame by  any locator
     FrameLocator fLocator = page.frameLocator("(//*[@id='frm2'])[1]");
              String str=fLocator.locator("'In HTML we have some basic controls we use often, those are:'").last().textContent();
        System.out.println(str);
  // frame by id or name
    String strStoreFrame=page.frame("frm2").locator("'In HTML we have some basic controls we use often, those are:'").last().textContent();
        System.out.println(strStoreFrame);

 // frame by url
        Frame frame=page.frameByUrl("https://www.hyrtutorials.com/p/basic-controls.html");
         Locator l1=frame.locator("'In HTML we have some basic controls we use often, those are:'").last();
        String strText1= d.getText(l1);
        System.out.println(strText1);

        // frame by reg expression unique    value should be there
        Frame fra=page.frameByUrl(Pattern.compile(".*basic-controls.*"));
        Locator l11=fra.locator("'In HTML we have some basic controls we use often, those are:'").last();
        String strText12= d.getText(l11);
        System.out.println(strText12);


        playwright.close();

    }


    public String getText(Locator locator ){
      return  locator.textContent();

    }
}
