
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DecompositionEspace extends Traiteur{

    public  List<String> traiter(List<String> words) {
        List<String> wordsofsentence = new ArrayList<String>();
            for(String i : words){
                String[] sentenceWords = i.split(" ");
                Collections.addAll(wordsofsentence, sentenceWords);}


        return wordsofsentence;}
}


