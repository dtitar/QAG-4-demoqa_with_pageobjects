package scenarios;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pageobjects.StudentRegistrationFormPage;
import student.Student;
import student.StudentFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest extends TestBase {

    Student student = StudentFactory.getRandomStudentWithAllFields();
    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();

    @Test
    final void successfulFillTest() {
        studentRegistrationFormPage
                .openPage()
                .fillForm(student)
                .checkData(student);
    }
}
