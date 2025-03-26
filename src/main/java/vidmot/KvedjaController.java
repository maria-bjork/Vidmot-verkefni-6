package vidmot;

import javafx.application.Platform;


/******************************************************************************
 *  Nafn    : María Björk Gunnarsdóttir
 *  T-póstur: mbg13@hi.is
 *
 *  Lýsing  : Controller fyrir kvedju þegar hætt er í forritinu.
 *
 *
 *****************************************************************************/

public class KvedjaController {

    /**
     * Handler til að loka forritinu.
     */
    public void lokaHandler(){
        Platform.exit();
    }
}
