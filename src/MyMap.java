import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyMap {
    int wordLenght;

    public MyMap(int wl) {
        wordLenght = wl;
    }

    public void checkAndAdd(HashMap<String, List<String>> hm, String w, StringBuilder wb){
        if (hm.containsKey(wb.toString())){
            if (!hm.get(wb.toString()).contains(w)) hm.get(wb.toString()).add(w);
        }else {
            List<String> ts = new ArrayList<>();
            ts.add(w);
            hm.put(wb.toString(),ts);
        }
    }
}
