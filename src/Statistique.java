import java.util.Comparator;
import java.util.Objects;


public class Statistique extends MotEtOccurence implements Comparable<Statistique>  {
    private String path;


    public Statistique(String mot, int nbrocc, String path) {
        super(mot, nbrocc);
        this.path = path;
    }

    @Override
    public int getOccurence() {
        return super.getOccurence();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    @Override
    public String toString() {
        return  mot + ": " + occurence + " Path : " + path;
    }

    @Override
    public boolean equals(Object anObject){
        if(anObject instanceof Statistique){
            boolean etat= this.mot.equalsIgnoreCase(((Statistique) anObject).mot) && this.path.equalsIgnoreCase(((Statistique) anObject).path);
            return etat ;
        }
        return false ;
    }

    @Override
    public int compareTo(Statistique other) {
        return this.getMot().compareToIgnoreCase(other.getMot()) + this.path.compareToIgnoreCase(other.path)+ this.occurence ;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(path);
    }

    public static Comparator<Statistique> moyComparator = new Comparator<Statistique>() {
        public int compare(Statistique s1, Statistique s2) {
            return s1.getPath().compareTo(s2.getPath());
        }
    };
}
