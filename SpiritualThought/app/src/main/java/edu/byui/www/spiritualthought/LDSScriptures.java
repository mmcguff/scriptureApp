package edu.byui.www.spiritualthought;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.EOFException;
import java.io.IOException;

/**
 * Created by Julian on 11/19/2016.
 */

public class LDSScriptures {

    private String[] LDSScriptures() throws IOException
    {
        return scriptureVerses();
    }

    public String[] scriptureVerses() throws IOException
    {
        String url = "https://www.lds.org/scriptures/ot/zeph/1?lang=eng";
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
            verses[i] = verse;
        }
        return verses;
    }
}
