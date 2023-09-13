import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm extends TestBase {

    @Test
    void practiceFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        String name = "Ivan ";
        String lastName = "Jrozny";
        String email = "practiceFormTest@gmail.com";
        String phone = "8005553535";

        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(".custom-control-label").click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1955");
        $(".react-datepicker__day--005").click();
        $("#subjectsInput").setValue("com").pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("q.jpeg");
        $("#currentAddress").setValue("Current Address- address");
        $("#state").click();
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Panipat").pressEnter();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text(name+lastName),
                text(email),
                text("Male"),
                text("8005553535"),
                text("05 March,1955"),
                text("Computer Science"),
                text("Sports"),
                text("q.jpeg"),
                text("Current Address- address"),
                text("Haryana Panipat"));
    }

}
