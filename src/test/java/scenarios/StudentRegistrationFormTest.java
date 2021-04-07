package scenarios;

import org.junit.jupiter.api.Test;
import pageobjects.StudentRegistrationFormPage;
import student.Student;
import student.StudentFactory;

public class StudentRegistrationFormTest extends TestBase {

    Student student = StudentFactory.getRandomStudent();
    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();

    @Test
    final void successfulFillTest() {
        studentRegistrationFormPage
                .openPage()
                .fillForm(student)
                .checkData(student);
    }
}
