public class Function {
   private double a;
   private double b;
   private double c;
   private double d;

   public Function(double a, double b, double c, double d) {
      this.a = a;
      this.b = b;
      this.c = c;
      this.d = d;
   }

   public double evaluate(double x) {
      return (a * Math.pow(x, 3)) + (b * Math.pow(x, 2)) + (c * x) + d;
   }

   public Function findDerivative() {
      double derivativeA = 3 * this.a;
      double derivativeB = 2 * this.b;
      double derivativeC = this.c;
      return new Function(0, derivativeA, derivativeB, derivativeC);
   }
}
