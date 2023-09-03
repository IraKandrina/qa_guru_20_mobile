package mobile.tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class AndroidTests extends TestBase {
    @Test
    @Tag("android")
    @DisplayName("Search test")
    void successfulSearchTest() {
        step("Perform search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("HTML");
        });
        step("Verify results", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/search_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @Tag("android")
    @DisplayName("Open article test")
    void successfulOpenArticleTest() {
        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("HTML");
        });
        step("Verify content found", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0));
        });
        step("Open article", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_container")).first().click()
        );
        step("Verify results", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/view_wiki_error_button")).shouldBe(visible);
            $(AppiumBy.id("org.wikipedia.alpha:id/view_wiki_error_text")).shouldHave(text("An error occurred"));
        });
    }
}
