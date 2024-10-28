package com.csc;

import java.util.ArrayList;
public class FuzzyFinder {

  public static int linearSearch(ArrayList<Fuzzy> fuzzies) {
      for (int i = 0; i < fuzzies.size(); i++) {
          if (fuzzies.get(i).color.equals("gold")) {
              return i;
          }
      }
      return -1;
  }

  public static int binarySearch(ArrayList<Fuzzy> fuzzies) {
      int left = 0;
      int right = fuzzies.size() - 1;

      while (left <= right) {
          int mid = left + (right - left) / 2;
          if (fuzzies.get(mid).color.equals("gold")) {
              return mid;
          }
          if (fuzzies.get(mid).color.compareTo("gold") < 0) {
              left = mid + 1;
          } else {
              right = mid - 1;
          }
      }
      return -1;
  }

  public static void main(String args[]) {
      FuzzyListGenerator generator = new FuzzyListGenerator();
      ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
      ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();
    
      int testOne = FuzzyFinder.linearSearch(sortedFuzzies);
      int testTwo = FuzzyFinder.binarySearch(sortedFuzzies);
      int testThree = FuzzyFinder.linearSearch(randomFuzzies);
      int testFour = FuzzyFinder.binarySearch(randomFuzzies);

      System.out.println("Linear Search in sortedFuzzies: " + testOne);
      System.out.println("Binary Search in sortedFuzzies: " + testTwo);
      System.out.println("Linear Search in randomFuzzies: " + testThree);
      System.out.println("Binary Search in randomFuzzies: " + testFour);
  }
}
