public class ConstantFunction implements MathFunction {

    private double constant;

    public ConstantFunction(double constant) {
        this.constant = constant;
    }

    @Override
    public double evaluate(double x) {
        return constant;
    }

    @Override
    public MathFunction findDerivative() {
        // The derivative of a constant is always 0
        return new ConstantFunction(0);
    }
}
