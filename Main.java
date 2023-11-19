public class Main {
   public static void main(String[] args) {
      int nmax = 100;
      double epsilon = 0.01;
      double x = 0;
      MathFunction f = new Function(2, -11.7, 17.7, -5);
      Function2 f2 = new Function2(x);
      Bisection bsA = new Bisection(f, 0, 4, nmax, epsilon);
      NewtonRaphson nrA = new NewtonRaphson(f, f.findDerivative(), 1, nmax, epsilon, 0.00001);
      Secant scA = new Secant(f, 0, 4, nmax, epsilon);

      System.out.println("Function 1:\n");
      System.out.println("Bisection method:");
      bsA.solve();
      System.out.println("Newton-Raphson method:");
      nrA.solve();
      System.out.println("Secant method:");
      scA.solve();

      // System.out.println("Function 2:\n");
      // Bisection bsB = new Bisection(f2, 0, 4, nmax, epsilon);
      // NewtonRaphson nrB = new NewtonRaphson(f2, f2.findDerivative(), 1, nmax, epsilon, 0.00001);
      // Secant scB = new Secant(f2, 0, 4, nmax, epsilon);

   }
}
