import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Suche {

  private static int maximum;
  private static int result;

  /**
   * Exercise 1.1 from SPOX in Algorithms.
   */
  public static void main(String[] args) {
    String input;
    BufferedReader buffReader;
    try {
      buffReader = new BufferedReader(new InputStreamReader(System.in));
      if ((input = buffReader.readLine()) != null) {
        if (!analyze(input)) {
          System.err.println("undefined");
        } else {
          System.out.println(result);
        }
      }
    } catch (IOException standardException) {
      standardException.printStackTrace();
    }
  }

  /**
   * Analyze is supposed to find the largest number in the String. If it doesn't exist, it returns false.
   */
  private static boolean analyze(String toAnalyze) {
    boolean hasMaximum = false;
    boolean hasResult = false;
    boolean hasCharacter;
    int temp;
    String[] wordsToBeTested = toAnalyze.split(" ");
    for (int i = 0; i < wordsToBeTested.length; ++i) {
      hasCharacter = false;
      for (int j = 0; j < wordsToBeTested[i].length(); ++j) {
        if (((int) (wordsToBeTested[i].charAt(j))) >= 65) {
          hasCharacter = true;
        }
      }
      if (hasCharacter) {
        continue;
      }
      if (!hasMaximum) {
        maximum = Integer.parseInt(wordsToBeTested[i]);
        hasMaximum = true;
      } else {
        if (!hasResult) {
          result = Integer.parseInt(wordsToBeTested[i]);
          hasResult = true;
          if (result > maximum) {
            temp = maximum;
            maximum = result;
            result = temp;
          }
        } else {
          temp = Integer.parseInt(wordsToBeTested[i]);
          if (temp > maximum) {
            result = maximum;
            maximum = temp;
          } else if (temp < maximum && temp > result) {
            result = temp;
          }
        }
      }
    }
    return hasResult;
  }
}