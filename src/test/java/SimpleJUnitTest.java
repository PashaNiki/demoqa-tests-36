import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SimpleJUnitTest {

    @BeforeAll
    static void basicBrowserSettings() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    public void practiceFormTest() {

        open("/automation-practice-form");
        // First/Last name
        $("#firstName").setValue("Oleg");
        $("#lastName").setValue("Shirobokov");

        // Email
        $("#userEmail").setValue("shirobokov@mail.ru");

        // Gender
        $("#genterWrapper").$(byText("Male")).click();
        $("#gender-radio-1").shouldBe(selected);

        // PhoneNumber
        $("#userNumber").setValue("89635411862");

        // Date of birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__month-select").selectOption("July");
        $$(".react-datepicker__day").findBy(text("15")).click();

        // Subject
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#subjectsInput").setValue("Social Studies").pressEnter();

        // Hobbies
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbies-checkbox-1").shouldBe(selected);

        // Pictures
        $("#uploadPicture").uploadFromClasspath("labubu-B-1.jpg");

        // CurrentAddress
        $("#currentAddress").setValue("KMarks.Street");

        // State And City
        $("#state").scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText("NCR")).click();;
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").pressEnter();

        $(".modal-content").shouldBe(visible);
        $(".modal-body").shouldHave(text("Oleg"));
        $(".modal-body").shouldHave(text("Shirobokov"));
        $(".modal-body").shouldHave(text("shirobokov@mail.ru"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("89635411862"));
        $(".modal-body").shouldHave(text("15 July,2000"));
        $(".modal-body").shouldHave(text("Computer Science"));
        $(".modal-body").shouldHave(text("Arts"));
        $(".modal-body").shouldHave(text("Chemistry"));
        $(".modal-body").shouldHave(text("Social Studies"));
        $(".modal-body").shouldHave(text("Sports"));
        $(".modal-body").shouldHave(text("labubu-B-1.jpg"));
        $(".modal-body").shouldHave(text("KMarks.Street"));
        $(".modal-body").shouldHave(text("NCR Delhi"));
    }
}
