import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        GsonBuilder builder = new GsonBuilder();//Set up for JSON
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        String url = "https://github.com/egis/handbook/blob/master/Tech-Stack.md";
        Document doc = Jsoup.connect(url).get();//Load the URL

        Elements tables = doc.select("table");//Load in tables
        Elements hTags = doc.select("h1, h2, h3, h4, h5, h6");//Load in tags

        Elements h2Tags = hTags.select("h2");
        int j=1;

        for (Element table : tables) {
            Category category = new Category(h2Tags.eachText().get(j));//Create new Category and name
            Elements rows = table.select("tr");//Load in rows
            for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
                Element row = rows.get(i);
                Elements cols = row.select("td");
                category.Technologies.add(cols.get(0).text());//Get the first col of the row
            }
            String jsonString = gson.toJson(category);//Convert to Json
            System.out.println(jsonString);
            j++;
        }
    }

    static class Category
    {
        String Area;
        ArrayList Technologies;

        public Category(String n)
        {
            Area = n;
            Technologies  = new ArrayList();
        }
    }

}
