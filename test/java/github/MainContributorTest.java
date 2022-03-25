package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;

public class MainContributorTest {

  @Test
  void checkMainContributor() {
    // открыть страничку репозитория Селенида
    open("https://github.com/selenide/selenide");
    // подвести мышку к первому элементу в области Contributors
    $(".Layout-sidebar").$(withText("Contributors"))
            .closest(".BorderGrid-row").$("ul li").hover();

    // check: в появившемся окошке (оверлей) текст Andrei Solntsev
    $$(".Popover-message").shouldHave(text("Andrei Solntsev"));
  }
}
