
import java.io.IOException;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Node;



/*
 * Get jsoup-1.10.1.jar from jsoup.org/download
 * Pull into 'Libraries' from downloaded location
 */

/**
 *
 * @author Julian
 */
public class ParseLDSorg {
    public static void main (String[] args) throws IOException{
        String url = "https://www.lds.org/scriptures/bofm/1-ne/1?lang=eng";
        Document doc = Jsoup.connect(url).get();
        String verse;
        
        Elements scripture = doc.getElementsByTag("p");
        //Node content = doc.childNode(1);
        String book = (scripture.toString());
        String [] verses = book.split("\n");
        for(int i = 0; i < verses.length; i++)
        {
            verse = verses[i];
            verse = verse.substring(verse.indexOf("</span>")+7);
            verse = verse.replaceAll("<sup class=\"studyNoteMarker\">a</sup>", "");
            verses[i] = verse;
        }
        for(int j = 1; j < verses.length - 3; j++)
        {
            System.out.println(j + " " + verses[j]);
        }
        //System.out.println(content.toString());
    }
}
