import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyDummyTests extends TestBase {

    @Test
    void dummyDuckDuckGoSearch() {
        open("https://duckduckgo.com/");
        $("[id=search_form_input_homepage]").setValue("selenide").pressEnter();
        $("[id=links]").shouldHave(text("https://selenide.org"));
    }

    @Test
    void theInternetHerokuTest() {

        open("https://the-internet.herokuapp.com/login");
        $("#username").setValue("tomsmith");
        $("#password").setValue("SuperSecretPassword!");
        $("button.radius").click();

        $("div.flash").shouldHave(text("You logged into a secure area!"));

    }
}
