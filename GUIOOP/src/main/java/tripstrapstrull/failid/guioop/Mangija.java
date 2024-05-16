package tripstrapstrull.failid.guioop;

public class Mangija {
    private String nimi;
    private String nupp;

    public Mangija(String nimi) throws VäljadErind {
        if(nimi.isEmpty()) throw new VäljadErind("Täida kõik lüngad!");
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