package de.uulm.vs.grn.workshop.pizza.service;

import de.uulm.vs.grn.workshop.pizza.Italiana;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static de.uulm.vs.grn.workshop.pizza.Italiana.PORT_NUMBER;

/*
 * Aufgabe 2
 * Single-Threaded Server
 */
public class PizzaService {
  public static void main(String[] args) {
    try(ServerSocket socketS = new ServerSocket(88)) {
      Socket connectionSocket = socketS.accept();
      InputStream inputStream = connectionSocket.getInputStream();
      OutputStream outputStream = connectionSocket.getOutputStream();
    } catch(IOException socketException) {
      socketException.printStackTrace();
    }
  }
}