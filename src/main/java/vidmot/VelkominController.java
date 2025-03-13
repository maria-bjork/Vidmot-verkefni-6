package vidmot;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InterviewController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}