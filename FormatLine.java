// Zheng Hong Tan
// Date: 02/22/17
//
// This program reads in user input or a given file and formats the lines to be
// at most 80 characters per line for the use of method header comments. It 
// includes the forward slashes as part of its output. It produces this output 
// on an "output.txt" file.

import java.util.*;     // for Scanner class
import java.io.*;       // for PrintStream class

public class FormatLine {
   public static final int TAB_WIDTH = 3;
   public static final int STARTING_CHARS = TAB_WIDTH + 2;

   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      Scanner input;
      PrintStream output = new PrintStream(new File("output.txt"));
      
      displayIntro();
      System.out.print("Enter file/text to format lines: ");
      String text = console.nextLine();
      if (text.substring(text.length() - 4, text.length()).equals(".txt")) {
         input = new Scanner(new File(text));
      } else {
         input = new Scanner(text);
      }
      System.out.println();
      format(input, output);   
   }

   // Displays an introduction of the program to the user.       
   public static void displayIntro() {
      System.out.println("This program formats text from user input or from a");
      System.out.println("file to at most 80 characters per line (including");
      System.out.println("the backslashes) for the use of method header");
      System.out.println("comments to the \"output.txt\" file.");
      System.out.println();      
   }   
   
   // Takes in a Scanner object and prints lines in the format of 80 characters 
   // per line to the given output. 
   public static void format(Scanner input, PrintStream output) {
      String word = input.next();
      printTabSpaces(output);
      output.print("// " + word);
      int count = STARTING_CHARS + word.length() + 1;
      
      while (input.hasNext()) {
         word = input.next();
         count += word.length() + 1;
          
         if (count > 80) { 
            output.println(); 
            printTabSpaces(output);          
            output.print("// " + word);
            count = STARTING_CHARS + word.length() + 1;
         } else {
            output.print(" " + word);
         }   
      } 
   }
   
   // Prints the tab spaces to the given output. 
   public static void printTabSpaces(PrintStream output) {
      for (int i = 0; i < TAB_WIDTH; i++) {
         output.print(" ");
      }
   }             
} 