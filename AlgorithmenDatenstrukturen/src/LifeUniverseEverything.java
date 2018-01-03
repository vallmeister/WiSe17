import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by cv7 on 17.10.2017. Sheet 0 from Algorithms and Data-Structures for Spox
 */
class LifeUniverseEverything {

  public static void main(String[] args) {
    BufferedReader br;
    String input;
    int number;
    try {
      br = new BufferedReader(new InputStreamReader(System.in));
      while ((input = br.readLine()) != null) {
        number = Integer.parseInt(input);
        if (number == 42) {
          break;
        }
        System.out.println(number);
      }
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }
}
