import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Sheet 4 task 1. Christian Valenti.
 */
class Datenbankhack {

  private static String output = "";

  /**
   * main method to read input from SPOX.
   *
   * @param args no arguments.
   */
  public static void main(String[] args) {
    BufferedReader buffrd;
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
          givenKeys[j] = Integer.parseInt(buffrd.readLine());
        }
        linearHashing(givenKeys, hashtableSize, searchedKey);
        doubleHashing(givenKeys, hashtableSize, searchedKey);
        output += "\n";
        System.out.println(output);
      }
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

  private static void linearHashing(int[] keys, int hashtableSize, int searchedKey) {
    int[] hashtable = new int[hashtableSize];

    // initialise the hashtable
    for (int i = 0; i < hashtableSize; ++i) {
      hashtable[i] = -1;
    }

    // hashing
    for (int i = 0; i < keys.length; ++i) {
      int count = 0;
      while (hashtable[(keys[i] + count) % hashtableSize] != -1) {
        count++;
      }
      hashtable[(keys[i] + count) % hashtableSize] = keys[i];
      if (searchedKey == keys[i]) {
        output += (keys[i] % hashtableSize) + "\n";
      }
    }
  }

  private static void doubleHashing(int[] keys, int hashtableSize, int searchedKey) {
    int[] hashtable = new int[hashtableSize];

    // initialise the hashtable
    for (int i = 0; i < hashtableSize; ++i) {
      hashtable[i] = -1;
    }

    // hashing
    for (int i = 0; i < keys.length; ++i) {
      int count = 0;
      while (hashtable[(keys[i] + count * (1 + (keys[i] % (hashtableSize - 1)))) % hashtableSize]
          != -1) {
        count++;
      }
      hashtable[(keys[i] + count * (1 + (keys[i] % (hashtableSize - 1)))) % hashtableSize]
          = keys[i];
      if (searchedKey == keys[i]) {
        output += ((keys[i] + count * (1 + (keys[i] % (hashtableSize - 1)))) % hashtableSize)
            + "\n";
      }
    }
  }
}