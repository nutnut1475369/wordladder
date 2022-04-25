import java.util.ArrayList;

public class SearchMap extends MyMap {
    public SearchMap(int wl){
        super(wl);
    }
    public  void addSearchTree(String w){
        StringBuilder word_temp = new StringBuilder(w);
        StringBuilder word_temp_under = new StringBuilder("_____");
        checkAndAdd(w,word_temp);
        for (int i = 0; i<w.length(); i++){
            StringBuilder word_temp_fw = new StringBuilder(word_temp.toString());
            StringBuilder word_temp_bw = new StringBuilder(word_temp.toString());
            StringBuilder word_temp_fw_under = new StringBuilder(word_temp_under.toString());
            StringBuilder word_temp_bw_under = new StringBuilder(word_temp_under.toString());
            for (int j = i+1; j<w.length(); j++){
                word_temp_fw.setCharAt(j-1,'_');
                word_temp_bw.setCharAt(w.length()-j,'_');
                word_temp_fw_under.setCharAt(j-1,word_temp.charAt(j-1));
                word_temp_bw_under.setCharAt(w.length()-j,word_temp.charAt(w.length()-j));
                System.out.println(word_temp_fw);
                System.out.println(word_temp_bw);
                System.out.println(word_temp_fw_under);
                System.out.println(word_temp_bw_under);
                checkAndAdd(w,word_temp_fw);
                checkAndAdd(w,word_temp_bw);
                checkAndAdd(w,word_temp_fw_under);
                checkAndAdd(w,word_temp_bw_under);
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
