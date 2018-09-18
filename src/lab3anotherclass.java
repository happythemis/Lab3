import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class lab3anotherclass {
    public static void main(String[] unused) {
        // write your code here
        //System.out.println("Hee");
        urlToString("http://erdani.com/tdpl/hamlet.txt");
        String[] array = urlToString("http://erdani.com/tdpl/hamlet.txt").split("\\s+");
        System.out.println("total word count: " + array.length);
        int countspecific = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the word you want to find: ");
        String getinput = input.nextLine();


        for (int i = 0; i < array.length; i++) {
            if (array[i].toUpperCase().contains(getinput.toUpperCase())) {
                countspecific++;
            }
        }
        System.out.println(countspecific);
        //System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
