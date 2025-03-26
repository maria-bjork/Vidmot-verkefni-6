package vidmot;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/******************************************************************************
 *  Nafn    : María Björk Gunnarsdóttir
 *  T-póstur: mbg13@hi.is
 *
 *  Lýsing  : Controller fyrir velkomin pein.
 *
 *
 *****************************************************************************/


public class VelkominController {
    /**
     * Handler til að skipta yfir í spurningar
     */
    @FXML
    public void spurningarHandler() {
        ViewSwitcher.switchTo(View.SPURNINGAR);
    }

    /**
     * Handler til að hætta í forritinu.
     */
    @FXML
    public void haettaHandler(){
        ViewSwitcher.switchTo(View.KVEDJA);
    }
}
