package de.uulm.vs.grn.workshop.pizza.restaurant;

import de.uulm.vs.grn.workshop.pizza.Italiana;

import java.io.*;

/**
 * Aufgabe 1
 * Simple Java-Stream I/O
 */
public class OrderPizza {
  public static void main(String[] args) {
    if (args.length < 1 || !Italiana.menu.containsKey(args[0])) {
      System.err.println("Please specify a valid pizza.");
      System.err.println();
      System.err.println("Italiana Menu:");

      for (String pizza: Italiana.menu.keySet()) {
        System.err.println(" * " + pizza);
      }
      System.exit(1);
    }

    try(FileOutputStream fileOs = new FileOutputStream("bestellungen.txt")) {
      fileOs.write(args[0].getBytes());
    } catch(IOException exception) {
      exception.printStackTrace();
    }
  }
}
