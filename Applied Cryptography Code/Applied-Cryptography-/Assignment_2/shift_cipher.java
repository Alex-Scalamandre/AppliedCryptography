package Assignment_2;

/**
 * @author Alex Scalamandre
 * @version 2/3/2022
 */
public class shift_cipher {
    public static void shiftCipher(){
        //Declare Variables
        //String ciphertext = "ycvejqwvhqtdtwvwu";
        String ciphertext = "lcllewljazlnnzmvyiylhrmhza";
        String newText = "";
        
        //Loop that will perform the shift 25 times so that every char in the ciphertext can be shifted 25 times.
        for (int j = 0; j < 25; j++){
            newText = "";
            
            //Loop that runs for the length of the string so that each char of the ciphertext can be accessed and shifted.
            for(int i = 0; i < ciphertext.length(); i++){
                char currentChar = ciphertext.charAt(i);
                int charValue = char_to_ord.charToOrd(currentChar);
                if(charValue >= 25){
                    charValue = 0;
                    char newChar = char_to_ord.charToOrd(charValue);
                    newText += newChar;
                }else{
                    charValue = char_to_ord.charToOrd(currentChar);
                    charValue++;
                    char newChar = char_to_ord.charToOrd(charValue);
                    newText += newChar;
                }
                
            }

            //Reset the ciphertext back to empty for the next String.
            ciphertext = "";

            //Set the ciphertext to be the new attempt at finding the plaintext.
            ciphertext = newText;
            
            //Print the new ciphertext after the shift.
            System.out.println(ciphertext);
        }
    }
}
