
package semestralniprace1_lode;

public class Policko{

    byte stav = 0;    // 0 - prazdne=neobjevene, 1 - obsazene, 2 - potopene, 3 - voda/vyzkousene

    void NastavPrazdne(){
        stav = 0;
    }

    void NastavObsazene(){
        stav = 1;
    }

    void NastavPotopene(){
        stav = 2;
    }

    void NastavProhledane(){
        stav = 3;
    }

    void NastavNahodne(){
        stav = (byte)(Math.round(Math.random()));
    }

    byte VypisObsah(){
        return stav;
    }

    boolean Strelba(){
        boolean vysledek = false;

        if (stav == 1) {
            vysledek = true;
            stav = 2;
        }
        else {
            stav = 3;
        }

        return vysledek;
    }

}
