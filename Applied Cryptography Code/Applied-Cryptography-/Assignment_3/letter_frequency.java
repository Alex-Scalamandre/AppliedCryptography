package Assignment_3;

public class letter_frequency {
    public static void letterFrequency(){
        String ciphertext = "lcllewljazlnnzmvyiylhrmhza";

        //Declare count variables of each letter.
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int dCount = 0;
        int eCount = 0;
        int fCount = 0;
        int gCount = 0;
        int hCount = 0;
        int iCount = 0;
        int jCount = 0;
        int kCount = 0;
        int lCount = 0;
        int mCount = 0;
        int nCount = 0;
        int oCount = 0;
        int pCount = 0;
        int qCount = 0;
        int rCount = 0;
        int sCount = 0;
        int tCount = 0;
        int uCount = 0;
        int vCount = 0;
        int wCount = 0;
        int xCount = 0;
        int yCount = 0;
        int zCount = 0;
    
        //Loop to go through every character of the ciphertext.
        for(int i = 0; i < ciphertext.length(); i++){
            
            //If statement that determines what the character of the ciphertext is and then adds 1 to that characters count.
            if(ciphertext.charAt(i) == 'a'){
                aCount++;
            }else if(ciphertext.charAt(i) == 'b'){
                bCount++;
            }else if(ciphertext.charAt(i) == 'c'){
                cCount++;
            }else if(ciphertext.charAt(i) == 'd'){
                dCount++;
            }else if(ciphertext.charAt(i) == 'e'){
                eCount++;
            }else if(ciphertext.charAt(i) == 'f'){
                fCount++;
            }else if(ciphertext.charAt(i) == 'g'){
                gCount++;
            }else if(ciphertext.charAt(i) == 'h'){
                hCount++;
            }else if(ciphertext.charAt(i) == 'i'){
                iCount++;
            }else if(ciphertext.charAt(i) == 'j'){
                jCount++;
            }else if(ciphertext.charAt(i) == 'k'){
                kCount++;
            }else if(ciphertext.charAt(i) == 'l'){
                lCount++;
            }else if(ciphertext.charAt(i) == 'm'){
                mCount++;
            }else if(ciphertext.charAt(i) == 'n'){
                nCount++;
            }else if(ciphertext.charAt(i) == 'o'){
                oCount++;
            }else if(ciphertext.charAt(i) == 'p'){
                pCount++;
            }else if(ciphertext.charAt(i) == 'q'){
                qCount++;
            }else if(ciphertext.charAt(i) == 'r'){
                rCount++;
            }else if(ciphertext.charAt(i) == 's'){
                sCount++;
            }else if(ciphertext.charAt(i) == 't'){
                tCount++;
            }else if(ciphertext.charAt(i) == 'u'){
                uCount++;
            }else if(ciphertext.charAt(i) == 'v'){
                vCount++;
            }else if(ciphertext.charAt(i) == 'w'){
                wCount++;
            }else if(ciphertext.charAt(i) == 'x'){
                xCount++;
            }else if(ciphertext.charAt(i) == 'y'){
                yCount++;
            }else if(ciphertext.charAt(i) == 'z'){
                zCount++;
            }
        }

        //Print the results.
        System.out.println("a Amount: " + aCount);
        System.out.println("b Amount: " + bCount);
        System.out.println("c Amount: " + cCount);
        System.out.println("d Amount: " + dCount);
        System.out.println("e Amount: " + eCount);
        System.out.println("f Amount: " + fCount);
        System.out.println("g Amount: " + gCount);
        System.out.println("h Amount: " + hCount);
        System.out.println("i Amount: " + iCount);
        System.out.println("j Amount: " + jCount);
        System.out.println("k Amount: " + kCount);
        System.out.println("l Amount: " + lCount);
        System.out.println("m Amount: " + mCount);
        System.out.println("n Amount: " + nCount);
        System.out.println("o Amount: " + oCount);
        System.out.println("p Amount: " + pCount);
        System.out.println("q Amount: " + qCount);
        System.out.println("r Amount: " + rCount);
        System.out.println("s Amount: " + sCount);
        System.out.println("t Amount: " + tCount);
        System.out.println("u Amount: " + uCount);
        System.out.println("v Amount: " + vCount);
        System.out.println("w Amount: " + wCount);
        System.out.println("x Amount: " + xCount);
        System.out.println("y Amount: " + yCount);
        System.out.println("z Amount: " + zCount);
    }
}
