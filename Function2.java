public class Function2 {
    private double x;

    public Function2(double x) {
        this.x = x;
    }

    public double evaluate() {
        return this.x + 10 - this.x * Math.cosh(50/this.x);
    }

    public double findDerivative() {
        // f'(x) = 1 + sinh(50/x) - (50/x) * x * sinh(50/x)

        return 1 + (Math.sinh(50 / this.x)) - (50 / this.x) * this.x * Math.sinh(50 / this.x);
    }
}
