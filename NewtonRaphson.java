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
      System.out.printf("%-5s%-18s%-12s\n", "n", "x", "fx");
      System.out.printf("=======================================================\n");
      System.out.printf("%-5s%-18.4f%-12.4f\n", "0", x, fx);

      for (int n = 1; n < nmax; n++) {
         this.fp = this.fPrime.evaluate(x);
         if (Math.abs(fp) < delta) {
            System.out.println("Small derivative.");
            return;
         }

         double d = this.fx / this.fp;
         this.x = x - d;
         this.fx = this.f.evaluate(x);
         System.out.printf("%-5d%-18.4f%-12.4f\n", n, x, fx);
         if (Math.abs(d) < epsilon) {
            System.out.println("Convergence.");
            return;
         }
      }
   }
}
