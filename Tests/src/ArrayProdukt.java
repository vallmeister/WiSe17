import java.util.Arrays;

public class ArrayProdukt {

  private static int[] array1 = {1, 2, 3, 4, 5, 6, 7};
  /**
   * task for Hummler.
   */
  public static void main(String[] args) {
    int[] result = produkte();
    System.out.println(Arrays.toString(result));
  }

  /**
   * getting the product.
   */
  private static int[] produkte() {
    int[] result = new int[array1.length];
    for (int i = 0; i < array1.length; ++i) {
      int product = 1;
      for (int j = 0; j < array1.length; ++j) {
        if (j == i) {
          continue;
        }
        product *= array1[j];
      }
      result[i] = product;
    }
    return result;
  }
}
