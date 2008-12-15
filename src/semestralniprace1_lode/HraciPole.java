
package semestralniprace1_lode;

public class HraciPole {
    int sirka, vyska;
    int pocet_lodi;

    Policko[] obsah;    

    public HraciPole(){
        this(false, 20, 20, 10);
    }
    public HraciPole(Boolean nahodne, int sirka_, int vyska_, int pocet_lodi_){

        sirka = sirka_;
        vyska = vyska_;
        pocet_lodi = pocet_lodi_;

        obsah = new Policko[sirka*vyska];

        for (int i = 0; i < obsah.length; i++) {
            obsah[i] = new Policko();
        }

        if (!nahodne){
            for (int i = 0; i < obsah.length; i++) {
                obsah[i].NastavPrazdne();
            }
        }
        else {
            for (int i = 0; i < obsah.length; i++) {
                obsah[i].NastavNahodne();

            }
        }

    }

    @Override
    public String toString(){
        String retezec = new String();
        int k = 0;
        for (int i = 0; i < vyska; i++) {
            for (int j = 0; j < sirka; j++) {
                retezec += " ";
                retezec += obsah[k].VypisObsah();
                k++;
            }
            retezec += "\n";
        }
        
        return retezec;
    }

    boolean Strelba(int index_policka){
        boolean vysledek;

        vysledek = obsah[index_policka].Strelba();

        if (vysledek) pocet_lodi--;

        return vysledek;
    }

    byte StavPolicka(int index_policka){
        return obsah[index_policka].VypisObsah();
    }

    int PocetLodi(){
        return pocet_lodi;
    }


}
