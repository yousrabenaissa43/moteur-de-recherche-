import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class NettoyeurMotVide extends Traiteur{
    // Ensemble de mots vides en anglais
    private  final Set<String> motsVidesAnglais = new HashSet<>(Arrays.asList(
            "a", "an", "the", "and", "or", "but", "of", "to", "in", "on", "at", "with",
            "by", "for", "about", "as", "at", "from", "into", "like", "through", "after",
            "before", "during", "since", "under", "above", "below", "over", "out", "off",
            "up", "down", "away", "back", "over", "under", "both", "each", "few", "many",
            "some", "such", "this", "that", "these", "those", "all", "any", "no", "other",
            "same", "which", "what", "who", "whom", "whose", "how", "why", "when", "where",
            "there", "here", "than", "so", "then", "not", "only", "very", "too", "enough",
            "just", "right", "left", "well", "much", "more", "most", "little", "less", "least",
            "fewer", "far", "near", "over", "almost", "just", "only", "still", "almost",",",";",".","?","!"
    ));

    // @Override
    public  List<String> traiter(List<String> words) {
        List<String> motsNonVides = new ArrayList<>();

        for (String mot : words) {
            // Vérifier si le mot n'est pas vide et n'est pas dans l'ensemble des mots vides en anglais
            if (!mot.isEmpty() && !motsVidesAnglais.contains(mot.toLowerCase())) {
                motsNonVides.add(mot);
            }
        }
        return motsNonVides ;
}}
