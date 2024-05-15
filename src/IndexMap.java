import java.util.*;

public class IndexMap<E> extends HashMap<String, List<MotEtOccurence>> implements Index  {

    @Override
    public void ajouter(String mot, int occurence, String path) {
        List<MotEtOccurence> couple = this.get(mot.toLowerCase());

        if (couple != null) {
            boolean found = false;

            for (MotEtOccurence i : couple) {
                if (i.getMot().equalsIgnoreCase(path)) {
                    // si le mot existe avec le meme chemin
                    i.setOccurence(i.getOccurence() + occurence);
                    found = true;
                    break;
                }
            }

            // si le mot existe mais avec un autre chemin
            if (!found) {
                couple.add(new MotEtOccurence(path, occurence));
            }

            this.put(mot.toLowerCase(), couple);
        } else {
            // si le mot n'existe pas
            couple = new ArrayList<>();
            couple.add(new MotEtOccurence(path, occurence));
            this.put(mot.toLowerCase(), couple);
        }
    }


    @Override
    public List<Statistique> getStatistiqueParMot(String mot) {
          List<MotEtOccurence> list = this.get(mot.toLowerCase());
          List<Statistique> listStatMot = new ArrayList<>();
          for(MotEtOccurence i : list){
              listStatMot.add(new Statistique(mot,i.getOccurence(),i.getMot()));
          }
            return listStatMot;
        }
    }

