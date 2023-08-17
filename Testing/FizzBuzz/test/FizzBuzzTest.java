import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static junit.framework.TestCase.assertEquals;

public class FizzBuzzTest {

    @Test
    @DisplayName("Testing FizzBuzz")
    public void testFizzBuzz() {
        int number = 26;
        String expected = "hai sáu";

        FizzBuzz fizzBuzz = new FizzBuzz(number);
        String result = fizzBuzz.checkFizzBuzz();
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing FizzBuzz")
    public void testFizz() {
        int number = 37;
        String expected = "Fizz";

        FizzBuzz fizzBuzz = new FizzBuzz(number);
        String result = fizzBuzz.checkFizzBuzz();
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing FizzBuzz")
    public void testFizzDivide() {
        int number = 33;
        String expected = "Fizz";

        FizzBuzz fizzBuzz = new FizzBuzz(number);
        String result = fizzBuzz.checkFizzBuzz();
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing FizzBuzz")
    public void testBuzz() {
        int number = 52;
        String expected = "Buzz";

        FizzBuzz fizzBuzz = new FizzBuzz(number);
        String result = fizzBuzz.checkFizzBuzz();
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing FizzBuzz")
    public void testBuzzDivide() {
        int number = 25;
        String expected = "Buzz";

        FizzBuzz fizzBuzz = new FizzBuzz(number);
        String result = fizzBuzz.checkFizzBuzz();
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing FizzBuzz")
    public void testFizzBuzz53() {
        int number = 53;
        String expected = "BuzzFizz";

        FizzBuzz fizzBuzz = new FizzBuzz(number);
        String result = fizzBuzz.checkFizzBuzz();
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing FizzBuzz")
    public void testFizzBuzz35() {
        int number = 35;
        String expected = "FizzBuzz";

        FizzBuzz fizzBuzz = new FizzBuzz(number);
        String result = fizzBuzz.checkFizzBuzz();
        assertEquals(expected, result);
    }
}

