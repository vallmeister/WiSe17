import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Christian Valenti.
 */
class MarathonMovement {

  /**
   * This class is for the marathon task in spox. It counts the amount of overtakings.
   *
   * @param args is supposed to be empty.
   */
  public static void main(String[] args) {
    BufferedReader buffrd;
    int marathons;
    int runners;
    int[] startPositions;
    int[] finishPositions;

    //read input
    try {
      buffrd = new BufferedReader(new InputStreamReader(System.in));
      marathons = Integer.parseInt(buffrd.readLine());

      //set variables
      for (int i = 0; i < marathons; ++i) {
        runners = Integer.parseInt(buffrd.readLine());
        startPositions = new int[runners];
        String[] splittedStarters = buffrd.readLine().split(" ");

        //putting the position-integers from String-array to int-array
        for (int j = 0; j < runners; ++j) {
          startPositions[j] = Integer.parseInt(splittedStarters[j]);
        }

        finishPositions = new int[runners];
        String[] splittedFinishers = buffrd.readLine().split(" ");
        for (int k = 0; k < runners; ++k) {
          finishPositions[k] = Integer.parseInt(splittedFinishers[k]);
        }
        getInversions(startPositions, finishPositions);
      }
    } catch (IOException except) {
      except.printStackTrace();
    }
  }

  /**
   * Counting the inversions of 2 arrays.
   *
   * @param start is int-array with start positions of runners.
   * @param finish is int-array with finish positions of runners.
   */
  private static void getInversions(int[] start, int[] finish) {
    int startInversions = 0;
    int finishInversions = 0;

    //counting the inversions at the beginning.
    for (int i = 0; i < (start.length - 1); ++i) {
      for (int j = i + 1; j < start.length; ++j) {
        if (start[i] > start[j]) {
          startInversions++;
        }
      }
    }

    //counting the inversions in the end.
    for (int i = 0; i < (finish.length - 1); ++i) {
      for (int j = i + 1; j < finish.length; ++j) {
        if (finish[i] > finish[j]) {
          finishInversions++;
        }
      }
    }
    System.out.println("at least " + Math.abs(finishInversions - startInversions)
        + " overtaking(s)");
  }
}
