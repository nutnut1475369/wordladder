
import java.io.File;
import java.util.*;

public class Wordladder {
    static final int wordLenght = 5;

    public static void main(String[] args) {
        SearchMap searchMap = new SearchMap(wordLenght);
        GraphMap graphMap = new GraphMap(wordLenght);
        Scanner input = new Scanner(System.in);
        String check;
        while (true) {
            try {
                System.out.print("Enter data file = ");
                Scanner file = new Scanner(new File(input.nextLine()));
                while (file.hasNext()) {
                    String word = file.nextLine();
                    searchMap.addSearchTree(word);
                    graphMap.addGraphMap(word);
                }
                break;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Something happen while attempt to open file.\n");
            }
        }
        graphMap.createGraph();
        do {
            String word1;
            String word2;
            do {
                System.out.println("Enter 5-letter word with 'a'-'z' and no space between letters.\n");
                System.out.println("Enter 5-letter word 1 =");
                word1 = input.nextLine().toLowerCase();
                System.out.println("Enter 5-letter word 2 =");
                word2 = input.nextLine().toLowerCase();
            } while (word1.length() < wordLenght || word2.length() < wordLenght || isNotAlphabet(word1) || isNotAlphabet(word2));
            graphMap.shortestPath(word1, word2);
            System.out.println("Search = ");
            String searchWord;
            do {
                searchWord = input.nextLine().toLowerCase();
            } while (isNotAlphabet(searchWord));
            ArrayList<String> wordSearch;
            wordSearch = searchMap.searchAndAdd(searchWord);
            if (wordSearch.size() != 0) {
                wordSearch.forEach(System.out::println);
            } else {
                System.out.println("not have any word relate with your search");
            }
            System.out.println("Do you need to run again? (Y/N)");
            check = input.nextLine().toLowerCase();
        } while (check.equals("y"));
    }

    public static boolean isNotAlphabet(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 95) continue;
            if (!Character.isAlphabetic(ch)) {
                System.out.println("please enter only \"alphabet\"");
                return true;
            }
        }
        return false;
    }
}