package vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import vinnsla.FeedbackService;
import java.io.IOException;
import java.util.Optional;

/******************************************************************************
 *  Nafn    : María Björk Gunnarsdóttir
 *  T-póstur: mbg13@hi.is
 *
 *  Lýsing  : Controller fyrir svar dialog.
 *
 *
 *****************************************************************************/


public class SvarDialogController extends Dialog<String> {
    @FXML
    private TextArea fxSvar;
    @FXML
    private Label fxSpurning;
    @FXML
    private Button fxEndurgjof;
    @FXML
    private Label fxFeedback;
    @FXML
    private ButtonType fxILagi;
    @FXML
    private ButtonType fxHaettaVid;

    /**
     * Initialize aðferð. Result converter settur.
     */
    public void initialize(){
        fxEndurgjof.setOnAction(this::onFeedback);

        setResultConverter(b -> {
            if(b.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                String svar = fxSvar.getText();
                if (!svar.isEmpty()) {
                    return fxSpurning.getText();
                }
                else {
                    return null;
                }
            }
            return null;
        });
    }

    /**
     * Notendaviðmót lesið inn.
     */
    public SvarDialogController() {
        setDialogPane(lesaSvarDialog());
    }

    /**
     * Valin spurning birt í dialog pane.
     * @param selectedItem valin spurning úr spurninga controller.
     */
    public void setValinSpurning(String selectedItem){
        fxSpurning.setText(selectedItem);
    }

    /**
     * Útlitið búið til, .fxml skrá lesin inn og controller settur.
     * @return hlutur af DialogPane.
     */
    private DialogPane lesaSvarDialog(){
        System.out.println("lesaSvarDialog");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("svar-view.fxml"));

        try{
            fxmlLoader.setController(this);
            return fxmlLoader.load();
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Handler til að gefa feedback
     * @param actionEvent ýtt á takka
     */
    private void onFeedback(ActionEvent actionEvent) {
            giveFeedback();
    }

    /**
     * Handler til að sækja og birta feedback.
     */
    private void giveFeedback(){
        String feedback = FeedbackService.provideFeedback(fxSvar.getText());
        System.out.println(feedback);
        fxFeedback.setText(feedback);
        System.out.println(fxFeedback.getText());
    }

    /**
     * Birtir dialog d og skilar svari notanda.
     * @return skilar svari notanda.
     */
    public String svaraSpurningu(){
        Optional<String> svarNotanda = showAndWait();
        return svarNotanda.orElse(null);
    }
}
