import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Algorithm sheet 8 exercise 5. Easy Dijkstra
 */
public class Dijkstra {

  /**
   * Main method.
   *
   * @param args no args given.
   */
  public static void main(String[] args) {
    BufferedReader buffrd;
    String input; // read line
    String[] inputSplit;  // splitting input into int-Strings
    int testcases;  // number of test-cases
    int vertices; // number of vertices
    int edges;  // number of edges
    int start;  // start vertices in graph
    int destination;  // destination vertices in graph
    int[][] graph;  // adjacency-matrix of given graph

    // handle input
    try {
      buffrd = new BufferedReader(new InputStreamReader(System.in));
      input = buffrd.readLine();
      testcases = Integer.parseInt(input);

      // testcase
      for (int i = 0; i < testcases; ++i) {
        input = buffrd.readLine();
        inputSplit = input.split(" ");
        vertices = Integer.parseInt(inputSplit[0]);
        edges = Integer.parseInt(inputSplit[1]);
        graph = new int[vertices][vertices];  // initializing the graph with size

        // scanning graph
        for (int j = 0; j < edges; ++j) {
          input = buffrd.readLine();
          inputSplit = input.split(" ");
          graph[Integer.parseInt(inputSplit[0])][Integer.parseInt(inputSplit[1])] = Integer.parseInt(inputSplit[3]);
          graph[Integer.parseInt(inputSplit[1])][Integer.parseInt(inputSplit[0])] = Integer.parseInt(inputSplit[3]);
        }

        // read start and destination
        input = buffrd.readLine();
        inputSplit = input.split(" ");
        start = Integer.parseInt(inputSplit[0]);
        destination = Integer.parseInt(inputSplit[1]);
        System.out.println(dijkstra(graph, start, destination));
      }
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

  /**
   * Dijkstra's shortest path algorithm.
   *
   * @param graph an int-array describing a graph due to adjacencies
   * @param startVertices starting vertices in the graph
   * @param destinationVertices destination in the graph
   * @return a String which either tells the shortest way or 'NO' if it doesn't exist
   */
  public static String dijkstra(int[][] graph, int startVertices, int destinationVertices) {
    double[] distance = new double[graph.length]; // initializing an array of our distances
    for (int i = 0; i < distance.length; ++i) {
      distance[i] = Double.POSITIVE_INFINITY;
    }
    distance[startVertices] = 0;  // in pseudo-code called l(v)
    List<Integer> toExplore = new ArrayList<>(distance.length); // in pseudo-code called W

  }
}
