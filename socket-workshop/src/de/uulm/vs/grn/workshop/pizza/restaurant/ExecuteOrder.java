package de.uulm.vs.grn.workshop.pizza.restaurant;

import de.uulm.vs.grn.workshop.pizza.Italiana;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Aufgabe 1
 */
public class ExecuteOrder {
  public static void main(String[] args) throws InterruptedException {
    String orderedPizza = "";
    try(FileInputStream fileIS = new FileInputStream("bestellungen.txt")) {
      byte[] data = new byte[1024];
      int length = fileIS.read(data);
      System.out.println(orderedPizza = new String(data, 0, length));
    } catch(IOException exception) {
      exception.printStackTrace();
    }
    if(!Italiana.menu.containsKey(orderedPizza)) {
      System.out.println("Your order is valid");
    } else {
      System.out.println("Your order is being prepared");
      Thread.sleep(Italiana.menu.get(orderedPizza) * 1000);
      System.out.println("Your order is ready");
    }
  }
}
