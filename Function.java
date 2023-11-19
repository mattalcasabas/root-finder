
public class Function implements MathFunction {

    private double a;
    private double b;
    private double c;
    private double d;

    private boolean isPolynomial; // Flag to determine the type of function

    public Function(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.isPolynomial = true;
    }

    public Function(boolean isPolynomial) {
        this.isPolynomial = isPolynomial;
    }

    @Override
    public double evaluate(double x) {
        if (isPolynomial) {
            // Polynomial function evaluation
            return (a * Math.pow(x, 3)) + (b * Math.pow(x, 2)) + (c * x) + d;
        } else {
            // Custom function evaluation
            return x + 10 - x * Math.cosh(50 / x);
        }
    }

    @Override
    public MathFunction findDerivative() {
        if (isPolynomial) {
            // Polynomial function derivative
            double derivativeA = 3 * this.a;
            double derivativeB = 2 * this.b;
            double derivativeC = this.c;
            return new Function(derivativeA, derivativeB, derivativeC, 0);
        } else {
            // Custom function derivative
            return new CustomFunctionDerivative();
        }
    }

    private class CustomFunctionDerivative implements MathFunction {
        @Override
        public double evaluate(double x) {
            // Derivative calculation for the custom function
            return -Math.cosh(50 / x) + Math.sinh(50 / x) * (50 / x) * x;
        }

        @Override
        public MathFunction findDerivative() {
            // You can continue adding derivatives for more complex functions if needed
            return new ConstantFunction(0);
        }
    }
}

