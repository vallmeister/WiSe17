package de.uulm.vs.grn.workshop.pizza;

import java.util.HashMap;

/*
 * Nothing to modify here.
 * Italiana is your friend. ;)
 */
public class Italiana {
    public static final int PORT_NUMBER = 9073;

    public static final int EMPLOYEE_COUNT = 4;

    public static final HashMap<String, Integer> menu = new HashMap<>();
    static {
        menu.put("Margherita", 8);
        menu.put("Hawaii", 10);
        menu.put("Luisa-Speciale", 12);
    }
}