import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;

public class RalParser {


    private static Document getPage() throws IOException {
        String url= "https://www.ral-farben.de/content/anwendung-hilfe/all-ral-colours-names/overview-ral-classic-colours/";
        //String url = "http://pogoda.spb.ru/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static void main(String[] args) throws IOException {
        // System.out.println(getPage());
        Document page = getPage();
        // css query language
        Element tableCont = page.select("div[id=content]").first();
       // Element tableCont = page.select("table[class=wt]").first();
        System.out.println(tableCont);
        String name;
        System.out.println("RAL     name    .jpg");

    }
}
