import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class OptionalApiTest {

    @Before
    public void setUp() {

    }

    @Test
    public void test_optional() {
        Optional optional = Optional.of("Kostadin");
        String actual = optional.get().toString();
        assertEquals("Kostadin",actual);
    }

    @Test
    public void test_optional_of_1() {
        Optional<String> oText = Optional.of("myText");
        String actual = oText.map(String::toString)
                .filter(s -> s.toLowerCase().endsWith("text")).orElse(null);
        String expected = "myText";
        assertEquals(expected, actual);
    }

    @Test
    public void test_optional_of_2() {
        Optional<String> oText = Optional.ofNullable(null);
        String actual = oText.map(String::toString).orElse(null);
        String expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void test_optional_of_3() {
        String name = "Kostadin";
        String actual = Optional.ofNullable(name).orElse("Default");
        String expected = "Kostadin";
        assertEquals(expected, actual);
    }

    @Test
    public void test_optional_of_4() {
        String name = "Kostadin";
        String actual = Optional.ofNullable(name).orElseGet(() -> "Default");
        String expected = "Kostadin";
        assertEquals(expected, actual);
    }


}
