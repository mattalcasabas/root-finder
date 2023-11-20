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
   private MathFunction f;

   public Bisection(MathFunction f, double a, double b, int nmax, double epsilon) {
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
         System.out.println("Function has same signs at a and b.");
         return;
      }
      this.error = this.b - this.a;
      System.out.printf("n\tc\t\tfc\terror");
      System.out.printf("\n=======================================================\n");
      for (int n = 0; n < this.nmax; n++) {
         this.error = this.error / 2;
         this.c = this.a + this.error;
         this.fc = this.f.evaluate(c);
         System.out.printf("%d\t%.4f\t%.4f\t%.4f\n", n, c, fc, error);
         if (Math.abs(error) < this.epsilon) {
            System.out.println("Convergence");
            return;
         }
         if (fa * fc < 0) {
            this.b = this.c;
            this.fb = this.fc;
         } else {
            this.a = this.c;
            this.fa = this.fc;
         }
      }
   }

}
