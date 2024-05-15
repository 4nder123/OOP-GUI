package tripstrapstrull.failid.guioop;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class Peaklass extends Application {

    private int mi = 0;

    private void flipMi(){
        System.out.println(mi);
        if (mi < 1){
            mi = 1;
            return;
        }
        mi = 0;
    }


    @Override
    public void start(Stage stage) throws IOException {


        Mangulaud laud = new Mangulaud();
        Mangija m1 = new Mangija("m1");
        Mangija m2 = new Mangija("m2");
        Mangija[] md = {m1, m2};
        int mi = 0;

        Button[] nupud = {
                new Button(),
                new Button(),
                new Button(),

                new Button(),
                new Button(),
                new Button(),

                new Button(),
                new Button(),
                new Button()
        };

        GridPane grid = new GridPane(3, 3);
        int x = 0;
        int y = 0;
        for (int i = 0; i < 9; i++) {// Lisame nupud ja anname neile m6tte!
            Button b = nupud[i];
            grid.add(nupud[i], x, y);
            x++;
            if (x >= 3){
                x = 0;
                y++;
            }
            int xCpy = x;
            int yCpy = y;

            nupud[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if (laud.lisaNupp((xCpy+1)*(yCpy+1), md[mi])){
                        b.setText(md[mi].toString());
                        flipMi();
                    }
                }
            });
        }


        Scene scne1 = new Scene(grid);
        stage.setTitle("TripsTrapsTrull");
        stage.setScene(scne1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}