package tripstrapstrull.failid.guioop;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Collections;

public class Nupp implements EventHandler<MouseEvent> {
    //Nupp on ühe ruudu representatsioon.
    private Button btn;
    private int xPos;
    private int yPos;
    private Stage stage;

    public Nupp( int xPos, int yPos, Stage stage) {
        this.btn = new Button();
        this.stage = stage;
        this.btn.setFont(new Font("Arial", 24));
        this.btn.setMinSize(100, 100);
        this.btn.setOnMouseClicked(this::handle);
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Button getBtn() {
        return btn;
    }
    public int getxPos() {
        return xPos;
    }
    public int getyPos() {
        return yPos;
    }



    @Override
    public void handle(MouseEvent mouseEvent) {

        //System.out.println(xPos +" "+ yPos);
        if (MangijaGUI.laud.lisaNupp(xPos,yPos, MangijaGUI.md.get(0))){//Proovime nuppu lisada, kui ei saa tagastatakse false
            this.btn.setText(MangijaGUI.md.get(0).getNupp());
            if(MangijaGUI.laud.kontrolli(xPos, yPos, MangijaGUI.md.get(0))) {//Kontollime kas keegi on voitnud!
                MangijaGUI.skoorid.lisaVoit(MangijaGUI.md.get(0).toString());
                try {
                    MangijaGUI.skoorid.kirjuta();
                } catch (IOException e) {
                    System.out.println(e);
                }

                MangijaGUI.tulemus(stage, "Võitis " + MangijaGUI.md.get(0).toString());
            } else if (MangijaGUI.laud.onViik()) {// kontrollime viigiseisundit
                MangijaGUI.tulemus(stage, "Viik!");

            } else {//laseme teisel mängijal mängida
                Collections.rotate(MangijaGUI.md, 1);
            }
        }
    }
}
