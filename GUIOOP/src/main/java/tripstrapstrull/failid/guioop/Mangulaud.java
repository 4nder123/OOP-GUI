package tripstrapstrull.failid.guioop;

public class Mangulaud {
    private Mangija[][] laud = new Mangija[3][3];
    
    private boolean onPosLaual(int posY, int posX){
        if (posY >= this.laud.length) return false;
        if (posY < 0) return false;
        if (posX < 0 ) return false;
        if (posX >= this.laud.length) return false;
        return true;
    }

    private int kontroll(int posY, int posX, int suundY, int suundX, Mangija mangur){
        if (!onPosLaual(posY, posX)) return 0;
        if (this.laud[posY][posX] == mangur) return kontroll(posY+suundY, posX+suundX, suundY, suundX, mangur) + 1;
        return 0;
    }
    private int[] getXY(int kaik){
        int x = 0;
        int y;
        if(kaik <= 3){
            x = 0;
        } else if (kaik <= 6){
            x = 1;
        } else if (kaik <=9){
            x = 2;
        }
        y = kaik - 1 - 3*x;
        return new int[]{x,y};
    }
    public boolean kontrolli(int kaik, Mangija mangur){
        /*
         *  Kontrollib kas mängija on saanud 3 (v6iduks vajalikud nupud ritta), teades kes ja kuhu viimati käis.
         *  @param kaik, 1-9 number kuhu viimati lisati nupp.
         *  @param mangur - mangija tüüp, kelle v6idu seisundit kontrollida.
         *  @return - t6ene, kui kui antud mängur on v6itnud, väär kui ei ole
         */

        int v6iduksVajalik = 4; // palju on vaja ritta seada
        int[] xy = getXY(kaik);
        //  Üles                                                Alla
        if (kontroll(xy[0], xy[1], 1, 0, mangur) + kontroll(xy[0], xy[1], -1, 0, mangur) >= v6iduksVajalik) return true;
        //  Vasak                                               Parem
        if (kontroll(xy[0], xy[1], 0, -1, mangur) + kontroll(xy[0], xy[1], 0, 1, mangur) >= v6iduksVajalik) return true;
        //Diagonaal vasakule ülevale                ???              
        if (kontroll(xy[0], xy[1], -1, -1, mangur) + kontroll(xy[0], xy[1], 1, 1, mangur) >= v6iduksVajalik) return true;
        //Diag. paremale alla                           ???  
        if (kontroll(xy[0], xy[1], 1, -1, mangur) + kontroll(xy[0], xy[1], -1, 1, mangur) >= v6iduksVajalik) return true;
        return false;
    }
    public boolean lisaNupp(int kaik, Mangija mangur){
        /*
         * Lisab v6imalusekorral antud mängija nuppu positsioonile. 
         * @param kaik, 1-9 number kuhu soovitakse nupp panna
         * @param mangur, mänguri objekt, ehk nupp mida lisada mängulauale.
         * @return t6ene, kui 6nnestus, vastasel juhul väär. 
         */
        int[] xy = getXY(kaik);
        if (!onPosLaual(xy[1], xy[0]) || this.laud[xy[0]][xy[1]] != null) return false;
        this.laud[xy[0]][xy[1]] = mangur;
        return true;
    }
    public String[][] getNuppudeMasiiv(){
        String[][] nuppud = new String[3][3];
        for (int rida = 0; rida < this.laud.length; rida++) {
            for (int veerg = 0; veerg < this.laud[rida].length; veerg++) {
                if(this.laud[rida][veerg] == null){
                    nuppud[rida][veerg] = String.valueOf(rida*3+veerg+1);
                } else {
                    nuppud[rida][veerg] = laud[rida][veerg].getNupp();
                }
            }
        }
        return nuppud;
    }
    public void print_mangulaud() {
        String[][] nuppud = getNuppudeMasiiv();
        System.out.println();
        System.out.println(" " + nuppud[0][0] + " │ " + nuppud[0][1] + " │ " + nuppud[0][2]);
        System.out.println("───│───│───");
        System.out.println(" " + nuppud[1][0] + " │ " + nuppud[1][1]+" │ " + nuppud[1][2]);
        System.out.println("───│───│───");
        System.out.println(" " + nuppud[2][0] + " │ " + nuppud[2][1] + " │ " + nuppud[2][2]);
    }

    public void reset(){
        this.laud = new Mangija[3][3];
    }
}
