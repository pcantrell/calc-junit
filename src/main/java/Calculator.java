
public class Calculator {
    private int display, accumulator;
    private boolean additionPending, subtractionPending, clearOnNextDigit;

    public void digit(char c) {
        if(c < '0' || c > '9')
            throw new IllegalArgumentException("Expected digit (0-9), but got " + c);

        if(clearOnNextDigit) {
            display = 0;
            clearOnNextDigit = false;
        }
        display = display * 10 + c - '0';
    }

    public int getDisplay() {
        return display;
    }

    public void plus() {
        accumulator = display;
        additionPending = true;
        clearOnNextDigit = true;
    }

    public void minus() {
        accumulator = display;
        subtractionPending = true;
        clearOnNextDigit = true;
    }

    public void result() {
        if(additionPending) {
            display += accumulator;
            additionPending = false;
        }
        if(subtractionPending) {
            display = accumulator - display;
            subtractionPending = false;
        }
    }
}
