package edu.grinnell.csc207.experiments;

import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.function.Predicate;

import edu.grinnell.csc207.util.SearchUtils;

/**
 * Assorted experiments for searching structures.
 *
 * @author Your Name Here
 * @author Your Name Here
 * @author Samuel A. Rebelsky (starter code)
 */
public class SearchExperiments {
  /**
   * Run our experimens.
   *
   * @param args
   *   Command-line arguments. Ignored.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    String[] tmp =
        new String[] { "alpha", "bravo", "charlie", "delta", "echo",
                       "foxtrot", "golf", "hotel", "india",
                       "juliett", "kilo", "lima", "mike",
                       "november", "oscar", "papa", "quebec",
                       "romeo", "sierra", "tango", "uniform",
                       "victor", "whiskey", "xray", "yankee", "zulu" };
    ArrayList<String> strings = new ArrayList<String>(Arrays.asList(tmp));

    Predicate<String> lessThanFour = (str) -> (str.length() < 5);
    String ex1c = SearchUtils.search(strings, lessThanFour);
    pen.println("The first string of four lettters is " + ex1c);

    try {
      String ex1g = SearchUtils.search(strings, (s) -> s.length() == 6);
      pen.println("The first string of exactly six letters is " + ex1g);
    } catch (Exception e) {
      pen.println("There are no strings of exactly six letters.");
    } // try/catch

    Predicate<String> containsU = (str) -> (str.contains("u"));
    String ex2c = SearchUtils.search(strings, containsU);
    pen.println("The first string that contains the letter u is: " + ex2c);

    // We do not think that the search method will work on the tmp array of strings since it is not an iterable.
    // String ex3c = SearchUtils.search(tmp, containsU);

    pen.close();
  } // main(String[])
} // class SearchUtils
