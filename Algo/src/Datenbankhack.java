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
      int hashtableSize;
      int givenKeysAmount;
      int searchedKey;
      String[] deezInts;

      // for each enterprise
      for (int i = 0; i < enterprises; ++i) {

        // reading those ints
        deezInts = buffrd.readLine().split(" ");
        hashtableSize = Integer.parseInt(deezInts[0]);
        givenKeysAmount = Integer.parseInt(deezInts[1]);
        searchedKey = Integer.parseInt(deezInts[2]);
        int[] givenKeys = new int[givenKeysAmount];

        // hashing
        for (int j = 0; j < givenKeysAmount; ++j) {
          givenKeys[j] = buffrd.read();
        }
        linearHashing(givenKeys, hashtableSize);
      }
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

  public static void linearHashing(int[] keys, int hashtableSize) {
    int[] hashtable = new int[hashtableSize];

    // hashing the keys
    for (int i = 0; i < keys.length; ++i) {
      if (hashtable[(keys[i] % hashtableSize)] != 0);
    }
  }

  public static void doubleHashing() {

  }
}
