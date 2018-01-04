package com.adventofcode.puzzle4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class Puzzle4 {
  public static void main(String[] args) {
    firstPart();
    secondPart();
  }

  private static void firstPart() {
    try {
      Scanner scanner = new Scanner(new File("src/resources/input"));
      int count = 0;

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] wordsArray = line.split(" ");
        Set<String> wordsSet = new HashSet<String>(Arrays.asList(wordsArray));
        if (wordsArray.length == wordsSet.size()) {
          count++;
        }
      }

      scanner.close();
      System.out.println(count);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static void secondPart() {
    try {
      Scanner scanner = new Scanner(new File("src/resources/input"));
      int count = 0;

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] wordsArray = line.split(" ");
        List<String> wordsList = new ArrayList<String>(Arrays.asList(wordsArray));
        for (int i = 0; i < wordsList.size(); i++) {
          String s = wordsList.get(i);
          String sortedString = sortString(s);
          wordsList.remove(i);
          wordsList.add(i, sortedString);
        }
        Set<String> wordsSet = new HashSet<String>(wordsList);
        if (wordsList.size() == wordsSet.size()) {
          count++;
        }
      }

      scanner.close();
      System.out.println(count);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static String sortString(String string) {
    char temp[] = string.toCharArray();
    Arrays.sort(temp);
    return new String(temp);
  }
}
