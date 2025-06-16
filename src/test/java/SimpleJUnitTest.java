import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SimpleJUnitTest {

    @BeforeAll
    static void basicBrowserSettings() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 90000;
    }

    @Test
    public void PracticeFormTest() {

        open("https://demoqa.com/automation-practice-form");
        // First/Last name
        $("#firstName").setValue("Oleg");
        $("#lastName").setValue("Shirobokov");

        // Email
        $("#userEmail").setValue("shirobokov@mail.ru");

        // Gender
        $(byText("Male")).click();
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
        $(byText("Sports")).click();
        $("#hobbies-checkbox-1").shouldBe(selected);

        // Pictures
        File file = new File("src/test/resources/labubu-B-1.jpg");
        $("#uploadPicture").uploadFile(file);

        // CurrentAddress
        $("#currentAddress").setValue("KMarks.Street");

        // State And City
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();

        $("#submit").pressEnter();
    }
}
