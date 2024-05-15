import java.util.*;

public abstract interface Index {



    public abstract void ajouter(String mot, int occurence, String path);


    public abstract  List<Statistique> getStatistiqueParMot(String mot) ;




}
