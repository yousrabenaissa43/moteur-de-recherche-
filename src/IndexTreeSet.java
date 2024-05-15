
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class IndexTreeSet <E> extends TreeSet<Statistique> implements Index {

    @Override
    public void ajouter(String mot, int occurence, String path) {
        Statistique target = null;

        for (Statistique stat : this) {
            if (stat.getMot().equalsIgnoreCase(mot) && stat.getPath().equalsIgnoreCase(path)) {
                target = stat;
                break;
            }
        }

        if (target != null) {
            this.remove(target);
            target.setOccurence(target.getOccurence() + occurence);
            this.add(target);
        } else {
            // si le mot n'existe pas
            Statistique newStat = new Statistique(mot, occurence, path);
            this.add(newStat);
        }
    }

    @Override
    public List<Statistique> getStatistiqueParMot(String mot) {
        List<Statistique> existingStat = new ArrayList<>();
        Iterator<Statistique> iterator = this.iterator();
        while (iterator.hasNext()) {
            Statistique stat = iterator.next();
            if (stat.getMot().equalsIgnoreCase(mot)) {
                existingStat.add(stat);
            }
        }
        return existingStat.isEmpty() ? null : existingStat;
    }

}
