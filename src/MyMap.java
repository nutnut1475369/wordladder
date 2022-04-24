import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyMap {
    protected int wordLenght;
    protected HashMap<String, List<String>> map = new HashMap<>();

    public MyMap(int wl) {
        wordLenght = wl;
    }

    public void checkAndAdd(String w, StringBuilder wb){
        if (map.containsKey(wb.toString())){
            if (!map.get(wb.toString()).contains(w)) map.get(wb.toString()).add(w);
        }else {
            List<String> ts = new ArrayList<>();
            ts.add(w);
            map.put(wb.toString(),ts);
        }
    }
}
