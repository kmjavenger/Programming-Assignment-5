
import java.util.*;
import java.io.*;

public class TestBinarySearchTree {

    static long wordsFound = 0;
    static long wordsNotFound = 0;
    static long compsFound = 0;
    static long compsNotFound = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("random_dictionary.txt"));
        BinarySearchTree[] dictionary = new BinarySearchTree[26];
        for (int i = 0; i < dictionary.length; i++) {
            dictionary[i] = new BinarySearchTree<String>();
        }
        while (in.hasNext()) {
            String line = in.next();
            line = line.replaceAll("[^\\w\\s\\ ]", " ").toLowerCase();
            line = line.replaceAll(" ", "");
            dictionary[(int) line.charAt(0) - 97].insert(line);
        }
        in.close();
        Scanner oliver = new Scanner(new File("oliver.txt"));
        while ( oliver.hasNext()) {
            String line = oliver.next();
            line = line.replaceAll("\\d+","");
            line = line.replaceAll("[^\\w\\s\\ ]", "").toLowerCase();
            line = line.replaceAll("_", "");
            line = line.replaceAll(" ", "");
            if(line.isEmpty() != true){
                dictionary[(int)line.charAt(0) - 97].search(line);
            }
        }
        oliver.close();
        dictionary[0].getInfo();
    }
}
