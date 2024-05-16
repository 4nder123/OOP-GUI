package tripstrapstrull.failid.guioop;

import javafx.scene.control.Alert;

public class VäljadErind extends Exception{
    public VäljadErind(String message) {
        super(message);
    }
    public static void Viga(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Viga");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
