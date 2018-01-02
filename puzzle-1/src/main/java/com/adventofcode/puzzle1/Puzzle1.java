package com.adventofcode.puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Puzzle1 {
  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner(new File("src/resources/input"));
      String input = scanner.nextLine();
      scanner.close();

      firstPart(input);
      secondPart(input);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static void firstPart(String input) {
    System.out.println(findSum(input, 1));
  }

  public static void secondPart(String input) {
    System.out.println(findSum(input, input.length() / 2));
  }

  private static int findSum(String input, int nextIndex) {
    int result = 0;

    for (int i = 0; i < input.length(); i++) {
      int next = (i + nextIndex) % input.length();
      if (input.charAt(i) == input.charAt(next)) {
        result += Character.getNumericValue(input.charAt(i));
      }
    }

    return result;
  }
}
