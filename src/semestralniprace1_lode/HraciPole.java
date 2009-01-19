
package semestralniprace1_lode;

import java.io.Serializable;

/**
 *
 * Trida pro herni plan
 */
public class HraciPole implements Serializable {
    int sirka, vyska;
    int pocet_lodi;

    Policko[] obsah;    

    public HraciPole(){
        this(true, 7, 7, 10);
    }
    public HraciPole(Boolean chaotickyrezim, int sirkavyska){
        if (chaotickyrezim){

            sirka = sirkavyska;
            vyska = sirkavyska;
            pocet_lodi = 10;
            int nahodne;

            obsah = new Policko[sirka*vyska];

            for (int i = 0; i < obsah.length; i++) {    // vytvoreni odkazu v poli objektu
                obsah[i] = new Policko();

                nahodne = (int)Math.round(Math.random()*2);

                switch(nahodne){
                    case 0:
                        obsah[i].NastavObsazene();
                        break;
                    case 1:
                        obsah[i].NastavPotopene();
                        break;
                    case 2:
                        obsah[i].NastavPrazdne();
                }
            }
        }
    }
    public HraciPole(Boolean nahodne, int sirka_, int vyska_, int pocet_lodi_){

        sirka = sirka_;
        vyska = vyska_;
        pocet_lodi = pocet_lodi_;

        obsah = new Policko[sirka*vyska];

        for (int i = 0; i < obsah.length; i++) {    // vytvoreni odkazu v poli objektu
            obsah[i] = new Policko();
        }

        if (!nahodne){
            for (int i = 0; i < obsah.length; i++) {
                obsah[i].NastavPrazdne();
            }
        }
        else { // nahodne umisteni lodi, prevence opakovani
        while(!KontrolaPoctuLodi())
        {
            int[] nahodne_pozice = new int[pocet_lodi];

            for (int i = 0; i < pocet_lodi; i++) {
                nahodne_pozice[i] = (int)Math.round(Math.random()*(obsah.length-1));
                
                for (int j = 0; j < i; j++) { // prevence opakovani - zabraneni snizeni poctu lodi
                    while(nahodne_pozice[i]==nahodne_pozice[j]){
                        nahodne_pozice[i] = (int)Math.round(Math.random()*(obsah.length-1));
                    }
                }
                obsah[nahodne_pozice[i]].NastavObsazene();
            }
        }
        }

    }
    private Boolean KontrolaPoctuLodi() {
        Boolean vporadku = false;
        int _pocetlodi = 0;

            for (int i = 0; i < obsah.length; i++) {
                if (obsah[i].VypisObsah()==1) _pocetlodi++;
            }
        if (_pocetlodi==pocet_lodi) vporadku=true;

        return vporadku;
    }



    @Override
    public String toString(){
        String retezec = new String();
        int k = 0;

        retezec += "    ";

        for (int i = 0; i < sirka; i++) {
            retezec += " " + (i+1);
        }

        retezec += "\n\n";

        for (int i = 0; i < vyska; i++) {
            retezec += " " + (i+1) + "  ";
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
        boolean zasah;

        zasah = obsah[index_policka].Strelba();

        if (zasah) pocet_lodi--;

        if (zasah) System.out.println("Zasah " + index_policka);

        return zasah;
    }

    byte StavPolicka(int index_policka){
        return obsah[index_policka].VypisObsah();
    }

    int PocetLodi(){
        return pocet_lodi;
    }


}
