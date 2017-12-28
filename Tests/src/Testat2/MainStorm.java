package Testat2;

import java.util.Arrays;

public class MainStorm {
  public static void main(String[] args) {
    // Aufgabe 2
    Sturm vivian = new Sturm("Vivian", "1. Februar 1990", 218, 147);
    Sturm lara = new Sturm("Lara", "5. Februar 1999", 170.3,130);
    Sturm kyrill = new Sturm("Kyrill", "18. Januar 2007", 100.7, 216);
    Sturm lothar = new Sturm("Lothar", "26. Dezember 1999", 198.2, 272);

    Sturm[] storms = {vivian, lara, kyrill, lothar};

    // Aufgabe 6
    for (int i = 0; i < storms.length; ++i) {
      storms[i].setSpeedSmph(Sturm.seemeilen(storms[i].getSpeedkm()));
      // storms[i].speedSmph = Sturm.seemeilen(storms[i].speedkm);
      storms[i].setBeaufort(Sturm.beaufortwert(storms[i].getSpeedkm()));
      storms[i].setStrength(Sturm.staerke(storms[i].getSpeedkm()));
    }

    // Aufgabe 7
    //for (int i = 0; i < storms.length; ++i) {

    //}
    System.out.println(Arrays.toString(storms).replace(",", " "));
  }
}
