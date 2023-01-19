package Assignment_5;

import java.util.*;

public class character_encoding {

    public static void encode(){

        //input
        String input = "Hello, World!";

        //Call function to clean up String input
        String cleanText = textCleanup(input);

        //Text after clean up
        System.out.println("Text after cleanup: " + cleanText);

        //Convert to Hexadecimal
        toHex(cleanText);
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

            charValue += 4;

            charValue %= 26;

            char newChar = char_to_ord.charToOrd(charValue);

            newText += newChar;
        }

        text = newText;

        //Convert to UPPERCASE
        text = text.toUpperCase();

        //Return String
        return text;
    }

    /**
     * @param text
     * @return Nothing
     */
    public static void toHex(String text){

        String hexArray[] = new String[text.length()];

        List<String> list = new ArrayList<String>();

        //Loop to convert ordinal values to hex and add them to an array in proper format.
        for(int i = 0; i < text.length(); i++){
            char currentChar = text.charAt(i);

            hexArray[i] = "0x" + Integer.toHexString(currentChar) + " ";
        }

        //Adds numbers in even positions to list first.
        for(int i = 1; i <= hexArray.length; i++){
            if((i - 1) % 2 == 0){
                list.add(hexArray[i-1]);
            }
        }

        //Then adds numbers in odd positions to list.
        for(int i = 1; i <= hexArray.length; i++){
            if((i - 1) % 2 != 0){
                list.add(hexArray[i-1]);
            }
        }

        //Convert list into new array to be able to print in groups of 5
        String[] newArray = list.toArray(new String[list.size()]);

        //Print hex values in groups of 5
        for(int i = 1; i <= newArray.length; i++){
            if(i % 5 != 0){
                    System.out.print(newArray[i - 1]);
            }else{
                    System.out.println(newArray[i - 1]);
            }
        }
    }
}
