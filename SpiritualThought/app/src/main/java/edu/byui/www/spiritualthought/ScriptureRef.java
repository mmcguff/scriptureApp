package edu.byui.www.spiritualthought;

import java.io.IOException;
import java.util.Random;

/**
 * Class obtains scripture verse array and returns a random one.
 *
 * This class obtains string array of online verses and returns a random verse.
 *
 * @author Julian Romero, Daniel Chunn, Mitchell Harvey, Matthew McGuff
 * @version 2016.11.25
 * @since 1.0
 */
public class ScriptureRef {
    private LDSScriptures verses = new LDSScriptures();

    private String[] mScriptures = verses.scriptureVerses();

    /**
     * This method obtains an array of strings with scriptures.
     * Throws and exceptions if connection to lds.org fails.
     *
     * @throws IOException
     */
    public ScriptureRef() throws IOException {
    }
    //fields (member variables)
    /*private String[] mScriptures = {
            "If ye love me, Keep my Commandments.",
            "And my Father dwelt in a Tent.",
            "Jesus Wept.",
            "...Wickedness never was happiness",
            "...Ye shall know the truth and the truth shall set you free",
            "This is my work and my glory to bring to pass the immortality and eternal life of man",
            "By the power of the holy ghost ye may know the truth of all things",
            "In the beginning God created the heavens and the earth",
            "...When thou are converted, strengthen thy brethren",
            "Thy will be done." };
*/

    //Methods - actions the object can take

    /**
     * This method returns random scripture text.
     * @return String with verses.
     */
    public String getScripture(){

        String scripture;

        //randomly select a scripture.
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mScriptures.length);
        scripture = mScriptures[randomNumber];

        return scripture;
    }

}
