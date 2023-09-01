package mobile.tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class IosTests extends TestBase {
    @Test
    @Tag("ios")
    @DisplayName("Enter test")
    void sampleTest() {
        step("Переход на форму ввода текста", () ->
                $(AppiumBy.accessibilityId("Text Button")).click());
        step("Ввод текста", () ->
                $(AppiumBy.accessibilityId("Text Input")).sendKeys("Test" + "\n"));
        step("Проверка введенного ранее текста", () ->
                $(AppiumBy.accessibilityId("Text Output")).shouldHave(text("Test")));
    }
}
