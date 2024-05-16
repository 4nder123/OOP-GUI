package tripstrapstrull.failid.guioop;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MangijaGUI {
    public static Mangulaud laud = new Mangulaud();
    public static List<Mangija> md = new ArrayList<>();
    public static FileManager skoorid = new FileManager("save.txt");
    public static Nupp[] nupud;
    public static void naitaMangu(Stage stage){
        try {
            skoorid.loe();
        } catch (IOException e) {
            System.out.println(e);
        }
        Label m1label = new Label(md.get(0).toString()+":"+skoorid.getVoite(md.get(0).toString()));
        Label m2label = new Label(md.get(1).toString()+":"+skoorid.getVoite(md.get(1).toString()));

        nupud = new Nupp[]{
                new Nupp(0, 0),
                new Nupp(1, 0),
                new Nupp(2, 0),

                new Nupp(0, 1),
                new Nupp(1, 1),
                new Nupp(2, 1),

                new Nupp(0, 2),
                new Nupp(1, 2),
                new Nupp(2, 2),
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
        stage.setResizable(false);
        stage.setScene(scne1);
        stage.show();
    }

    public static void tulemus(Stage stage, String tulemus){
        ButtonType jahbtn = new ButtonType("Jah");
        ButtonType eibtn = new ButtonType("Ei");

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle(null);
        alert.setContentText(tulemus+"\nSoovite edasi mängida?");

        alert.getButtonTypes().setAll(jahbtn, eibtn);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == jahbtn) {
            laud.reset();
            for (Nupp nupp : nupud) {
                nupp.reset();
            }
        } else {
            System.out.println("ei");
        }

        stage.close();
    }

    public static void alusta(Stage stage){
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label mangija1Label = new Label("Mängija 1 nimi:");
        Label mangija2Label = new Label("Mängija 2 nimi:");

        TextField mangija1 = new TextField();
        TextField mangija2 = new TextField();

        Button submitButton = new Button("Jätka");
        submitButton.setOnAction(event -> {
            try{
                if (!mangija1.getText().equals(mangija2.getText())){
                    Mangija m1 = new Mangija(mangija1.getText());
                    Mangija m2 = new Mangija(mangija2.getText());
                    md.add(m1);
                    md.add(m2);
                    stage.close();
                    naitaMangu(stage);
                } else {
                    VäljadErind.Viga("Nimed ei saa samad olla!");
                }
            } catch (VäljadErind e){
                VäljadErind.Viga(e.getMessage());
            }
        });

        gridPane.add(mangija1Label, 0, 0);
        gridPane.add(mangija1, 1, 0);
        gridPane.add(mangija2Label, 0, 1);
        gridPane.add(mangija2, 1, 1);
        gridPane.add(submitButton, 1, 2);

        Scene scene = new Scene(gridPane, 250, 100);
        stage.setTitle("TripsTrapsTrull");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
