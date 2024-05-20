package askmeoffers;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue()
    {
        Playwright playwright = Playwright.create();
        // LaunchOptions headless = new LaunchOptions().setHeadless(true);
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();

        page.navigate("https://www.chess.com");
        page.locator("a[aria-label='Log In']").click();
    
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("image.jpg")));

        page.close();
        browser.close();
        playwright.close();
    }
}
