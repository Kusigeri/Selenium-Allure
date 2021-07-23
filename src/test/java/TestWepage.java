import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

public class TestWepage {
    WebDriver driver;

    @BeforeEach
    public void VideoBrowsing() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // **** Kusi-t írd át a saját windows login nevedre ****
        //options.addArguments("user-data-dir=c:\\Users\\Kusi\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("--disable-notifications"); // visszautasít minden böngésző felkérést pl: értesítések küldése
        options.addArguments("start-maximized"); // teljes képernyőőben való használat
        // +3 sor Github actionben való futtatáshoz
        /*
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        */
        //options.setExperimentalOption("useAutomationExtension", false);
        //options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = new ChromeDriver(options); // új böngésző nyitása az opciókkal
        driver.get("https://codecool.com/hu/");
    }

    @Test
    public void CoolWebpage() {
        String url = driver.getCurrentUrl();
        Assertions.assertEquals("https://codecool.com/hu/", driver.getCurrentUrl());
    }

    @AfterEach
    public void stopProcess() { driver.quit(); }

}
