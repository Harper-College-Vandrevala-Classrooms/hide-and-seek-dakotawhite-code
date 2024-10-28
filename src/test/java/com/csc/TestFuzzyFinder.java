package com.csc;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFuzzyFinder {

  FuzzyFinder finder;
  FuzzyListGenerator generator;

  @BeforeEach
  void setUp() {
    finder = new FuzzyFinder();
    generator = new FuzzyListGenerator();
  }

  @Test
  void testLinearSearchOnSortedList() {
      ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
      int index = FuzzyFinder.linearSearch(sortedFuzzies);
      assertTrue(index != -1, "'gold' should be found.");
      assertEquals("gold", sortedFuzzies.get(index).color);
  }

  @Test
  void testLinearSearchOnRandomList() {
      ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();
      int index = FuzzyFinder.linearSearch(randomFuzzies);
      assertTrue(index != -1, "'gold' should be found.");
      assertEquals("gold", randomFuzzies.get(index).color);
  }

  @Test
  void testBinarySearchOnSortedList() {
      ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
      int index = FuzzyFinder.binarySearch(sortedFuzzies);
      assertTrue(index != -1, "'gold' should be found.");
      assertEquals("gold", sortedFuzzies.get(index).color);
  }

  @Test
  void testBinarySearchOnRandomizedList() {
      ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();
      int index = FuzzyFinder.binarySearch(randomFuzzies);
      assertEquals(-1, index);
  }
}