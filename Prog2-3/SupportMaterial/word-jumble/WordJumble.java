import java.util.Scanner;

public class WordJumble
{
  public static void jumbleWord(String word, StringBuilder builder){

    // TODO jumble words
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

    System.out.print(result);

    scanner.close();


  }
}
