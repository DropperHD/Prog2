package com.company;

import java.util.Scanner;

public class WordJumble
{
  public static void jumbleWord(String word, StringBuilder builder){

    if(word == null){
      throw new IllegalArgumentException();
    }

    if(word.length()<3){
      builder.append(word);
      return;
    }
    StringBuilder sb = new StringBuilder(word);
    int length = word.length();
    for(int i = 1; i < length-2;i+=2){
      sb.insert(i+2,sb.charAt(i));
      sb.deleteCharAt(i);
    }
    word = sb.toString();
    builder.append(word);
  }

  public static String jumbleText(Scanner scanner){

    StringBuilder builder = new StringBuilder();
    while (scanner.hasNext()){
      String word = scanner.next();
      jumbleWord(word, builder);
      builder.append(" ");
    }
    return builder.toString();
  }

  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    String result = jumbleText(scanner);
    scanner.close();
  }
}
