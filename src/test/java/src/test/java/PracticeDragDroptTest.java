package src.test.java;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class PracticeDragDroptTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void DragDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

// Так как нам нужно повторно использовать код, то имеет смысл создать переменные
        SelenideElement elemFirst = $("#column-a");
        SelenideElement elemSecond = $("#column-b");

// Проверяем что все на находиться на своих местах
        elemFirst.$("header").shouldBe(text("A"));
        elemSecond.$("header").shouldBe(text("B"));

// Перетаскиваем элементы
        $("#column-a").dragAndDropTo("#column-b");

// Проверяем что перетаскивание сработало
        elemFirst.$("header").shouldBe(text("B"));
        elemSecond.$("header").shouldBe(text("A"));
    }
}
