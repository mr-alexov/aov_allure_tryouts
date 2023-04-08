import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class TestBase {

    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        // Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        String executionMode = System.getProperty("executionMode", "local");
        logger.info("Execution mode: " + executionMode);

        if (executionMode.equals("remote")) {
            Configuration.browser = System.getProperty("browser", "chrome");
            logger.info("Browser" + Configuration.browser);

            Configuration.browserVersion = System.getProperty("browserVersion", "100");
            logger.info("Browser version" + Configuration.browserVersion);

            Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));

            Configuration.browserCapabilities = capabilities;
        }

    }

}
