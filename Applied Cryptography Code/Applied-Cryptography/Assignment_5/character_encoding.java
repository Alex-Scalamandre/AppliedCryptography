package Assignment_5;

import java.util.Scanner;


public class character_encoding {

    public static void encode(){
        //Create scanner to take in text input from user
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Enter the text to be encoded: ");

        //Get String input from user
        String input = scanner.nextLine();

        //Call function to clean up String input
        String cleanText = textCleanup(input);

        //Text after clean up
        System.out.println(cleanText);

        scanner.close();
    }

    public static String textCleanup(String text){
        String newText = "";

        //Remove Whitespace -- Help from: https://stackoverflow.com/questions/5455794/removing-whitespace-from-strings-in-java
        text = text.replaceAll("\\s", "");

        //Remove Punctuation -- Help from: https://stackoverflow.com/questions/18830813/how-can-i-remove-punctuation-from-input-text-in-java
        text = text.replaceAll("[^a-zA-Z ]", "");

        //Convert to lowercase
        text = text.toLowerCase();

        //Perform Shift of +4 (mod 26)
        //Loop that runs for the length of the string so that each char of the ciphertext can be accessed and shifted.
        for(int i = 0; i < text.length(); i++){
            char currentChar = text.charAt(i);
            int charValue = ((char_to_ord.charToOrd(currentChar)) % 26);
    
            //System.out.println(charValue);

            charValue += 4;

            charValue %= 26;

            char newChar = char_to_ord.charToOrd(charValue);

            newText += newChar;
        }

        text = newText;

        //Return String
        return text;
    }
}
