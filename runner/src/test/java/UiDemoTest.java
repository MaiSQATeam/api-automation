import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class UiDemoTest {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://www.nintendo.com");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("testScreenshot.png")));

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Iniciar sesión / Regístrate")).click();

//        Estas lineas son para cerrar el chrome y el playwright
//        browser.close();
//        playwright.close();
    }
}
