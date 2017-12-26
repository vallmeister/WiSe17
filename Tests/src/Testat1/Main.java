package Testat1;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] isbn1 = {9, 7, 8, 3, 4, 9, 9, 2, 6, 7, 0, 3, - 1};
    Buch halbesJahr = new Buch("Ein ganzes halbes Jahr", "Jojo Moyes", 512, 17.99, isbn1);
    int[] isbn2 = {9, 7, 8, 0, 6, 7, 4, 3, 4, 1, 1, 6, - 1};
    Buch gameTheory = new Buch("Game Theory: Analysis of Conflict", "Roger Myerson", 584, 12.49,
        isbn2);
    int[] isbn3 = {9, 7, 8, 0, 4, 5, 1, 2, 1, 0, 6, 3, - 1};
    Buch caseNeed = new Buch("A Case of Need", "Michael Crichton", 416, 45.20, isbn3);
    int[] isbn4 = {9, 7, 8, 3, 4, 2, 3, 3, 3, 0, 7, 1, - 1};
    Buch botschaften = new Buch("Geheime Botschaften", "Klaus Fritz", 460, 35.99, isbn4);
    Buch[] library = {halbesJahr, gameTheory, caseNeed, botschaften};

    // exercise 5
    for (int i = 0; i < library.length; ++i) {
      library[i].setCountry(Buch.laendergruppe(library[i]));
      int[] temp = library[i].getIsbn();
      temp[12] = Buch.isbnChecksum(library[i].getIsbn());
      library[i].setIsbn(temp);
    }

    // exercise 6 intuitively
    for (int i = 0; i < library.length; ++i) {
      System.out.println(library[i].toString());
    }

    // exercise 6 more elegantly
    System.out.println(Arrays.toString(library));
  }
}
