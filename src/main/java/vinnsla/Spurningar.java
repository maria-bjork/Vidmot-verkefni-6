package vinnsla;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

/******************************************************************************
 *  Nafn    : María Björk Gunnarsdóttir
 *  T-póstur: mbg13@hi.is
 *
 *  Lýsing  : Vinnslu klasi fyrir spurningar.
 *
 *
 *****************************************************************************/

public class Spurningar {
    private final ObservableList<String> flokkar = FXCollections.observableArrayList();
    private final ObservableList<String> spurningalistiVika1 = FXCollections.observableArrayList();
    private final ObservableList<String> spurningalistiVika2 = FXCollections.observableArrayList();
    private final Map<String, ObservableList<String>> spurningar = new HashMap<>();
    private final SimpleStringProperty fjoldiSvaradraSpurninga = new SimpleStringProperty("0");

    /**
     * Smiður sem býr til flokka og spurgninar.
     */
    public Spurningar() {
        flokkar.add("Vika 1, JavaFX");
        flokkar.add("Vika 2, Atburðir");

        //Vika 1
        spurningalistiVika1.add("Hvað er JavaFx?");
        spurningalistiVika1.add("Hvað er Scenebuilder?");
        spurningalistiVika1.add("Hvert er grunnskipulag JavaFX forrits?");
        spurningalistiVika1.add("Hvað er Maven?");
        spurningalistiVika1.add("Hvaða tilgangi þjónar pom.xml?");

        //Vika 2
        spurningalistiVika2.add("Hvenær verða atburðir til? Nefndu tvö dæmi um atburð.");
        spurningalistiVika2.add("Hvað er viðmótshlutur (user interface object)?");
        spurningalistiVika2.add("Hvenær er kallað á initialize aðferðina og hvað er gjarnan forritað þar?");
        spurningalistiVika2.add("Gerðu grein fyrir því hvað gluggi (stage), sena (scene) og node er.");


        spurningar.put(flokkar.get(0), spurningalistiVika1);
        spurningar.put(flokkar.get(1), spurningalistiVika2);
    }

    /**
     * Aðferð til að ná í spurnningalista fyirir gefinn flokk.
     * @param flokkurIndex flokkur
     * @return spurgningar í þeim flokku.
     */
    public ObservableList<String> getSpurningalisti(int flokkurIndex){
        String flokkur = flokkar.get(flokkurIndex);
        return spurningar.get(flokkur);
    }

    /**
     * Aðferð til að sækja flokka.
     * @return flokkar
     */
    public ObservableList<String> getFlokkar(){
        return flokkar;
    }

}
