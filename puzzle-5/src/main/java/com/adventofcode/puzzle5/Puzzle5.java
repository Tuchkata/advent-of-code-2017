package com.adventofcode.puzzle5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Puzzle5 {
  public static void main(String[] args) {
    firstPart();
    secondPart();
  }

  private static void firstPart() {
    try {
      List<Integer> steps = parseInput();
      System.out.println(solve(steps, true));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static void secondPart() {
    try {
      List<Integer> steps = parseInput();
      System.out.println(solve(steps, false));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static int solve(List<Integer> steps, boolean isFirstPart) {
    int count = 0;
    int index = 0;
    while (index >= 0 && index < steps.size()) {
      int step = steps.get(index);
      int increase = calculateIncreaseValue(isFirstPart, step);
      steps.set(index, step + increase);
      index += step;
      count++;
    }
    return count;
  }

  private static int calculateIncreaseValue(boolean isFirstPart, int step) {
    if (isFirstPart) {
      return 1;
    } else {
      return step >= 3 ? -1 : 1;
    }
  }

  private static List<Integer> parseInput() throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("src/resources/input"));
    List<Integer> steps = new ArrayList<Integer>();
    while (scanner.hasNextLine()) {
      steps.add(Integer.parseInt(scanner.nextLine()));
    }
    scanner.close();
    return steps;
  }
}
