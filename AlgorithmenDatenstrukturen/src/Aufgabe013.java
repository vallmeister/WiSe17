import java.util.Scanner;

/**
 * This algorithm is supposed to calculate the values of sheet 1 exercise 3, because I need a
 * special calculator and I don't have it. Nevertheless, I decided to program my own function I need
 * for this task in Java.
 */
public class Aufgabe013 {

  /**
   * main scans parameters and returns solution.
   * @param args no arguments needed.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("f := frequence, number of operations per second.\nDefine f.");
    long frequence = scanner.nextLong();
    frequence *= 1000000000;
    System.out.println("t := time.\nDefine t.");
    long time = scanner.nextLong();
    long maxOperations = time * frequence;
    double result = nLog2n(maxOperations);
    System.out.println("Result:\n" + (long) result);
    scanner.close();
  }

  /**
   * This function solves n * log(n) = f * t with bisection.
   * @param operations the number of operations per second.
   * @return n := result.
   */
  private static double nLog2n(long operations) {
    double upperLimit = 2 * operations;
    double lowerLimit = 1;
    double bisection = (upperLimit + lowerLimit) / 2;
    double result;

    do {
      if (bisection * Math.log10(bisection) / Math.log10(2.0d) == operations) {
        result = bisection;
        break;
      } else if (bisection * Math.log10(bisection) / Math.log10(2.0d) > operations) {
        upperLimit = bisection;
        bisection = (upperLimit + lowerLimit) / 2;
      } else if (bisection * Math.log10(bisection) / Math.log10(2.0d) < operations) {
        lowerLimit = bisection;
        bisection = (lowerLimit + upperLimit) / 2;
      }
    } while (true);
    return result;
  }
}

