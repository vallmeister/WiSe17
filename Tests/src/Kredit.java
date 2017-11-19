public class Kredit {

  /**
   * Johannes task
   * @param args no needed.
   */

  public static void main(String[] args) {
    int loan = 10000;
    double interests = 10;
    interests /= 1200;
    interests += 1;
    System.out.println(interests);
    while (loan > 1000) {
      loan *= interests;
      loan -= 1000;
      System.out.println(loan);
    }
  }
}
