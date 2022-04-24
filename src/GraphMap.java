import org.jgrapht.Graphs;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.*;

public class GraphMap extends MyMap{
    SimpleWeightedGraph<String, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

    public GraphMap(int wl) {
        super(wl);
    }

    public void addGraphMap(String w){
        for(int i = 0; i<w.length(); i++) {
            StringBuilder word_temp2 = new StringBuilder(w);
            word_temp2.setCharAt(i,'_');
            checkAndAdd(w,word_temp2);
        }
    }
    public void createGraph(){
        Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
        Map.Entry<String, List<String>> entry;
        while (iterator.hasNext()){
            entry = iterator.next();
            if (entry.getValue().size()==1){
                continue;
            }
            for (int i = 0; i<entry.getValue().size()-1; i++) {
                int w1 = wordToAscii(entry.getValue().get(i));
                for (int j = 0; j<entry.getValue().size()-1; j++){
                    if (i==j) j++;
                    Graphs.addEdgeWithVertices(graph,entry.getValue().get(i),entry.getValue().get(j),Math.abs(w1-wordToAscii(entry.getValue().get(j))));
                }
            }
        }
    }
    public void shortestPath(String w1,String w2) {

        if (graph.containsVertex(w1)&&graph.containsVertex(w2)){
            DijkstraShortestPath<String, DefaultWeightedEdge> shortestPaths = new DijkstraShortestPath<>(graph);
            List<String> stringAnswer = shortestPaths.getPath(w1,w2).getVertexList();
            List<DefaultWeightedEdge> weightedEdges = shortestPaths.getPath(w1,w2).getEdgeList();
            System.out.println(stringAnswer.get(0));
            for (int i = 0; i<weightedEdges.size(); i++){
                System.out.printf(stringAnswer.get(i+1)+" (+%.0f)\n",graph.getEdgeWeight(weightedEdges.get(i)));
            }
            System.out.printf("Total cost = %.0f\n",shortestPaths.getPath(w1,w2).getWeight());
        }else {
            System.out.printf("Cannot transform %s into %s\n",w1,w2);
        }
    }
        public int wordToAscii(String w){
        int total = 0;
        for(int i = 0; i < w.length() ; i++){
            int ascii = w.charAt(i);
            total += ascii;
        }
        return total;
    }
}
