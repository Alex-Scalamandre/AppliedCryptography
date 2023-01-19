package Assignment_4;

/**
 * @author Alex Scalamandre
 * @version 2/3/2022
 */
public class affine_solution {
    public static void shiftCipher(){
        //Declare Variables
        String ciphertext = "edsgickxhuklzveqzvxwkzukcvuh";
        String plainText = "";
        int plainValue;
        int beta = 10;
        int modder = 26;
        
        //Loop that runs for the length of the string so that each char of the ciphertext can be accessed and shifted.
        for(int i = 0; i < ciphertext.length(); i++){
            char currentChar = ciphertext.charAt(i);

            int cipherValue = char_to_ord.charToOrd(currentChar);

            plainValue = ((3 * (cipherValue - beta) % modder));

            if(plainValue < 0){
                plainValue += 26;
            }

            char newChar = char_to_ord.charToOrd(plainValue);

            plainText += newChar;
        }

        System.out.println("The Plain Text Was: " + plainText);
    }
}
