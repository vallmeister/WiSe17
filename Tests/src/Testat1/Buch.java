package Testat1;

import java.util.Arrays;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * class Buch for exercise 1 in Testat. Buch is supposed to be a book with certain attributes.
 */
public class Buch {
  private String titel;
  private String author;
  private int pages;
  private double price;
  private int[] isbn;
  private Laendergruppe country;

  /**
   * Constructor with all parameters except country.
   * @param titel is the title of the book.
   * @param author the author of the book.
   * @param pages amount of pages.
   * @param price price in EUR.
   * @param isbn the special isbn of the book.
   */
  public Buch(String titel, String author, int pages, double price, int[] isbn) {
    this.titel = titel;
    this.author = author;
    this.pages = pages;
    this.price = price;
    this.isbn = isbn;
  }

  /**
   * setter-method for our book-class.
   * @param nation to change the book's nation into the given one.
   */
  public void setCountry(Laendergruppe nation) {
    this.country = nation;
  }

  /**
   * to get the country of a given book.
   * @param book the book we want to know where it's from.
   * @return the country-enum.
   */
  public static Laendergruppe laendergruppe(Buch book) {
    switch (book.isbn[3]){
      case 0:
        return Laendergruppe.ENGLISH;
      case 1:
        return Laendergruppe.ENGLISH;
      case 2:
        return Laendergruppe.FRENCH;
      case 3:
        return Laendergruppe.GERMAN;
      default:
        return Laendergruppe.ENGLISH;
    }
  }

  /**
   * Calculates the checksum of a given book.
   * @param isbn a given isbn of the book
   * @return the checksum.
   */
  public static int isbnChecksum(int[] isbn) {
    return (10 - ((isbn[0] + isbn[2] + isbn[3] + isbn[6] + isbn[8] + isbn[10] + 3 * (isbn[1] + isbn[3] + isbn[5]
    + isbn[7] + isbn[9] + isbn[11])) % 10)) % 10;
  }

  public int[] getIsbn() {
    return isbn;
  }

  public void setIsbn(int[] isbn) {
    this.isbn = isbn;
  }

  public String toString() {
    return "Buch" +
        "titel:'" + titel + '\'' +
        ", author:'" + author + '\'' +
        ", pages:" + pages +
        ", price:" + price +
        ", isbn:" + Arrays.toString(isbn) +
        ", country:" + country;
  }
}
