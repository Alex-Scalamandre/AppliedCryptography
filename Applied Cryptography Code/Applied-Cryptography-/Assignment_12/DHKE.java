package Assignment_12;

// import java.math.BigDecimal;
import java.math.BigInteger;

public class DHKE{
    /**
     * Calculates Alice's public key.
     * @param alpha (BigInteger)
     * @param p (BigInteger)
     * @param aliceInput (String)
     * @return alicePub
     */
    public static BigInteger alicePub(BigInteger alpha, BigInteger p, String aliceInput){
        
        String hexString = aliceInput.substring(2);

        BigInteger alicePriv = new BigInteger(hexString, 16);

        BigInteger alicePub = alpha.modPow(alicePriv, p);

        return alicePub;
    }

    /**
     * Calculates Bob's public key.
     * @param alpha (BigInteger)
     * @param p (BigInteger)
     * @param bobInput (String)
     * @return bobPub
     */
    public static BigInteger bobPub(BigInteger alpha, BigInteger p, String bobInput){
        
        String hexString = bobInput.substring(2);

        BigInteger bobPriv = new BigInteger(hexString, 16);

        BigInteger bobPub = alpha.modPow(bobPriv, p);

        return bobPub;
    }

    /**
     * @param bobPub (BigInteger)
     * @param alicePriv (String) -- String representation of Alice's private key.
     * @param p (BigInteger)
     * @return shared -- String representation of Alice's shared key.
     */
    public static String aliceShared(BigInteger bobPub, String alicePriv, BigInteger p){
        // Alice Shared
        String format = alicePriv.substring(2);
        BigInteger alicePrivate = new BigInteger(format, 16);

        BigInteger aliceShared = bobPub.modPow(alicePrivate, p);
        String shared = aliceShared.toString(16);
        return shared;
    }

    /**
     * @param alicePub (BigInteger)
     * @param bobPriv (String) -- String representation of Bob's private key.
     * @param p (BigInteger)
     * @return shared -- String representation of Bob's shared key.
     */
    public static String bobShared(BigInteger alicePub, String bobPriv, BigInteger p){
        // Bob shared
        String format = bobPriv.substring(2);
        BigInteger bobPrivate = new BigInteger(format, 16);

        BigInteger bobShared = alicePub.modPow(bobPrivate, p);
        String shared = bobShared.toString(16);
        return shared;
    }

    /**
     * @param p (BigInteger)
     * @return The amount of bits within p
     */
    public static int bitCount(BigInteger p){
        return p.bitLength();
    }

    public static void main(String[] args){
        // Convert p from String to BigInteger
        String pInitial = "0x00fb2e8473c499d184d806e6b5df7f621b";
        String pFormatted  = pInitial.substring(2); // Cut off 0x
        BigInteger p = new BigInteger(pFormatted, 16);

        // Alice and Bob's private keys
        String aliceString = "0x2ca50afea541f0d90f68e0efc85c2686";

        String bobString = "0x6e146d3b2149f41450713e5c83d21e70";

        // Alpha
        BigInteger alpha = new BigInteger("2");

        // Count amount of bits in p
        int bitCount = bitCount(p);

        // Calculate public keys
        BigInteger alicePub = alicePub(alpha, p, aliceString);
        BigInteger bobPub = bobPub(alpha, p, bobString);

        // Calculate shared keys
        String aliceShared = aliceShared(bobPub, aliceString, p);
        String bobShared = bobShared(alicePub, bobString, p);

        // Print results
        System.out.println("Bit count of p: " + bitCount);
        System.out.println("Shared key A: " + aliceShared);
        System.out.println("Shared key B: " + bobShared);
    }
}