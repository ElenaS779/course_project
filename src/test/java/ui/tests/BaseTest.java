package ui.tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static utils.EnvProperties.BASE_URL;
import static utils.EnvProperties.BROWSER;

public class BaseTest {
    @BeforeMethod
    public void setUp() {
        Configuration.baseUrl = BASE_URL;
//        нажаль не змогла реалізувати запуск з різних браузерів. постійно отримую таку помилку :
//        java.lang.IllegalArgumentException: Class not found: "firefox"

//        if(BROWSER == "firefox") {
//            FirefoxDriverManager.getInstance().setup();
//        } else if (BROWSER == "chrome") {
//            ChromeDriverManager.getInstance().setup();
//        }
//        Configuration.browser = BROWSER;
    }

    @AfterMethod(alwaysRun = true)
    public void cleanup() {
        closeWebDriver();
    }
}
