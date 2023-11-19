public class Main {
   public static void main(String[] args) {
      int nmax = 100;
      double epsilon = 0.01;
      MathFunction f = new Function(2, -11.7, 17.7, -5);
      MathFunction f2 = new Function(false);
      Bisection bsA = new Bisection(f, 0, 4, nmax, epsilon);
      NewtonRaphson nrA = new NewtonRaphson(f, f.findDerivative(), 1, nmax, epsilon, 0.00001);
      FalsePosition fpA = new FalsePosition(f, 0, 4, nmax, epsilon);
      Secant scA = new Secant(f, 0, 4, nmax, epsilon);

      System.out.println("Function 1:");
      System.out.println("Bisection method:");
      bsA.solve();
      System.out.println("Newton-Raphson method:");
      nrA.solve();
      System.out.println("Secant method:");
      scA.solve();
      System.out.println("False position method:");
      fpA.solve();

      System.out.println("=============================");

      System.out.println("Function 2:");
      Bisection bsB = new Bisection(f2, 120, 130, nmax, epsilon);
      NewtonRaphson nrB = new NewtonRaphson(f2, f2.findDerivative(), 1, nmax, epsilon, 0.00001);
      Secant scB = new Secant(f2, 120, 130, nmax, epsilon);
      FalsePosition fpB = new FalsePosition(f2, 120, 130, nmax, epsilon);
      System.out.println("Bisection method:");
      bsB.solve();
      System.out.println("Newton-Raphson method:");
      nrB.solve();
      System.out.println("Secant method:");
      scB.solve();
      System.out.println("False position method:");
      fpB.solve();
   }
}