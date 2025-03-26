package vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Aðalforritið
 *
 * @author María Björk Gunnarsdóttir, mbg13@hi.is
 */
public class InterviewApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        var scene = new Scene(new Pane());
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.VELKOMIN);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main aðferðin
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
}
