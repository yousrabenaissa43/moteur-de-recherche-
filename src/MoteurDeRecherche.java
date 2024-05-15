import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MoteurDeRecherche {

   public static File listCheminDoc[] ;
   public Lecteur lecteur  ;
   public Analyseur analyseur ;
   public List<Traiteur> traiteurs ;
   public DecompositionEspace decompositionEspace ;
   public DecompositionPonct decompositionPonct ;
   public NettoyeurMotVide nettoyeurMotVide ;
   public Ordonnenceur ordonnenceur ;
   public static Index index ;

   MoteurDeRecherche(Lecteur lecteur, Analyseur analyseur, Ordonnenceur ordonnenceur, Index index,List<Traiteur> traiteurs ){
       this.analyseur = analyseur;
       this.lecteur = lecteur;
       this.ordonnenceur = ordonnenceur ;
       this.decompositionEspace = new DecompositionEspace();
       this.nettoyeurMotVide= new NettoyeurMotVide();
       this.decompositionPonct = new DecompositionPonct();
       this.index= index;
       this.traiteurs=traiteurs ;
   }

public void indexerDoc(String chemin){
    //lecture du document
    List<String> document = lecteur.readDocument(chemin);
    // nettoiyer le document
     document = decompositionEspace.traiter(document);
     document = nettoyeurMotVide.traiter(document);
     document = decompositionPonct.traiter(document);
     List<MotEtOccurence> MotOccDoc = analyseur.analyser(document);
     for(MotEtOccurence objet : MotOccDoc){
         //Statistique objet2 = (Statistique)objet ;
         index.ajouter(objet.getMot(),objet.getOccurence(),chemin);
         //objet2.setPath(chemin);
       //  index.stats.add(objet2);
     }
     }
public List<MotEtOccurence> rechercher(String requete ){

    List<String> listRequete = new ArrayList<>();
    List<MotEtOccurence> cheminEtScore ;
    listRequete.add(requete);
    //nettoyer requete
    listRequete = decompositionEspace.traiter(listRequete);
    listRequete = nettoyeurMotVide.traiter(listRequete);
    listRequete = decompositionPonct.traiter(listRequete);
    //get stats de la requete

    cheminEtScore = ordonnenceur.ordonnencer(listRequete);

    return cheminEtScore ;
}



}
