import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Christian Valenti 959042. Algorithmen sheet 6 SPOX task.
 */
class Taschengeld {

  /**
   * main method of application.
   *
   * @param args no arguments needed.
   */
  public static void main(String[] args) {
    String input; // read lines
    String[] toMaximum; // splitting input and calculate the maximum
    String[] toMinimum; // " " minimum
    BufferedReader buffrd;  // used to read SPOX-input
    int tests;  // amount of cases to be calculated

    // read input
    try {
      buffrd = new BufferedReader(new InputStreamReader(System.in));
      input = buffrd.readLine();
      tests = Integer.parseInt(input);

      // iterating the procedure for each test case
      for (int i = 0; i < tests; ++i) {
        input = buffrd.readLine();

      }
    } catch (IOException noInput) {
      noInput.printStackTrace();
    }
  }
}
