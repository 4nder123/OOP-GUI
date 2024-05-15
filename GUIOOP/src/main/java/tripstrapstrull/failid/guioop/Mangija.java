package tripstrapstrull.failid.guioop;

public class Mangija {
    private String nimi;
    private String nupp;

    public Mangija(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public String toString(){
        return nimi;
    }

    public String getNupp() {
        return nupp;
    }

    public void setNupp(String nupp) {
        this.nupp = nupp;
    }
}