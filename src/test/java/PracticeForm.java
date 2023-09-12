import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm extends TestBase {

    @Test
    void practiceFormTest() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        String Name = "Ivan ";
        String LastName = "Jrozny";
        String Email = "practiceFormTest@gmail.com";
        String Phone = "88005553535";

        $("#firstName").setValue(Name);
        $("#lastName").setValue(LastName);
        $("#userEmail").setValue(Email);
        $(".custom-control-label").click();
        $("#userNumber").setValue(Phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1955");
        $(".react-datepicker__day--005").click();
        $("#subjectsInput").setValue("com").pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/q.jpeg"));
        $("#currentAddress").setValue("Current Address- address");
        $("#state").click();
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Panipat").pressEnter();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text(Name+LastName),
                text(Email),
                text("Male"),
                text("8800555353"),
                text("05 March,1955"),
                text("Computer Science"),
                text("Sports"),
                text("q.jpeg"),
                text("Current Address- address"),
                text("Haryana Panipat"));
    }

}
