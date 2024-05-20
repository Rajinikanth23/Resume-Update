package askmeoffers;

import com.microsoft.playwright.Playwright;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;

public class NaukriResume {

    @Test(description = "Resume update on naukri.com")
    void updateResume() throws InterruptedException
    {
        Playwright playwright = Playwright.create();
        LaunchOptions headless = new LaunchOptions().setHeadless(false);
        Browser browser = playwright.chromium().launch(headless);
        Page page = browser.newPage();
    
        page.navigate("https://www.naukri.com");
        page.locator("//a[@id='login_Layer']").click();
        page.locator("input[placeholder=\"Enter your active Email ID / Username\"]").fill("chatla.rajnikanth@gmail.com");
        page.locator("input[type='password']").fill("Parvathi@123");
        page.locator("button[type='submit']").click();
        page.getByText("View profile").click();
        
        FileChooser filechooser = page.waitForFileChooser(()->{
            page.click("input[value=\"Update resume\"]");
        });

        filechooser.setFiles(Paths.get("C:\\Users\\rajin\\Documents\\Playwright\\browserextension\\src\\Rajinikanth.doc"));

        Thread.sleep(2000);

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("resume.jpg")));

        System.out.println("Resume updated succesfully");

        page.close();
        browser.close();
        playwright.close();
    }
}