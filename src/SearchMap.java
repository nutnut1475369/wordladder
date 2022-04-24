import java.util.ArrayList;

public class SearchMap extends MyMap {
    public SearchMap(int wl){
        super(wl);
    }
    public  void addSearchTree(String w){
        StringBuilder word_temp = new StringBuilder(w);
        checkAndAdd(w,word_temp);
        for (int i = 0; i<w.length(); i++){
            StringBuilder word_temp_fw = new StringBuilder(word_temp.toString());
            StringBuilder word_temp_bw = new StringBuilder(word_temp.toString());
            for (int j = i+1; j<w.length(); j++){
                word_temp_fw.setCharAt(j-1,'_');
                word_temp_bw.setCharAt(w.length()-j,'_');
                checkAndAdd(w,word_temp_fw);
                checkAndAdd(w,word_temp_bw);
            }
        }
    }

    public ArrayList<String> searchAndAdd(String sw) {
        ArrayList<String> wordSearch = new ArrayList<>();
        StringBuilder preword = new StringBuilder(sw);
        preword.append("_".repeat(wordLenght - sw.length()));
        try {
            wordSearch.addAll(map.get(preword.toString()));
        } catch (NullPointerException ignored) {
        }
        for (int i = 0; i < wordLenght - sw.length(); i++) {
            preword.insert(0, "_");
            preword.delete(wordLenght, wordLenght + 1);
            try {
                wordSearch.addAll(map.get(preword.toString()));
            } catch (NullPointerException ignored) {
            }
        }
        return wordSearch;
    }
}
