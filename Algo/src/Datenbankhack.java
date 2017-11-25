import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Sheet 4 task 1. Christian Valenti.
 */
class Datenbankhack {

  /**
   * main method to read input from SPOX.
   * @param args no arguments.
   */
  public static void main(String[] args) {
    BufferedReader buffrd;
    String input;
    int enterprises;

    // try to read input
    try {
      buffrd = new BufferedReader(new InputStreamReader(System.in));
      enterprises = Integer.parseInt(buffrd.readLine());
      int hashtable;
      int givenKeysAmount;
      int searchedKey;
      String[] deezInts;

      // for each enterprise
      for (int i = 0; i < enterprises; ++i) {

        // reading those ints
        deezInts = buffrd.readLine().split(" ");
        hashtable = Integer.parseInt(deezInts[0]);
        givenKeysAmount = Integer.parseInt(deezInts[1]);
        searchedKey = Integer.parseInt(deezInts[2]);

        // hashing
        for (int j = 0; j < givenKeysAmount; ++j) {

        }

      }
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }
}
