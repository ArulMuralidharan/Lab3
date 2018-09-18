import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class Main {

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

    public static void main(String[] args) {
	    System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
	    int wordCount = computeWordCount(urlToString("http://erdani.com/tdpl/hamlet.txt"));
	    System.out.println("Word Count: " + wordCount);


        Scanner lineScanner = new Scanner(System.in);
        System.out.println("Enter a word to search in the url: ");
        String searchTerm = lineScanner.nextLine();
        int oneWordCount = computeOneWordCount(urlToString("http://erdani.com/tdpl/hamlet.txt"), searchTerm);

        System.out.println(searchTerm + " Appears " + oneWordCount + " times in the URL");

    }

    public static int computeWordCount(String contents) {
        String[] contentsArray = contents.split(" ");
        return contentsArray.length;
    }

    public static int computeOneWordCount(String contents, String searchTerm) {
        String[] contentsArray = contents.split(" ");
        int wordCount = 0;

        for (int i = 0; i < contentsArray.length; i++) {

            System.out.println(contentsArray[i]);
            if (contentsArray[i].equalsIgnoreCase(searchTerm)) {
                wordCount ++;
            }
        }

        return wordCount;
    }


}
