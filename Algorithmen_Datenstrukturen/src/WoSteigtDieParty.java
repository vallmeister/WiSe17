import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * task 5 from Spox, author Christian Valenti.
 */
class WoSteigtDieParty {  // In meiner Hose

  /**
   * main method for application.
   * @param args no arguments needed.
   */
  public static void main(String[] args) {
    BufferedReader buffrd;
    String[] input; // first line for streets and friends
    int streets;  // amount streets of squarecity
    int friends;  // amount of friends
    int[][] friendsCoordinates; // coordinates of friends' homes

    // read input
    try {
      buffrd = new BufferedReader(new InputStreamReader(System.in));
      input = buffrd.readLine().split(" ");  // first line
      streets = Integer.parseInt(input[0]);
      friends = Integer.parseInt(input[1]);
      friendsCoordinates = new int[2][friends];

      // get friends' positions
      for (int i = 0; i < friends; ++i) {
        input = buffrd.readLine().split(" ");
        friendsCoordinates[0][i] = Integer.parseInt(input[0]);
        friendsCoordinates[1][i] = Integer.parseInt(input[1]);
      }



      /* get area where friends live
      int maxX = getMaximum(friendsCoordinates[0]);
      int minX = getMinimum(friendsCoordinates[0]);
      int maxY = getMaximum(friendsCoordinates[1]);
      int minY = getMinimum(friendsCoordinates[1]);

      //int[] checkPoint = getPositions(streets, friendsCoordinates, minX, maxX, minY, maxY);
      //System.out.println(checkPoint[1] + " " + checkPoint[2]);

      int minDistance = 3 * streets;
      int checkpoint1 = 0;
      int checkpoint2 = 0;
      for (int i = 1; i < 2001; ++i) {
        for (int j = 1; j < 2001; ++j) {
          int distance = getDistance(friendsCoordinates, i, j);
          if (minDistance > distance) {
            minDistance = distance;
            checkpoint1 = i;
            checkpoint2 = j;
          }
        }
      }
      System.out.println(checkpoint1 + " " + checkpoint2);*/
      int[] solution = {1, 1, getDistance(friendsCoordinates, 1, 1)};  // x, y, distance
      long currentDistance = solution[2];
      long minDistance = currentDistance;
      int countx = 1;
      int county = 1;
      while (!(countx == 2000 && county == 2000)) {
        countx++;
        if (countx > 2000) {
          countx = 1;
          county++;
        }
        currentDistance += 2 * (countx * county - 1) - friends;
        if (currentDistance < minDistance) {
          minDistance = currentDistance;
          solution[0] = countx;
          solution[1] = county;
        }
      }
      System.out.println(solution[0] + " " + solution[1] + " " + minDistance);
    } catch (IOException missingStream) {
      missingStream.printStackTrace();
    }
  }

  /**
   * Getting the minimum of a given set.
   * @param set integer-array
   * @return minimum integer of set
   */
  private static int getMinimum(int[] set) {
    int minimum = set[0];
    for (int i = 1; i < set.length; ++i) {
      if (minimum > set[i]) {
        minimum = set[i];
      }
    }
    return minimum;
  }

  /**
   * Getting the maximum of given set.
   * @param set integer-array
   * @return maximum integer of set
   */
  private static int getMaximum(int[] set) {
    int maximum = set[0];
    for (int i = 1; i < set.length; ++i) {
      if (maximum < set[i]) {
        maximum = set[i];
      }
    }
    return maximum;
  }

  /**
   * Getting the position to solve the problem.
   * @param streets amount of streets in squarecity
   * @param coordinates coordinates to check
   * @param minX start position in x-direction
   * @param maxX stop position ""
   * @param minY start position "" y ""
   * @param maxY stop "" "" ""
   * @return integer array with 2 ints, first is the x-coordinate and second is the y-coordinate
   */
  private static int[] getPositions(int streets, int[][] coordinates, int minX, int maxX, int minY,
      int maxY) {
    int[] minDistance = {3 * streets, - 1, - 1};  // integer array to save the x, y and the distance
    for (int i = minY; i <= maxY; ++i) {  // going through the city in x-Direction
      for (int j = maxX; j >= minX; --j) {  // going through the city in y-Direction
        int distance = getDistance(coordinates, i, j);
        if (minDistance[0] > distance) {
          minDistance[1] = i;
          minDistance[2] = j;
          minDistance[0] = distance;
        }
      }
    }
    return minDistance;
  }

  /**
   * Getting the sum of all distances between a given point and several other points.
   * @param coordinates integer array with given points to check
   * @param xPos the x-position
   * @param yPos y-position
   * @return the whole distance between (x,y) and all coordinates
   */
  private static int getDistance(int[][] coordinates, int xPos, int yPos) {
    int distance = 0;
    for (int i = 0; i < coordinates[0].length; ++i) {
      distance += (Math.abs(coordinates[0][i] - xPos) + Math.abs(coordinates[1][i] - yPos));
    }
    return distance;
  }

  private static int getAverage(int[] set) {
    int elements = set.length;
    int sum = 0;
    for (int i = 0; i < elements; ++i) {
      sum += set[i];
    }
    return sum / elements;
  }
}