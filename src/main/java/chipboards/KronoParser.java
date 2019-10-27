package chipboards;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;

public class KronoParser {
    private static Document getPage() throws IOException {
        String url= "https://viyar.ua/catalog/dsp_kronospan/?view=60";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static void main(String[] args) throws IOException {
        Document page = getPage();
        System.out.println(page);
      //  Element tableCont = page.select("div[id=content]").first();
      //  System.out.println(tableCont);
    }
}
