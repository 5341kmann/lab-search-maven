package edu.grinnell.csc207;

import java.util.Arrays;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.util.SearchUtils;

/**
 * Tests of our search methods.
 *
 * @author Your Name Here
 * @author Your Name Here
 * @author Samuel A. Rebelsky
 */
public class TestSearch {
  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * A string version of a call to binary search.
   *
   * @param values
   *   The array.
   * @param val
   *   The value we're searching for.
   *
   * @return
   *   The string "binarySearch(values, val)"
   */
  String bsCall(int[] values, int val) {
    return String.format("binarySearch(%s, %d)", Arrays.toString(values), val);
  } // bsCall

  /**
   * Assert that a search for a particular value finds the value at that
   * index.
   *
   * @param expected
   *   The expected index.
   * @param values
   *   The array we're searching.
   * @param val
   *   The value we're searching for.
   */
  void assertBinarySearchFinds(int expected, int[] values, int val) 
      throws Exception {
    assertEquals(expected, SearchUtils.binarySearch(values, val),
        () -> bsCall(values, val));
  } // assertBinarySearchFinds(int, int[], int)

  /**
   * Assert that a search for a particular value fails (hopefully, because 
   * the value * is not in the array).
   *
   * @param values
   *   The array we're searching.
   * @param val
   *   The value we're searching for.
   */
  void assertBinarySearchFails(int[] values, int val) throws Exception {
    assertThrows(Exception.class,
        () -> SearchUtils.binarySearch(values, val),
        () -> bsCall(values, val));
  } // assertBinarySearchFails()

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * Searching the empty array should fail.
   */
  @Test
  void testBinarySearchEmpty() throws Exception {
    assertBinarySearchFails(new int[] { }, 0);
  } // testSearchEmpty()

  /**
   * Searching in a one-element array.
   */
  @Test
  void testBinarySearchOne() throws Exception {
    assertBinarySearchFinds(0, new int[] { 5 }, 5);
    assertBinarySearchFails(new int[] { 5 }, 0);
    assertBinarySearchFails(new int[] { 5 }, 10);
  } // testBinarySearchOne()

  /**
   * Searching in a two-element array.
   */
  @Test
  void testBinarySearchTwo() throws Exception {
    assertBinarySearchFinds(0, new int[] { 7, 11 }, 7);
    assertBinarySearchFinds(1, new int[] { 7, 11 }, 11);
    assertBinarySearchFails(new int[] { 7, 11 }, 0);
    assertBinarySearchFails(new int[] { 7, 11 }, 10);
    assertBinarySearchFails(new int[] { 7, 11 }, 20);
  } // testBinarySearchTwo()

  @Test
  void ourTests() throws Exception{
    assertBinarySearchFinds( 0, new int[] {0, 1, 2}, 0);
    assertBinarySearchFinds( 0, new int[] {0, 1, 2}, -0);
    assertBinarySearchFinds(1, new int[] {0, 1, 2}, 1);
    assertBinarySearchFinds(2,  new int[] {0, 1, 2}, 2);
    
    // Failures
    assertBinarySearchFails(null, 0);
  }

  @Test
  void ourTests2() throws Exception {
  //   For each s from 1 to 32
  // Create an array of size s, containing the values 0, 2, 4, ... 2*(s-1)
  // For all i from 0 to s-1, inclusive
  //     // Make sure that value 2*i is in position i
  //     assert(binarySearch(2*i, array) == i)
  //     // Make sure that odd values are not in the array
  //     assertException(binarySearch(2*i+1, array))
  // assertException(binarySearch(-1, array))
    for (int s = 1; s < 33; s++) {
      int[] arr = new int[s];
      for (int i = 0; i < s; i++) {
        arr[i] = (2 * i);
      }
      for (int i = 0; i <= s - 1; i++) {
        assert(SearchUtils.binarySearch(arr, 2*i) == i);
        assertBinarySearchFails(arr, 2*i+1);
      }
      assertBinarySearchFails(arr, -1);
    }
  }
} // class TestSearch
