package tripstrapstrull.failid.guioop;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileManager {
    private String failinimi;
    private Map<String, Integer> mangijad = new HashMap<>();
    public FileManager(String failinimi) {
        this.failinimi = failinimi;
    }
    public void kirjuta() throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(this.failinimi))){
            for (String key : this.mangijad.keySet()) {
                bw.write(key+":"+this.mangijad.get(key)+"\n");
            }
        }
    }
    public void loe() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(this.failinimi))){
            String rida = br.readLine();
            while (rida!=null){
                String[] andmed = rida.split(":");
                this.mangijad.put(andmed[0], Integer.parseInt(andmed[1]));
                rida = br.readLine();
            }
        } catch (FileNotFoundException e) {
            kirjuta();
        }
    }
    public int getVoite(String nimi){
        if(this.mangijad.containsKey(nimi))
            return this.mangijad.get(nimi);
        return 0;
    }
    public void lisaVoit(String nimi){
        if(this.mangijad.containsKey(nimi))
            this.mangijad.put(nimi, this.mangijad.get(nimi) + 1);
        else
            this.mangijad.put(nimi, 1);
    }
}
