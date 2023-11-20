public class NewtonRaphson {
   private MathFunction f;
   private MathFunction fPrime;
   private int nmax;
   private double x;
   private double fx;
   private double fp;
   private double epsilon;
   private double delta;

   public NewtonRaphson(MathFunction f, MathFunction fPrime, double x, int nmax, double epsilon, double delta) {
      this.f = f;
      this.fPrime = fPrime;
      this.x = x;
      this.nmax = nmax;
      this.epsilon = epsilon;
      this.delta = delta;
   }

   public void solve() {
      this.fx = this.f.evaluate(x);
      System.out.printf("n\tx\t\tfx\t");
      System.out.printf("\n=======================================================\n");
      System.out.printf("0\t%.4f\t%.4f\n", x, fx);

      for (int n = 1; n < nmax; n++) {
         this.fp = this.fPrime.evaluate(x);
         if (Math.abs(fp) < delta) {
            System.out.println("Small derivative.");
            return;
         }

         double d = this.fx / this.fp;
         this.x = x - d;
         this.fx = this.f.evaluate(x);
         System.out.printf("%d\t%.4f\t%.4f\n", n, x, fx);
         if (Math.abs(d) < epsilon) {
            System.out.println("Convergence.");
            return;
         }
      }
   }
}
