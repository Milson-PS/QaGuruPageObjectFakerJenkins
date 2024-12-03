package utils;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class RandomUtils {

    Faker faker = new Faker(new Locale("en"));

    public String FirstName() {
        return faker.name().firstName();
    }

    public String LastName() {
        return faker.name().lastName();
    }

    public String UserEmail() {
        return faker.internet().emailAddress();
    }

    public String Gender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public String PhoneNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String DayOfBirth() {
        return String.format("%02d", faker.number().numberBetween(1, 28));
    }

    public String MonthOfBirth() {
        return faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }

    public String YearOfBirth() {
        return String.valueOf(faker.number().numberBetween(1900, LocalDate.now().getYear()));
    }

    public String Subjects() {
        return faker.options().option("Economics", "English", "Arts", "Social Studies");
    }

    public String Hobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String CurrentAddress() {
        return faker.address().streetAddress();
    }

    public String State() {
        return faker.options().option("NCR", "Haryana", "Uttar Pradesh", "Rajasthan");
    }

    public String City(String state) {
        Map<String, String[]> citiesByState = new HashMap<>();
        citiesByState.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        citiesByState.put("Uttar Pradesh", new String[]{"Lucknow", "Agra", "Merrut"});
        citiesByState.put("Haryana", new String[]{"Karnal", "Panipat"});
        citiesByState.put("Rajasthan", new String[]{"Jaiselmer", "Jaipur"});
        var citiesForThisState = citiesByState.get(state);
        return faker.options().option(citiesForThisState);
    }

    ;

}




