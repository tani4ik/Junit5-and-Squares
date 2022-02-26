package github;

import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Square {

  @Test
  void dropingSquares() {

    open("https://the-internet.herokuapp.com/drag_and_drop");
    // actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();
    $("#column-a").dragAndDropTo("#column-b");
    $$("#column-a").shouldHave(texts("B"));
    $$("#column-b").shouldHave(texts("A"));


  }
}


