import org.junit.Test;
import static org.junit.Assert.*;

public class StringCalculatorTest {
    @Test
    public void testAdd_EmptyString_ReturnsZero() {
        StringCalculator calc = new StringCalculator();
        assertEquals(0, calc.add(""));
    }

    @Test
    public void testAdd_SingleNumber_ReturnsNumber() {
        StringCalculator calc = new StringCalculator();
        assertEquals(1, calc.add("1"));
    }

    @Test
    public void testAdd_TwoNumbers_ReturnsSum() {
        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.add("1,2"));
    }

    @Test
    public void testAdd_MultipleNumbers_ReturnsSum() {
        StringCalculator calc = new StringCalculator();
        assertEquals(10, calc.add("1,2,3,4"));
    }

    @Test
    public void testAdd_NewLineDelimiter_ReturnsSum() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1\n2,3"));
    }

    @Test
    public void testAdd_CustomDelimiter_ReturnsSum() {
        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.add("//;\n1;2"));
    }

    @Test
    public void testAdd_NegativeNumber_ThrowsException() {
        StringCalculator calc = new StringCalculator();
        try {
            calc.add("1,-2,3");
            fail("Exception expected");
        } catch (IllegalArgumentException e) {
            assertEquals("negative numbers not allowed -2", e.getMessage());
        }
    }

    @Test
    public void testAdd_MultipleNegatives_ThrowsExceptionWithAllNegatives() {
        StringCalculator calc = new StringCalculator();
        try {
            calc.add("-1,2,-3");
            fail("Exception expected");
        } catch (IllegalArgumentException e) {
            assertEquals("negative numbers not allowed -1,-3", e.getMessage());
        }
    }
}
