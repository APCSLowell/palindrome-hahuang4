import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public boolean palindrome(String word) {
    // Remove non-alphabetic characters and convert to lowercase
    String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
    // Get the reversed version of the cleanWord
    String reversedWord = reverse(cleanWord);
    // Check if the cleanWord equals its reversed version
    return cleanWord.equals(reversedWord);
}

public String reverse(String str) {
    StringBuilder reversed = new StringBuilder();
    // Append each character of str in reverse order to the StringBuilder
    for (int i = str.length() - 1; i >= 0; i--) {
        reversed.append(str.charAt(i));
    }
    // Convert StringBuilder to String
    return reversed.toString();
}

}
