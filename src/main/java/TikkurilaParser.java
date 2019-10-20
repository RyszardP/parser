import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TikkurilaParser {
    private static Document getPage() throws IOException {
        String url = "https://kraskadoma.ru/tablica-cvetov/katalog-cvetov-tikkurila-simfoniya/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    private static Pattern pattern = Pattern.compile("\\w{1}\\d{3}");

    private static String getTikkurilaFromString(String StringTikkurila) throws Exception {
        Matcher matcher = pattern.matcher(StringTikkurila);
        if (matcher.find()) {
            return matcher.group();
        }
        throw new Exception("Can't extract tikkurila from string");
    }

    private static void printAllValues(Elements values, int index){
        for (int i = 0; i < 3000; i++){
            Element valueLine = values.get(index);
        }
    }

    public static void main(String[] args) throws Exception {
        Document page = getPage();
        //System.out.println(page);
        Element tableCont = page.select("div[class=container]").first(); // find table
        //  System.out.println(tableCont);
        Elements tikNumbers = tableCont.select("td[width=8%]"); // tikkurila numbers in table
        //  System.out.println(tikNumbers);
        int index = 0;
        for (Element tikkurila : tikNumbers) {
            String nameTikkurila = tikkurila.select("small").text();
            String tikkurilaNames = getTikkurilaFromString(nameTikkurila);
            System.out.println(tikkurilaNames);
          //  printAllValues(tikNumbers, index);
        }


    }
}
