import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RaParserSecond {

    private static Document getPage() throws IOException {
        String url= "https://www.magasindepeinture.ch/en/ral-color-chart.html";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }
// \w{3}\s\d{4}
    private static Pattern pattern = Pattern.compile("\\w{3}\\s\\d{4}");

    private static String getRalFromString(String StringRal) throws Exception {
        Matcher matcher = pattern.matcher(StringRal);
        if(matcher.find()){
            return matcher.group();
        }
        throw new Exception("Can't extract rals from string");
    }

    public static void main(String[] args) throws Exception {
        Document page = getPage();
        Element tableCont = page.select("table[width=912]").first();
        Elements rals = tableCont.select("span");
       // System.out.println(rals);

        for (Element ral : rals){
            String nameRal = ral.select("span").text();
           String ralS = getRalFromString(nameRal);
            System.out.println(ralS);
        }

    }
}
