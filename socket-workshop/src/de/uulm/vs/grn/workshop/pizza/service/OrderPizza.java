package de.uulm.vs.grn.workshop.pizza.service;

import de.uulm.vs.grn.workshop.pizza.Italiana;

import java.net.Socket;

/*
 * Aufgabe 2
 * Single-Threaded Server
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
    // open a Socket connection to the Socket in PizzaService
    // and place a order
    //try(Socket socket = new Socket("Pizza-socket", 88)) {

    //}
  }
}