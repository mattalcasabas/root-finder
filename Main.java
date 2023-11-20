public class Main {
   public static void main(String[] args) {
      int nmax = 100;
      double epsilon = 0.01;
      MathFunction f = new Function(2, -11.7, 17.7, -5);
      MathFunction f2 = new Function(false);

      System.out.println("Function 1:");

      int intA = 0;
      int intB = 4;

      Bisection bsA = new Bisection(f, intA, intB, nmax, epsilon);
      NewtonRaphson nrA = new NewtonRaphson(f, f.findDerivative(), intA, nmax, epsilon, 0.00001);
      FalsePosition fpA = new FalsePosition(f, intA, intB, nmax, epsilon);
      Secant scA = new Secant(f, intA, intB, nmax, epsilon);

      System.out.println("Bisection method:");
      bsA.solve();
      System.out.println("Newton-Raphson method:");
      nrA.solve();
      System.out.println("Secant method:");
      scA.solve();
      System.out.println("False position method:");
      fpA.solve();

      System.out.println("\n=======================================================\n");

      System.out.println("Function 2:");

      intA = 120;
      intB = 130;

      Bisection bsB = new Bisection(f2, intA, intB, nmax, epsilon);
      NewtonRaphson nrB = new NewtonRaphson(f2, f2.findDerivative(), intA, nmax, epsilon, 0.00001);
      Secant scB = new Secant(f2, intA, intB, nmax, epsilon);
      FalsePosition fpB = new FalsePosition(f2, intA, intB, nmax, epsilon);

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