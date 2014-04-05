import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

@RunWith(JUnit4.class)
public class CalculatorTest {
    private Calculator calc = new Calculator();

    @Test
    public void acceptsDigits() {
        calc.digit('3');
        calc.digit('7');
        assertEquals(37, calc.getDisplay());
    }

    @Test(expected=IllegalArgumentException.class)
    public void refusesNonDigitChars() {
        calc.digit(' ');
    }

    @Test
    public void exceptionMessageContainsIllegalChar() {
        // This is an alternative approach to testing for an exception, useful
        // if you need to verify details of the exception that was thrown.
        try {
            calc.digit('@');
            fail("Expected exception");
        } catch(IllegalArgumentException e) {
            assertNotEquals(-1, e.getMessage().indexOf('@'));  // -1 would signal "not found"
        }
    }

    @Test
    public void startsWithZero() {
        assertEquals(0, calc.getDisplay());
    }

    @Test
    public void handlesAddition() {
        // We are testing several things here: not just addition, but also clearing
        // the displayed number after plus() only when the next digit is input.
        // It's a matter of taste whether and when to split this into two test cases.

        calc.digit('1');
        calc.digit('2');
        calc.plus();
        assertEquals(12, calc.getDisplay());
        calc.digit('5');
        assertEquals(5, calc.getDisplay());
        calc.digit('6');
        calc.result();
        assertEquals(68, calc.getDisplay());
    }

    @Test
    public void handlesSubtraction() {
        calc.digit('1');
        calc.digit('2');
        calc.minus();
        calc.digit('5');
        calc.digit('6');
        calc.result();
        assertEquals(12 - 56, calc.getDisplay());
    }
}
