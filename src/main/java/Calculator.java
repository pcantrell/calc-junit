
public class Calculator {
    private int display, accumulator;
    private boolean clearOnNextDigit;
    private Operator pendingOperator;

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
        operator(Operator.PLUS);
    }

    public void minus() {
        operator(Operator.MINUS);
    }

    private void operator(Operator op) {
        accumulator = display;
        pendingOperator = op;
        clearOnNextDigit = true;
    }

    public void result() {
        if(pendingOperator != null) {
            display = pendingOperator.apply(accumulator, display);
            pendingOperator = null;
        }
    }

    private static enum Operator {
        PLUS {
            @Override
            public int apply(int accumulator, int display) {
                return accumulator + display;
            }
        },
        MINUS {
            @Override
            public int apply(int accumulator, int display) {
                return accumulator - display;
            }
        };

        public abstract int apply(int accumulator, int display);
    }
}
