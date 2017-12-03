import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class WoSteigtDieParty {  // In meiner Hose

  /**
   * Author: Christian Valenti. Sheet 5 Spox
   * @param args no arguments needed.
   */
  public static void main(String[] args) {
    BufferedReader buffrd;
    String[] input; // to read and split the input-strings
    int streets;  // amount of streets for (n,n)-matrix
    int friends;  // amount of friends who wanna visit the party
    int[][] friendsHomes; // array to save the friends' addresses

    // read input
    try {
      buffrd = new BufferedReader(new InputStreamReader(System.in));
      input = buffrd.readLine().split(" ");
      streets = Integer.parseInt(input[0]);
      friends = Integer.parseInt(input[1]);
      friendsHomes = new int[2][friends]; // initializing friend-table (2, friends) - matrix

      // saving addresses
      for (int i = 0; i < friends; ++i) {
        input = buffrd.readLine().split(" ");
        friendsHomes[0][i] = Integer.parseInt(input[0]);
        friendsHomes[1][i] = Integer.parseInt(input[1]);
      }

      // getting the area in which all friends live
      int minimumX = streets;
      int maximumX = 0;
      int minimumY = streets;
      int maximumY = 0;

      // getting minimum and maximum x
      for (int i = 0; i < friends; ++i) {
        if (minimumX > friendsHomes[0][i]) { // finding the minimum position x
          minimumX = friendsHomes[0][i];
        }
        if (maximumX < friendsHomes[0][i]) {
          maximumX = friendsHomes[0][i];
        }
      }

      // getting minimum and maximum y
      for (int i = 0; i < friends; ++i) {
        if (minimumY > friendsHomes[1][i]) {
          minimumY = friendsHomes[1][i];
        }
        if (maximumY < friendsHomes[1][i]) {
          maximumY = friendsHomes[1][i];
        }
      }

      // simulating the area
      int xSize = maximumX - minimumX;
      int ySize = maximumY - minimumY;
      int[][] friendsArea = new int[xSize][ySize];  // array of the friends' district

      // getting average positions
      /*int averageX = getAverage(friendsHomes[0]);
      int averageY = getAverage(friendsHomes[1]);

      // getting distances
      int[] distances = new int[4];
      int positionInDistances = 0;
      for (int i = 0; i < 2; ++i) {
        for (int j = 0; j < 2; ++j) {
          distances[positionInDistances] = getDistance(friendsHomes, averageX + i,
              averageY + j);
          ++i;
        }
      }*/
      int[] distances = new int[xSize * ySize];
      int countPositioninDistances = 0;
      for (int i = 0; i < xSize; ++i) {
        for (int j = 0; j < ySize; ++j) {
          distances[countPositioninDistances] = getDistance(friendsHomes, i + minimumX,
              j + minimumY);
          countPositioninDistances++;
        }
      }

      // output
      try {
        /*int minimumDistance = getMinimum(distances);
        for (int i = 0; i < 4; ++i) {
          if (minimumDistance == distances[i]) {
            switch (i) {
              case 0:
                System.out.println(averageX  + " " + averageY );
                break;
              case 1:
                System.out.println(averageX + " " + (averageY + 1));
                break;
              case 2:
                System.out.println((averageX + 1) + " " + averageY );
                break;
              case 3:
                System.out.println(averageX + 1 + " " + (averageY + 1));
                break;
            }
          }
        }*/
        int minimumDistance = getMinimum(distances);
        for (int i = 0; i < distances.length; ++i) {
          if (distances[i] == minimumDistance) {
            int xPosition = i % xSize;
            int yPosition = i / ySize;
            System.out.println(xPosition + " " + yPosition);
          }
        }
      }catch (IndexOutOfBoundsException noFriends) {
        System.out.println("Error: You have no friends.");
      }
    } catch (IOException noStream) {
      noStream.printStackTrace();
    }
  }

  /**
   * function to get an average of given numbers.
   * @param numbers int array with numbers.
   * @return the average of these numbers.
   */
  private static int getAverage(int[] numbers) {
    int sum = 0;
    for (int i = 0; i < numbers.length; ++i) {
      sum += numbers[i];
    }
    return (sum / numbers.length);
  }

  /**
   * function to get the distance between points
   * @param points array of points to be tested.
   * @param positionX x-position to compare
   * @param positionY y-position to compare
   * @return the sum of all distances between the points in array and x-y-point
   */
  private static int getDistance(int[][] points, int positionX, int positionY) {
    int friends = points[0].length;
    int distance = 0;
    for (int i = 0; i < friends; ++i) {
      distance += (Math.abs(points[0][i] - positionX) + Math.abs(points[1][i] - positionY));
    }
    return distance;
  }

  /**
   * function to find the smallest element of a set.
   * @param elements array of the set
   * @return the minimum of this set
   * @throws IndexOutOfBoundsException if set is empty
   */
  private static int getMinimum(int[] elements) throws IndexOutOfBoundsException{
    int minimum = elements[0];
    for (int i = 1; i < elements.length; ++i) {
      if (minimum < elements[i]) {
        minimum = elements[i];
      }
    }
    return minimum;
  }
}
