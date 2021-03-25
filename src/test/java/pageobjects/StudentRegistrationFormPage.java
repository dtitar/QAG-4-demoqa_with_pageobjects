package pageobjects;

import student.Student;

import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormPage {

    private static final String STUDENT_REGISTRATION_FORM_URL = "https://demoqa.com/automation-practice-form";

    public final StudentRegistrationFormPage openPage() {
        open(STUDENT_REGISTRATION_FORM_URL);
        $(byClassName("main-header")).shouldHave(text("Practice Form"));
        return this;
    }

    public StudentRegistrationFormPage fillForm(Student student) {

        $("#firstName").setValue(student.getFirstName());
        $("#lastName").setValue(student.getLastName());
        $("#userEmail").setValue(student.getEmail());
        $(byValue(student.getGender())).doubleClick();
        $("#userNumber").setValue(student.getMobileNumber());
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue(String.valueOf(student.getBirthDate().getMonth().getValue() - 1));
        $(".react-datepicker__year-select").selectOptionByValue(String.valueOf(student.getBirthDate().getYear()));
        $(String.format(".react-datepicker__day--0%s", String.format("%02d", student.getBirthDate().getDayOfMonth()))).click();
        $("#subjectsInput").setValue(student.getSubjects().get(0)).pressEnter();
        $(byText(student.getHobbies().get(0))).click();
        $("#uploadPicture").uploadFromClasspath("images/" + student.getFileName());
        $("#currentAddress").setValue(student.getCurrentAddress());
        $("#react-select-3-input").setValue(student.getState()).pressEnter();
        $("#react-select-4-input").setValue(student.getCity()).pressEnter();
        $("#submit").click();
        return this;
    }

    public final void checkData(Student student) {
        $(byClassName("modal-content")).shouldBe(visible);
        $$(".table tr").shouldHave(size(11));
        $(".table tr", 0).shouldHave(text("Label")).shouldHave(text("Values"));
        $(".table tr", 1).shouldHave(text(student.getFirstName())).shouldHave(text(student.getLastName()));
        $(".table tr", 2).shouldHave(text(student.getEmail()));
        $(".table tr", 3).shouldHave(text(student.getGender()));
        $(".table tr", 4).shouldHave(text(student.getMobileNumber()));
        $(".table tr", 5).shouldHave(text(student.getBirthDate().format(DateTimeFormatter.ofPattern("dd MMMM,yyyy"))));
        $(".table tr", 6).shouldHave(text(String.join(", ", student.getSubjects())));
        $(".table tr", 7).shouldHave(text(String.join(", ", student.getHobbies())));
        $(".table tr", 8).shouldHave(text(student.getFileName()));
        $(".table tr", 9).shouldHave(text(student.getCurrentAddress()));
        $(".table tr", 10).shouldHave(text(student.getState())).shouldHave(text(student.getCity()));
    }
}
