import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DecompositionPonct extends Traiteur{
    public  List<String> traiter(List<String> words) {
        List<String> motsSansPonctuations = new ArrayList<>();

        // Expression régulière pour rechercher la ponctuation
        Pattern pattern = Pattern.compile("\\p{Punct}");

        for (String mot : words) {
            // Supprimer la ponctuation de chaque mot eg: ip: hello! --> op: hello
            String motSansPonctuation = mot.replaceAll("\\p{Punct}", " ");
            motsSansPonctuations.add(motSansPonctuation);
        }
      return motsSansPonctuations;}
}
