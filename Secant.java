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
      System.out.printf("n\ta\t\tfa\t");
      System.out.printf("\n=======================================================\n");

      if (fa * fb > 0) {
         double temp = a;
         a = b;
         b = temp;
         temp = fa;
         fa = fb;
         fb = temp;
      }

      System.out.printf("0\t%.4f\t%.4f\n", a, fa);
      System.out.printf("1\t%.4f\t%.4f\n", b, fb);

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
         System.out.printf("%d\t%.4f\t%.4f\n", n, a, fa);
      }
   }
}
