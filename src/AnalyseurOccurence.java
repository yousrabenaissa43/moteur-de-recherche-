import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyseurOccurence extends Analyseur {

    @Override
    public List<MotEtOccurence> analyser(List<String> words) {

        ArrayList<MotEtOccurence> listMotEtOccurence = new ArrayList<>();

        Map<String, Integer> wordCountMap = new HashMap<>();


        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            listMotEtOccurence.add(new MotEtOccurence(word, count));
        }

        return listMotEtOccurence;
    }
}
