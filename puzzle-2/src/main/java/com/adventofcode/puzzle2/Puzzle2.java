package com.adventofcode.puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Puzzle2 {
  public static void main(String[] args) {
    firstPart();
    secondPart();
  }

  private static void firstPart() {
    try {
      Scanner scanner = new Scanner(new File("src/resources/input"));
      int sum = 0;
      while (scanner.hasNext()) {
        String line = scanner.nextLine();
        String[] splittedLine = line.split("\\t");
        int max = Integer.valueOf(splittedLine[0]);
        int min = Integer.valueOf(splittedLine[0]);
        for (int i = 0; i < splittedLine.length; i++) {
          max = Math.max(Integer.valueOf(splittedLine[i]), max);
          min = Math.min(Integer.valueOf(splittedLine[i]), min);
        }
        sum += (max - min);
      }

      scanner.close();
      System.out.println(sum);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static void secondPart() {
    try {
      Scanner scanner = new Scanner(new File("src/resources/input"));
      int sum = 0;
      while (scanner.hasNext()) {
        String line = scanner.nextLine();
        String[] splittedLine = line.split("\\t");
        first: for (int i = 0; i < splittedLine.length; i++) {
          for (int j = i + 1; j < splittedLine.length; j++) {
            int min =
                Math.min(Integer.valueOf(splittedLine[i]), Integer.valueOf(splittedLine[j]));
            int max =
                Math.max(Integer.valueOf(splittedLine[i]), Integer.valueOf(splittedLine[j]));
            if (max % min == 0) {
              sum += max / min;
              break first;
            }
          }
        }
      }

      scanner.close();
      System.out.println(sum);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
