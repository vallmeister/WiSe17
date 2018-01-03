import java.util.Scanner;

public class Aufgabe0134 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("f := frequence (*1.000.000.000)");
    long frequence = 1000000000 * scanner.nextLong();
    System.out.println("t := time. Set t");
    long time = scanner.nextLong();
    long maxOperations = time * frequence;
    System.out.println((long) bisection(maxOperations));
  }

  private static long fac(long n, long m) {
    if (n == 1) {
      return m;
    } else if (n == 0) {
      return m;
    }
    return fac(n - 1, m * n);
  }

  /**
   * the equation to solve is n! = f*t with bisection
   */
  private static double bisection(long product) {
    long result = 0;
    while (true) {
      long tmp = fac(result, 1);
      long tmp2 = fac(result + 1, 1);
      if (tmp < product && tmp2 > product || tmp == product) {
        break;
      }
      ++result;
    }
    return result;
  }
}
