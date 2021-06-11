package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FillFormTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }
    @Test
    void fillTextAndCheck() {
    open("https://demoqa.com/automation-practice-form");
    $("#firstName").setValue("Vasya");
    $("#lastName").setValue("Poupkine");
    $("#userEmail").setValue("vpmail@poupkinesfamily.com");
    $("[for='gender-radio-1']").click();
    $("#userNumber").setValue("5550123000");
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOptionByValue("3");
    $(".react-datepicker__year-select").selectOptionByValue("1980");
    $(".react-datepicker__day--001").click();
    $("#subjectsInput").setValue("art");
    $("#subjectsInput").pressEnter();
    $("#subjectsInput").setValue("ma");
    $("#subjectsInput").pressEnter();
    $("[for='hobbies-checkbox-3']").click();

        File pic = new File("src/test/java/test/winner4.jpg");
        $("#uploadPicture").uploadFile(pic);

    //$("#uploadPicture").uploadFromClasspath("winner4.jpg");
    $("#currentAddress").setValue("Gallifrey, North");
    $("#react-select-3-input").setValue("Utt");
    $("#react-select-3-input").pressEnter();
    $("#react-select-4-input").setValue("Agr");
    $("#react-select-4-input").pressEnter();
    $("#submit").click();

        $(".modal-content").shouldHave(text("Vasya"),
                text("Poupkine"),
                text("vpmail@poupkinesfamily.com"),
                text("5550123000"),
                text("01 April,1980"),
                text("Arts, Maths"),
                text("Music"),
                text("winner4.jpg"),
                text("Gallifrey, North"),
                text("Uttar Pradesh Agra"));
    }

}
