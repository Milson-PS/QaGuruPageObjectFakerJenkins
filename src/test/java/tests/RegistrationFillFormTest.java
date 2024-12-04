package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;

import static io.qameta.allure.Allure.step;


public class RegistrationFillFormTest extends TestBase {


    private final RandomUtils random = new RandomUtils();


    String
            firstName = random.FirstName(),
            lastName = random.LastName(),
            userEmail = random.UserEmail(),
            gender = random.Gender(),
            phoneNumber = random.PhoneNumber(),
            dayOfBirth = random.DayOfBirth(),
            monthOfBirth = random.MonthOfBirth(),
            yearOfBirth = random.YearOfBirth(),
            subjects = random.Subjects(),
            hobbies = random.Hobbies(),
            picName = "bag.png",
            currentAddress = random.CurrentAddress(),
            state = random.State(),
            city = random.City(state);


    @Tag("regress")
    @DisplayName("Заполнение и проверка всех полей")
    @Test
    void fillFormTest() {
        step("Открыть страницу", () -> {
            registrationPage.openPage();
        });
        step("Заполнение всех полей", () -> {
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserEmail(userEmail)
                    .setGender(gender)
                    .setNumber(phoneNumber)
                    .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                    .setSubjects(subjects)
                    .setHobbies(hobbies)
                    .setPicture(picName)
                    .setCurrentAddress(currentAddress)
                    .setState(state)
                    .setCity(city)
                    .Submit();
        });

        step("Проверка отображения полей", () -> {
            registrationPage
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", userEmail)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", phoneNumber)
                    .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                    .checkResult("Subjects", subjects)
                    .checkResult("Hobbies", hobbies)
                    .checkResult("Picture", picName)
                    .checkResult("Address", currentAddress)
                    .checkResult("State and City", state + " " + city);
        });
    }

    @Tag("regress")
    @DisplayName("Заполнение только обязательных полей формы")
    @Test
    void minimumAmountDataTest() {
        step("Открыть страницу", () -> {
            registrationPage.openPage();
        });

        step("Заполнение обязательных полей", () -> {
        registrationPage.setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setNumber(phoneNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .Submit();
        });

        step("Проверка заполнения ", () -> {
        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies);
        });
    }

    @Tag("regress")
    @DisplayName("Неправильный номер пользователя")
    @Test
    void incorrectPhoneNumberTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setNumber(phoneNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .Submit();

        registrationPage.negativeCheck();

    }
}










