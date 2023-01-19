package Assignment_6;

public class char_to_ord {
    /**
     * @return the ordinal value of a character c.
     *         This function disregards case, but does preserve it.
     *         Ordinal values are a=0, b=1, ..., z=25
     *
     *         Preconditions: only valid characters are a-z and A-Z
     */
    public static int charToOrd(char c) {
        int value;
        if (Character.isUpperCase(c))
            value = (int) c - (int) 'A';
        else
            value = (int) c - (int) 'a';
        assert value >= 0 : "Value too low";
        assert value < 26 : "Value too large";
        return value;
    }

    /**
     * @returns the lower-case character matching the ordinal value o
     *          Ordinal values are a=0, b=1, ..., z=25
     *
     *          Preconditions: only valid values are 0-25 (inclusive)
     */
    public static char charToOrd(int o) {
        if ((o < 0) || (o > 25))
            throw new IllegalArgumentException();
        return (char) (o + (int) 'a');
    }
}
