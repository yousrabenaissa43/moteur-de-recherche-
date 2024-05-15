import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class OrdonnenceurOccu extends Ordonnenceur {
    @Override
    public List<MotEtOccurence> ordonnencer(List<String> list){
       List<MotEtOccurence>  results= new ArrayList<MotEtOccurence>();
        List<Statistique> listStats= new ArrayList<>();

        for (String s: list){
            List<Statistique> mot = MoteurDeRecherche.index.getStatistiqueParMot(s);
            if(mot!=null){
                listStats.addAll(mot);
            }
        }

        int totalOccurenceSum = listStats.stream().mapToInt(Statistique::getOccurence).sum();

        for (File file: MoteurDeRecherche.listCheminDoc){
              int score=0;
            for (Statistique k : listStats) {
                if ((k.getPath()).equalsIgnoreCase(file.getAbsolutePath())) {
                    score += k.getOccurence();
                }
            }
            if (score != 0) {
                double scoreRatio = ((double)score / (double) totalOccurenceSum)*100;
                MotEtOccurence l = new MotEtOccurence(file.getAbsolutePath(), (int)scoreRatio);
                results.add(l);
            }

        }

        return results;
    }
}
