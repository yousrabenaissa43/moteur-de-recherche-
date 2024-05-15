import java.util.*;
import java.io.File;
import java.io.FileOutputStream;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans le moteur de recherche !");
        System.out.println("Quel corpus souhaitez-vous indexer ?");
        System.out.println("1. Le grand corpus");
        System.out.println("2. Le petit corpus");
        System.out.println("3. Le très petit corpus");

        // Choix du corpus
        int choixCorpus = scanner.nextInt();
        int Corpus = choixCorpus ;
        String cheminCorpus = "";
        switch (choixCorpus) {
            case 1:
                cheminCorpus = "C:\\Users\\Mega_PC\\Downloads\\grand_corpus\\corpus";
                break;
            case 2:
                cheminCorpus = "C:\\Users\\Mega_PC\\Downloads\\petit_corpus";
                break;
            case 3:
                cheminCorpus = "C:\\Users\\Mega_PC\\Downloads\\tres_petit_corpus";
                break;
            default:
                System.out.println("Choix invalide. Utilisation du corpus par défaut.");
                cheminCorpus = "C:\\Users\\Mega_PC\\Downloads\\grand_corpus\\corpus"; // Corpus par défaut
                break;
        }

        File directoryPath = new File(cheminCorpus);

        //List of all files and directories
        File filesList[] = directoryPath.listFiles();
        MoteurDeRecherche.listCheminDoc = filesList ;

        // Initialisation du lecteur

        Lecteur lecteur = new Lecteur();


        Index index = choisirOption(scanner, "index", choixCorpus);

        List<Traiteur> traiteurs = new ArrayList<>();

        // Demander à l'utilisateur combien de traiteurs il souhaite utiliser

        System.out.println("Combien de traiteurs souhaitez-vous utiliser ?");
        int nombreTraiteurs = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le saut de ligne

        // Boucle pour choisir les traiteurs
        for (int i = 0; i < nombreTraiteurs; i++) {
            System.out.println("Choisissez le traiteur " + (i + 1) + " :");
            Traiteur traiteur = choisirOption(scanner, "traiteur",Corpus);
            traiteurs.add(traiteur);
        }

        // Choix de l'analyseur
        System.out.println("Choisissez l'analyseur :");
        Analyseur analyseur = choisirOption(scanner, "analyseur",Corpus);



        // Choix de l'ordonnanceur
        System.out.println("Choisissez l'ordonnanceur :");
        Ordonnenceur ordonnanceur = choisirOption(scanner, "ordonnanceur",Corpus);

        // Création de l'instance du moteur de recherche
        MoteurDeRecherche moteurDeRecherche = new MoteurDeRecherche(lecteur, analyseur , ordonnanceur, index ,traiteurs);

        // Indexation des documents
        for(int i =0; i <filesList.length; i++ ){
            moteurDeRecherche.indexerDoc(filesList[i].getAbsolutePath());
        }

        // Recherche
        System.out.println("Veuillez saisir votre requête :");
        String requete = scanner.nextLine();

        // Appel de la méthode de recherche avec la requête
        List<MotEtOccurence> resultatsRecherche = moteurDeRecherche.rechercher(requete);

        // Affichage des résultats de la recherche
        for (MotEtOccurence resultat : resultatsRecherche) {
            System.out.println(resultat);
        }

        scanner.close();
    }

    private static <T> T choisirOption(Scanner scanner, String option,int choixCorpus) {
        switch (option) {
            case "traiteur":
                System.out.println("Choisissez le traiteur :");
                System.out.println("1. DecompositionPonct");
                System.out.println("2. NettoyeurMotVide");
                break;
            case "analyseur":
                System.out.println("Choisissez l'analyseur :");
                System.out.println("1. AnalyserBinaire");
                System.out.println("2. AnalyseurOccurence");
                break;
            case "index":
                System.out.println("Choisissez l'index :");
                System.out.println("1. IndexListe");
                System.out.println("2. IndexTreeSet");
                System.out.println("3. IndexMap");
                break;
            case "ordonnanceur":
                System.out.println("Choisissez l'ordonnanceur :");
                System.out.println("1. OrdonnanceurBinaire");
                System.out.println("2. OrdonnanceurOccu");
                break;
            default:
                throw new IllegalArgumentException("Option invalide : " + option);
        }
        int choix = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le saut de ligne
        switch (option) {
            case "traiteur":
                return (T) choisirTraiteur(choix);
            case "analyseur":
                return (T) choisirAnalyseur(choix);
            case "index":
                return (T) choisirIndex(choix,choixCorpus);
            case "ordonnanceur":
                return (T) choisirOrdonnanceur(choix);
            default:
                throw new IllegalArgumentException("Option invalide : " + option);
        }
    }

    private static Traiteur choisirTraiteur(int choix) {
        switch (choix) {
            case 1:
                return new DecompositionPonct();
            case 2:
                return new NettoyeurMotVide();
            default:
                // Choix par défaut (à déterminer en fonction de la complexité/efficacité)
                return new DecompositionPonct();
        }
    }

    private static Analyseur choisirAnalyseur(int choix) {
        switch (choix) {
            case 1:
                return new AnalyserBinaire();
            case 2:
                return new AnalyseurOccurence();
            default:
                // Choix par défaut (à déterminer en fonction de la complexité/efficacité)
                return new AnalyseurOccurence();
        }
    }

    private static Index choisirIndex(int choix, int choixCorpus) {
        switch (choix) {
            case 1:
                return new IndexListe<>();
            case 2:
                    return new IndexTreeSet<>(); // Pour les autres corpus
            case 3:
                return new IndexMap<>();
            default:
                // Choix par défaut en fonction du corpus
                if (choixCorpus == 3) {
                    return new IndexListe(); // Si le corpus est "Le très petit corpus"
                } else {
                    return new IndexMap(); // Pour les autres corpus
                }}}

    private static Ordonnenceur choisirOrdonnanceur(int choix) {
        switch (choix) {
            case 1:
                return new OrdonnenceurBinaire();
            case 2:
                return new OrdonnenceurOccu();
            default:
                // Choix par défaut (à déterminer en fonction de la complexité/efficacité)
                return new OrdonnenceurBinaire();
        }
    }

}