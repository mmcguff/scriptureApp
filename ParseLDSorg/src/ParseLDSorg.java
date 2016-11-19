
import java.io.IOException;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;



/*
 * Get jsoup-1.10.1.jar from jsoup.org/download
 * Pull into 'Libraries' from downloaded location
 * @author Julian
 */
public class ParseLDSorg {
    public static void main (String[] args) throws IOException{
        
        String url = "https://www.lds.org/scriptures/bofm/1-ne/6?lang=eng";
        Document doc = Jsoup.connect(url).get();
        String verse;
        
        Elements scripture = doc.select("p[class]").removeAttr("uri");
        scripture.select("a[class=bookmark-anchor dontHighlight]").remove();
        scripture.select("a").unwrap();
        scripture.select("span").remove();
        scripture.select("sup").remove();
        String book = scripture.toString();
        String [] verses = book.split("\n");
        for (int i = 0; i < verses.length; i++) {
            verse = verses[i];
            verse = verse.substring((verse.indexOf("<p class=\"\"")+12),verse.indexOf("</p>"));
            verses[i] = verse;
        }
        for(int j = 0; j < verses.length; j++)
        {
            System.out.println(j+1 + " " + verses[j]);
        }
    }
}
