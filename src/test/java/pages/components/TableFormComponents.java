package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableFormComponents {
    private final SelenideElement table = $(".table-responsive");

    public void checkResult(String key, String value) {
        table.$(byText(key))
                .parent()
                .shouldHave(text(value));
    }

    public void checkTableIsNotVisible() {
        $(".table").shouldNotBe(visible);

    }
}