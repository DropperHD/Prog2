package com.company;

import java.util.Scanner;

public class WordJumble
{
  /**
   * Bringt ein einziges Wort durcheinander
   *
   * @param word Der String der verändert werden soll. darf nicht null sein
   * @param builder Stringbuilder der das Wort dann wieder an den Text anhängt. darf auch nicht null sein
   */
  public static void jumbleWord(String word, StringBuilder builder){

    if(word == null){                                                     //Überprüft die Eingaben
      throw new IllegalArgumentException("word darf nicht null sein!");
    }

    if(builder == null){
      throw new IllegalArgumentException("builder darf nicht null sein!");
    }

    if(word.length()<3){
      builder.append(word);
      return;
    }                                            
    StringBuilder sb = new StringBuilder(word);  //zweiter Stringbuilder um das Wort zu verändern
    for(int i = 1; i < word.length()-2;i+=2){    //Es wird vom zweiten Buchstaben bis zum vor-vorletzen durchgegangen
      sb.insert(i+2,sb.charAt(i));               //Da es immer in Zweierpaaren passiert,wird zuerst der erste Buchstabe
      sb.deleteCharAt(i);                        //nach dem zweiten kopiert und dann der Orginale gelöscht
    }
    word = sb.toString();                        //sb.toString gibt dann den veräderten String aus und kopiert diesen wieder in word
    builder.append(word);                        //am Ende wird an das Wort an den veränderten Text angehängt
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
