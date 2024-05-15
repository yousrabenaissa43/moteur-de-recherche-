import java.util.*;

public class IndexListe<E> extends ArrayList<Statistique> implements Index  {



    @Override
    public void ajouter(String mot, int occurence, String path) {
        boolean exist = false;

        for (Statistique statistique : this) {
            if (statistique.getMot().equalsIgnoreCase(mot) && statistique.getPath().equalsIgnoreCase(path)) {
                // Mise à jour de l'occurrence si la statistique existe déjà
                statistique.setOccurence(statistique.getOccurence() + occurence);
                exist = true;
                break;
            }
        }

        if (!exist) {
            this.add(new Statistique(mot, occurence, path));
        }
    }


    @Override
     public List<Statistique> getStatistiqueParMot(String mot) {
        List<Statistique> listStatMot = new ArrayList<>();        //o(n)

          for ( Statistique statistique : this ){
            if (statistique.getMot().equalsIgnoreCase(mot)) {
                listStatMot.add(statistique);
            }
          }
        return listStatMot;
    }

}
