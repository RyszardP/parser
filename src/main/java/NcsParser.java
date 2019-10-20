import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NcsParser {

    private static Document getPage() throws IOException {
        String url= "https://www.magasindepeinture.ch/en/ncs-color-chart-online.html";
        //String url = "http://pogoda.spb.ru/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    private static Pattern pattern = Pattern.compile("(.*)(\\d+)(.*)");

    private static String getNcsFromString(String StringNcs) throws Exception {
        Matcher matcher = pattern.matcher(StringNcs);
        if(matcher.find()){
            return matcher.group();
        }
        throw new Exception("Can't extract ncs from string");
    }

    public static void main(String[] args) throws Exception {

        //System.out.println(getPage()); // print all page
        Document page = getPage();
        Element tableCont = page.select("table[width=920]").first(); // find table
        Elements ncsS = tableCont.select("span");
       // System.out.println(ncsS);

        for (Element element : ncsS){
            String nameNcs = element.select("span").text();
            String ncsNamesS = getNcsFromString(nameNcs);
            System.out.println(ncsNamesS);

        }
    }

}