package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGithubJunit {

  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080";
  }

  // Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что, поиск найдёт разные элементы?
  // Есть, в первом варианте будут выбираться h1 во всеъ div, во втором случае ищется div только в первом h1.

  @Test
  void shouldFindJunit5() {
    // открыть страницу github.com
    open("https://github.com/selenide/selenide");
    // нажимаем на линк на Wiki
    $("#wiki-tab").click();

    // раскрываем список Pages
    $("#wiki-pages-box").$(withText("more pages")).click();
    // проверяем, что в списке страниц (Pages) есть страница SoftAssertions
    $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
    // переходим на страницу SoftAssertions
    $("#wiki-pages-box").$(byText("SoftAssertions")).click();
    // проверяем, что на странице есть пример кода для JUnit5
    $("#wiki-body").shouldHave(text("JUnit5"));
    //$$("#wiki-body").shouldHave(textsInAnyOrder("JUnit5", "Example", "code")); - не работает :)
  }
}




