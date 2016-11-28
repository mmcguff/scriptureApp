package edu.byui.www.spiritualthought;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Class connects to lds.org to get array of strings containing scriptures.
 *
 * This class obtains array of strings of url connections tokens, connects to
 * lds.org and obtains random scripture chapter verses.
 *
 * @author Julian Romero
 * @version 2016.1119
 * @since 1.0
 */

public class LDSScriptures {

    /**
     * Method calls Scripture Verses method
     * @return String Array with lds.org verses.
     * @throws IOException
     */
    private String[] LDSScriptures() throws IOException
    {
        return scriptureVerses();
    }

    /**
     * Method obtains random url tokens for lds.org.
     *
     * This method will obtain url tokens to obtain and return array of string
     * containing verses from random chapter of gospel from lds.org
     *
     * @return String Array with lds.org verses.
     * @throws IOException
     */
    public String[] scriptureVerses() throws IOException
    {
        GospelLibrary gl = new GospelLibrary();

        String[] lib = gl.getLibrary();
        String url = "https://www.lds.org/scriptures/"
                + lib[0]
                + "/"
                + lib[1]
                + "/"
                + lib[3]
                + "?lang=eng";
        //String url = "https://www.lds.org/scriptures/bofm/1-ne/1?lang=eng";
        Document doc = Jsoup.connect(url).get();

        String verse;

        Elements scripture = doc.select("p[class]").removeAttr("uri");
        scripture.select("span[class=verse]").remove();
        scripture.select("a[class=bookmark-anchor dontHighlight]").remove();
        scripture.select("a").unwrap();
        scripture.select("span").unwrap();
        scripture.select("sup").remove();

        String book = scripture.toString();
        String[] verses = book.split("\n");
        for (int i = 0; i < verses.length; i++) {
            verse = verses[i];
            verse = verse.substring((verse.indexOf("<p class=\"\"") + 12), verse.indexOf("</p>"));
            verses[i] = lib[2] + " " + lib[3] + ":" + (i+1) + "\n" + verse;
        }
        return verses;
    }
}
