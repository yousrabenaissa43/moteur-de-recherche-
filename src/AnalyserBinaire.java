
import java.util.ArrayList;
import java.util.List;


public class AnalyserBinaire extends Analyseur{

    public  List<MotEtOccurence> analyser(List<String> words){
        List<MotEtOccurence>  listAnalyse = new ArrayList<>() ;

        for(String i: words){
            for(String j : words ){
            if (! i.equalsIgnoreCase(j)) {
                listAnalyse.add(new MotEtOccurence(i,1));
            }}
        }
    return listAnalyse;}

}
