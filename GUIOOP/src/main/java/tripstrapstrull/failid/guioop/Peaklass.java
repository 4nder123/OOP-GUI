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
    public static Mangulaud laud = new Mangulaud();
    public static List<Mangija> md;
    @Override
    public void start(Stage stage) throws IOException {

        Mangija m1 = new Mangija("m1");
        Mangija m2 = new Mangija("m2");
        md = Arrays.asList(m1,m2);

        Label m1label = new Label(m1.toString());
        Label m2label = new Label(m2.toString());

        Nupp[] nupud = {
                new Nupp(0,0),
                new Nupp(1,0),
                new Nupp(2,0),

                new Nupp(0,1),
                new Nupp(1,1),
                new Nupp(2,1),

                new Nupp(0,2),
                new Nupp(1,2),
                new Nupp(2,2),
        };

        GridPane mang = new GridPane(3,3);
        GridPane nimed = new GridPane(2,1);
        BorderPane mangulaud = new BorderPane();
        mang.setAlignment(Pos.CENTER);
        nimed.setAlignment(Pos.CENTER);
        nimed.setHgap(100);

        nimed.add(m1label,0,0);
        nimed.add(m2label,1,0);
        mangulaud.setTop(nimed);
        mangulaud.setCenter(mang);
        for (Nupp nupp : nupud) {
            mang.add(nupp.getBtn(), nupp.getxPos(), nupp.getyPos());
        }
        Scene scne1 = new Scene(mangulaud, 350, 350);
        stage.setTitle("TripsTrapsTrull");
        stage.setScene(scne1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}