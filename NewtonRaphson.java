public class NewtonRaphson {
   private Function f;
   private Function fPrime;
   private int nmax;
   private double x;
   private double fx;
   private double fp;
   private double epsilon;
   private double delta;

   public NewtonRaphson(Function f, Function fPrime, double x, int nmax, double epsilon, double delta) {
      this.f = f;
      this.fPrime = fPrime;
      this.x = x;
      this.nmax = nmax;
      this.epsilon = epsilon;
      this.delta = delta;
   }

   public void solve() {
      this.fx = this.f.evaluate(x);
      System.out.printf("n = 0\tx = %.4f\tfx = %.4f\n", x, fx);

      for (int n = 1; n < nmax; n++) {
         this.fp = this.fPrime.evaluate(x);
         if (Math.abs(fp) < delta) {
            System.out.println("Small derivative.");
            return;
         }

         double d = this.fx / this.fp;
         this.x = x - d;
         this.fx = this.f.evaluate(x);
         System.out.printf("n = %d\tx = %.4f\tfx = %.4f\n", n, x, fx);
         if (Math.abs(d) < epsilon) {
            System.out.println("Convergence.");
            return;
         }
      }
   }
}
