package vidmot;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import vinnsla.Spurningar;

import java.util.List;

/******************************************************************************
 *  Nafn    : María Björk Gunnarsdóttir
 *  T-póstur: mbg13@hi.is
 *
 *  Lýsing  : Controller fyrir spurninga Scene
 *
 *
 *****************************************************************************/

public class SpurningarController {

    @FXML
    private ListView<String> fxFlokkar;
    @FXML
    private ListView<String> fxSpurningar;
    @FXML
    public ListView<String> fxSpurningarSvarad;
    @FXML
    private Label fxFjoldiSvara;
    private SimpleIntegerProperty fjoldiSvara = new SimpleIntegerProperty(0);
    private final Spurningar spurningar = new Spurningar();

    /**
     * Initialize aðferð
     */
    public void initialize(){
        fxFlokkar.setItems(spurningar.getFlokkar());
        fxFlokkar.getSelectionModel().selectedIndexProperty().addListener((obs, old, newIndex) -> {
            if((int)newIndex >= 0){
                fxSpurningar.setItems(spurningar.getSpurningalisti((int) newIndex));
            }
            }
        );
        fxFjoldiSvara.textProperty().bind(fjoldiSvara.asString());
    }

    /**
     * Handler fyrir svara takka.
     */
    public void svaraHandler(){
        String valinSpurning = fxSpurningar.getSelectionModel().getSelectedItem();
        if(valinSpurning != null ){
            SvarDialogController d = new SvarDialogController();
            d.setValinSpurning(valinSpurning);
            String svarNotanda = d.svaraSpurningu();
            if(svarNotanda != null){
                fjoldiSvara.setValue(fjoldiSvara.getValue() + 1);
                fxSpurningarSvarad.getItems().add(valinSpurning);
            }
        }
    }

    /**
     * Handler til að fara aftur á velkomin scene.
     */
    public void tilbakaHandler(){
        ViewSwitcher.switchTo(View.VELKOMIN);
    }

    /**
     * Handler til að hætta og opna kveðju scene.
     */
    public void haettaHandler(){
        ViewSwitcher.switchTo(View.KVEDJA);
    }


}
