public class Main {
   public static void main(String[] args) {
      int nmax = 100;
      double epsilon = 0.01;
      Function f = new Function(2, -11.7, 17.7, -5);
      Bisection bsA = new Bisection(f, 0, 4, nmax, epsilon);
      NewtonRaphson nrA = new NewtonRaphson(f, f.findDerivative(), 1, nmax, epsilon, 0.00001);
      Secant scA = new Secant(f, 0, 4, nmax, epsilon);
      System.out.println("Bisection method:");
      bsA.solve();
      System.out.println("Newton-Raphson method:");
      nrA.solve();
      System.out.println("Secant method:");
      scA.solve();
   }
}
