package CeaserCipher;

import java.util.Scanner;

public class CeaserCipher {
    // This rotates a character k-positions

    private String mText;
    private int mShift;

    public CeaserCipher(String mText, int mShift) {
        this.mText = mText;
        this.mShift = mShift;
    }

    public String getText() {
        return mText;
    }

    public int getShift() {
        return mShift;
    }

    public static char cipher(char c, int k) {
        //Here we declare some helping constants
        final int alphaLength = 26;
        final char asciiShift = Character.isUpperCase(c) ? 'A' : 'a';
        final int cipherShift = k % alphaLength;

        // we shift down to 0..25 for a..z
        char shifted = (char) (c - asciiShift);

        // Here we rotate the letter and handle "wrap-around" for negatives and value >= 26
        shifted = (char) ((shifted + cipherShift + alphaLength) % alphaLength);

        // Here we shift back up to english characters
        return (char) (shifted + asciiShift);
    }

    // Here we Rotate a string k-positions
    public  String cipher() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mText.length(); i++) {
            if(mText.charAt(i) == ' ')
            {
                sb.append(" ");
            }
            else
            {
                sb.append(cipher(mText.charAt(i), mShift));
            }

        }
        return sb.toString();
    }
}

