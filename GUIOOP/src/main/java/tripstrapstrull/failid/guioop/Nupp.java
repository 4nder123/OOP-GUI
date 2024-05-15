package tripstrapstrull.failid.guioop;
import javafx.scene.control.Button;
public class Nupp {

    private Button btn;
    int xPos;
    int yPos;

    public Nupp( int xPos, int yPos) {
        this.btn = new Button();
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}
