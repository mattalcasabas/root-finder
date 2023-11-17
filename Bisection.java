public class Bisection {
   private int nmax;
   private double a;
   private double b;
   private double c;
   private double fa;
   private double fb;
   private double fc;
   private double error;
   private double epsilon;
   private Polynomial f;

   public Bisection(Polynomial f, double a, double b, int nmax, int epsilon) {
      this.f = f;
      this.a = a;
      this.b = b;
      this.nmax = nmax;
      this.epsilon = epsilon;
   }

   public void solve() {
      this.fa = this.f.evaluate(a);
      this.fb = this.f.evaluate(b);
      if (fa * fb > 0) {
         System.out.println("Function has same signs at a and b. Exiting.");
         System.exit(1);
      }
      this.error = this.b - this.a;
      for (int n = 0; n < this.nmax; n++) {
         this.error = this.error / 2;
         this.c = this.a + this.error;
         this.fc = this.f.evaluate(c);
         System.out.printf("n = %d\tc = %.4f\tfc = %.4f\terror = %.4f\n", n, c, fc, error);
         if (Math.abs(error) < this.epsilon) {
            System.out.println("Convergence. Exiting.");
            System.exit(1);
         }
         if (fa * fc > 0) {
            this.b = this.c;
            this.fb = this.fc;
         } else {
            this.a = this.c;
            this.fa = this.fc;
         }
      }
   }

}
