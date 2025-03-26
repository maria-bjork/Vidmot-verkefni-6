package vidmot;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author María Björk Gunnarsdóttir, mbg13@hi.is
 */
public class ViewSwitcher {
    private static final Map<View, Parent> cache = new HashMap<>();

    private static Scene scene;

    /**
     * Setur núverandi senu í ViewSwitcher sem scene, engin breyting á glugganum.
     * @param scene senan
     */
    public static void setScene(Scene scene){
        ViewSwitcher.scene = scene;
    }

    /**
     * Skipta yfir í viðmótstré sem er lýst í view
     *
     * @param view nafn á .fxml skrá
     */

    public static void switchTo(View view){
        if(scene == null){
            System.out.println("Ekkert scene");
        }

        try{
            Parent root;
            //Fletta upp í skyndiminni
            if (cache.containsKey(view)){
                System.out.println("Hleð frá skyndiminni");
                root = cache.get(view);
            }
            else{ //Annars lesa úr fxml skrá.
                System.out.println("Les úr fxml skrá");
                root = FXMLLoader.load(ViewSwitcher.class.getResource(view.getFileName())
                );
                cache.put(view, root);
            }
            scene.setRoot(root);
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
