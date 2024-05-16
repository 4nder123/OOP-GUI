package tripstrapstrull.failid.guioop;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.util.Collections;

public class Nupp implements EventHandler<MouseEvent> {

    private Button btn;
    private int xPos;
    private int yPos;

    public Nupp( int xPos, int yPos) {
        this.btn = new Button();
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

    public void reset() {
        btn.setText("");
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.println(xPos +" "+ yPos);
        if (MangijaGUI.laud.lisaNupp(xPos,yPos, MangijaGUI.md.get(0))){
            this.btn.setText(MangijaGUI.md.get(0).toString());
            if(MangijaGUI.laud.kontrolli(xPos, yPos, MangijaGUI.md.get(0))) {
                System.out.println(MangijaGUI.md.get(0).toString() + "Võitis");
            }
            Collections.rotate(MangijaGUI.md, 1);
        }
    }
}
