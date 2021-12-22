package src.test.java;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void formTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Gordon");
        $("#lastName").setValue("Freeman");
        $("#userEmail").setValue("freeman_g@black.mesa");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("9998887766");
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#userNumber").setValue("9998887766");

// Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("November");
        $(".react-datepicker__year-select").selectOptionContainingText("1998");
        $$("div[role='option']").findBy(Condition.text("19")).click();

// Checkboxes
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();

// Picture
        $("input[id='uploadPicture']").uploadFromClasspath("Gordon.jpg");

// State and city
        $("#currentAddress").setValue("10400 Northeast Fourth Street Floor 14 Bellevue, WA 98004 USA");
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#react-select-4-input").setValue("Jaiselmer").pressEnter();

// Send form
        $("#submit").scrollTo().click();

// Validation form
        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(".table").shouldHave(text("Gordon Freeman"),
                text("freeman_g@black.mesa"),
                text("Male"),
                text("9998887766"),
                text("19 November,1998"),
                text("Physics"),
                text("Sports, Reading, Music"),
                text("Gordon.jpg"),
                text("10400 Northeast Fourth Street Floor 14 Bellevue, WA 98004 USA"),
                text("Rajasthan Jaiselmer"));
//        Вариант через коллекцию
//        $$("tbody tr > td:nth-child(2)").shouldHave(CollectionCondition.exactTexts(
//                "Gordon Freeman", "freeman_g@black.mesa", "Male", "9998887766", "19 November,1998", "Physics",
//                "Sports, Reading, Music", "Gordon.jpg", "10400 Northeast Fourth Street Floor 14 Bellevue, WA 98004 USA",
//                "Rajasthan Jaiselmer"));

// Close form
        $("#closeLargeModal").click();
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
    }
}
