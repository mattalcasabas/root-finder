public class Secant {
   private MathFunction f;
   private int nmax;
   private double a;
   private double b;
   private double fa;
   private double fb;
   private double epsilon;
   private double d;

   public Secant(MathFunction f, double a, double b, int nmax, double epsilon) {
      this.f = f;
      this.a = a;
      this.b = b;
      this.nmax = nmax;
      this.epsilon = epsilon;
   }

   public void solve() {
      this.fa = this.f.evaluate(a);
      this.fb = this.f.evaluate(b);
      System.out.printf("%-5s%-18s%-12s\n", "n", "a", "fa");
      System.out.printf("=======================================================\n");

      if (fa * fb > 0) {
         double temp = a;
         a = b;
         b = temp;
         temp = fa;
         fa = fb;
         fb = temp;
      }

      System.out.printf("%-5s%-18.4f%-12.4f\n", "0", a, fa);
      System.out.printf("%-5s%-18.4f%-12.4f\n", "1", b, fb);

      for (int n = 2; n < nmax; n++) {
         if (fa * fb > 0) {
            double temp = a;
            a = b;
            b = temp;
            temp = fa;
            fa = fb;
            fb = temp;
         }

         d = (b - a) / (fb - fa);
         b = a;
         fb = fa;
         d *= fa;

         if (Math.abs(d) < epsilon) {
            System.out.println("Convergence. Exiting.");
            return;
         }

         a = a - d;
         fa = this.f.evaluate(a);
         System.out.printf("%-5d%-18.4f%-12.4f\n", n, a, fa);
      }
   }
}
