package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class SystemPropertiesTest {
    @Test
    void systemPropertiesTest() {
        String browser = System.getProperty("browser");
        System.out.println(browser);
    }

    @Test
    void systemProperties1Test() {
        System.setProperty("browser", "chrome");
        String browser = System.getProperty("browser");

        System.out.println(browser);
    }

    @Test
    void systemProperties2Test() {
        String browser = System.getProperty("browser", "firefox");

        System.out.println(browser);
    }

    @Test
    void systemProperties3Test() {
        System.setProperty("browser", "chrome");
        String browser = System.getProperty("browser", "firefox");

        System.out.println(browser);
    }

    @Test
    @Tag("property")
    void systemProperties4Test() {
        String browser = System.getProperty("browser", "firefox");

        System.out.println(browser);
        // gradle property_test -Dbrowser=opera
    }

    @Test
    @Tag("hello")
    void systemProperties5Test() {
        String name = System.getProperty("name", "default student");
        String message = format("Hello, %s!", name);

        System.out.println(message);
        // gradle hello_test
        // Hello, default student!

        // gradle hello_test -Dname='John Smith'
    }
}



