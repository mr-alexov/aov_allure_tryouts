import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyAllureDummyTests {

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

        // Configuration.holdBrowserOpen = true;

    }

    @Test
    void dummyDuckDuckGoSearch() {
        open("https://duckduckgo.com/");
        $("[id=search_form_input_homepage]").setValue("selenide").pressEnter();
        $("[id=links]").shouldHave(text("https://selenide.org"));
    }

}
