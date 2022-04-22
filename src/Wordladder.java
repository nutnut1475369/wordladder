
import java.io.File;
import java.util.*;

public class Wordladder {
    static final int wordLenght = 5;
    public static void main(String[] args) {
        SearchMap searchMap = new SearchMap(wordLenght);
        GraphMap graphMap = new GraphMap(wordLenght);
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter data file = ");
                Scanner file = new Scanner(new File(input.nextLine()));
                while(file.hasNext()){
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
        String word1;
        String word2;
        do {
            System.out.print("Enter 5-letter word with 'a'-'z' and no space between letters.\n");
            System.out.print("Enter 5-letter word 1 =");
            word1 = input.nextLine();
            System.out.print("Enter 5-letter word 2 =");
            word2 = input.nextLine();
            word1 = word1.toLowerCase();
            word2 = word2.toLowerCase();
        }while (word1.length()<wordLenght||word2.length()<wordLenght|| isNotAlphabet(word1) || isNotAlphabet(word2) ||word1.matches(".*\\s+.*")||word2.matches(".*\\s+.*"));
        graphMap.shortestPath(word1, word2);

        System.out.print("you can use \"_\" between letters for instead of any letters ");
        System.out.print("Example: a_e\n you'll see output look like this \n Output: axe ave ace ape awe age aye ale ane are ate ");
        System.out.print("but don't use like this \"_a_b_c_d\"");
        System.out.print("Search = ");
        String searchWord;
        do {
            searchWord = input.nextLine();
            searchWord = searchWord.toLowerCase();
        }while (isNotAlphabet(searchWord) || word1.matches(".*\\s+.*"));
        ArrayList<String> wordSearch;
        wordSearch = searchMap.searchAndAdd(searchWord);
        if (wordSearch.size()!=0){
            wordSearch.forEach(System.out::println);
        }else {
            System.out.println("not have any word relate with your search");
        }
    }

    public static boolean isNotAlphabet(String s){
        for (int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if (ch == 95) continue;
            if (ch<'a'||ch>'z') {
                return true;
            }
        }
        return false;
    }
}