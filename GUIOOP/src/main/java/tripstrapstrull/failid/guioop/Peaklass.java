package tripstrapstrull.failid.guioop;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Peaklass extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MangijaGUI.kusimangijaid(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}