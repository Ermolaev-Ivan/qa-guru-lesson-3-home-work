package src.test.java;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/*
 1. Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что,
 поиск найдёт разные элементы?

 Ответ: да, второй вариант найдет первый попавшийся элемент "h1" и внутри него попробует найти "div"(т.е. если в первом
  "h1" не будет "div" - получим ошибку), первый вариант найдет первый элемент "h1 div" на любой вложенности дома.
 Есть пример с формой(https://demoqa.com/automation-practice-form)
 $("div").$("input[placeholder='First Name']").setValue("Gordon");  // не найдет поле
 $("div input[placeholder='First Name']").setValue("Ben"); // напротив найдет нужное поле
*/

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

/*
2. Разработайте следующий автотест:
 - Откройте страницу Selenide в Github
 - Перейдите в раздел Wiki проекта
 - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
 - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
 */

    @Test
    void formTest() {
        open("https://github.com/selenide/selenide");

        $$("ul.UnderlineNav-body.list-style-none li").find(text("Wiki")).click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(By.linkText("SoftAssertions")).shouldBe(visible).click();
        $$(".markdown-body > ol").findBy(text("Using JUnit5 extend test class")).sibling(0)
                .shouldBe(visible);
    }
}
