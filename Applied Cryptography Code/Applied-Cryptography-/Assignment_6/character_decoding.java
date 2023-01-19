package Assignment_6;

import java.util.*;

public class character_decoding {
    public static void decode(){
        //Input is +4 shifted Hello World with even positions first and odd following.
        String input = "0x4C 0x50 0x53 0x53 0x50 0x49 0x50 0x41 0x56 0x48";

        System.out.println("The input was: " + input);

        System.out.println("");
        
        String[] newArray = originalFormat(input);

        //Loop to print values of newArray -- Used during testing
        // System.out.println("Values of newArray are: ");
        // for(int i = 0; i < newArray.length; i++){
        //     System.out.print(newArray[i] + " ");
        // }

        int[] hexArray = performShift(newArray);

        //Loop to print out values of hexArray -- Used during testing
        // System.out.println("Values of hexArray are: ");
        // for(int i = 0; i < hexArray.length; i++){
        //     System.out.print(hexArray[i] + " ");
        // }

        String lowString = toLow(hexArray);

        String finalString = toFinal(lowString);
        
        displayString(finalString);
    }

    public static String[] originalFormat(String input){
        //Help from -- https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
        String[] splitString = input.trim().split("\\s+");

        //Find number of even values
        int numOfEvens = splitString.length / 2;

        //Create array for odd positions
        String[] oddArray = new String[splitString.length - numOfEvens];

        //Create array of even positions
        String[] evenArray = new String[numOfEvens];

        //List for even and odd positions in correct order
        List<String> list = new ArrayList<String>(); 
        
        //Loop to put the even position values into array
        for(int i = 0; i < numOfEvens; i++){
            evenArray[i] = splitString[i];
        }

        //Loop to put odd position values into array
        for(int i = numOfEvens; i < numOfEvens * 2; i++){
            oddArray[i - numOfEvens] = splitString[i];
        }

        //First add numbers in even positions to list.
        for(int i = 1; i <= evenArray.length; i++){
            list.add(evenArray[i-1].substring(2));
            list.add(oddArray[i-1].substring(2));
        }

        //Create new array with original format of the word
        String[] newArray = list.toArray(new String[list.size()]);

        return newArray;
    }

    public static int[] performShift(String[] newArray){
        //Create an int array to capture the int values of the hex strings
        int[] hexArray = new int[newArray.length];

        //Loop to change hex strings to integers and then shift -4
        for(int i = 0; i < newArray.length; i++){
            hexArray[i] = (Integer.parseInt(newArray[i], 16));
        }

        //Return array
        return hexArray;
    }

    public static String toLow(int[] hexArray){
        StringBuilder finalString = new StringBuilder("");
        String fString = "";

        for(int i = 0; i < hexArray.length; i++){
            finalString.append((char) hexArray[i]);
            fString = finalString.toString().toLowerCase();
        }

        return fString;
    }

    public static String toFinal(String lowString){
        String finalString = "";

        for(int i = 0; i < lowString.length(); i++){
            char newChar;
            char currentChar = lowString.charAt(i);

            int charValue = ((char_to_ord.charToOrd(currentChar)) % 26);

            charValue -= 4;

            if(charValue < 0){
                charValue = charValue + 26;
                newChar = char_to_ord.charToOrd(charValue);
            }else{
                newChar = char_to_ord.charToOrd(charValue);
            }

            

            finalString += newChar;
        }

        return finalString.toUpperCase();
    }

    public static void displayString(String finalString){
        System.out.println("The Original String was: ");
        for(int i = 0; i < finalString.length(); i++){
            System.out.print(finalString.charAt(i) + " ");
        }
        
    }
}