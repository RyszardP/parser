package colors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class WcpParser {
    private static Document getPage() throws IOException {
        String url = "https://kupebox.ru/materials/krashenye-fasady-tsvetovaya-gamma-ral-i-wood-color/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static void main(String[] args) throws Exception {
        Document page = getPage();
       System.out.println(page);
        Element tableCont = page.select("div[class=prodGrid_cell]").first(); // find table
        System.out.println(tableCont);
       // Elements wcpS = tableCont.select("span");
       // System.out.println(wcpS);
    }
}
