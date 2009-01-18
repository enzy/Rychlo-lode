
package semestralniprace1_lode;

public class Hra {

    HraciPole Pole;
    int Typ_hry; // 0 clovek, 1 pocitac ...
    int pocet_lodi = 10;

    public Hra (int typhry){
        Typ_hry = typhry;

        switch(Typ_hry){
            case 0:
                break;
            case 1:
                Pole = new HraciPole(true, 7, 7, pocet_lodi);
                break;
            case 99:
                Pole = new HraciPole(true, 7);
                break;
        }
    }

    byte StavPolicka(int index){
        return Pole.StavPolicka(index);
    }

    void Start(){        
        
        Pole = new HraciPole(true, 10, 10, pocet_lodi);
        // PoleHrac = new HraciPole(false, 10, 10, pocet_lodi);

    }
    void Ukonceni(){

    }
    void Vypis(){
        // System.out.println("debug, nahodne:\n\nPole Pocitac:\n\n" + PolePocitac + "\nPole Hrac:\n\n" + PoleHrac);
    }
    void Vyhodnoceni(){

    }
    void UlozeniHry(){

    }
    void NacteniHry(){

    }

    
}
