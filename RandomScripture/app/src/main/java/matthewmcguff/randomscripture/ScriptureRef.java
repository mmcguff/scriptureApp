package matthewmcguff.randomscripture;
import android.util.Log;

import java.io.IOException;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;

import java.util.Random;

public class ScriptureRef {
    private String url;
    private String[] mScriptures;

    private Document doc;

    public ScriptureRef() throws IOException{
        setScriptureArray();
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


    public void setScriptureArray() {
        try {
            url = "https://www.lds.org/scriptures/bofm/1-ne/1?lang=eng";

            doc = Jsoup.connect(url).get();
        } catch(IOException e){e.printStackTrace();}

        Elements eScripture = doc.getElementsByTag("p");

        String book = (eScripture.toString());


        String[] vScriptures = book.split("\n");
        mScriptures = vScriptures;

        for (String script : vScriptures) {
            Log.i("Jsoup", script);
        }
    }

    //Methods - actions the object can take
    public String getScripture(){

        String scripture;

        //randomly select a scripture.
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mScriptures.length);
        scripture = mScriptures[randomNumber];

        return scripture;
    }

}
