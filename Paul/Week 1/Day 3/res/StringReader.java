package com.codegile.week1.day3.res;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StringReader {

  public static String[] getLines(String path) {
    String[] lines = new String[0];
    try {
      FileReader fis = new FileReader(path);
      BufferedReader br = new BufferedReader(fis);

      String s = br.readLine();
      while (s != null) {
        String[] aux = new String[lines.length + 1];
        System.arraycopy(lines, 0, aux, 0, lines.length);
        aux[lines.length] = s;
        lines = aux;
        s = br.readLine();
      }
      br.close();

      return lines;
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
      return null;
    }
    catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
