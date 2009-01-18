
package semestralniprace1_lode;

import java.applet.*;


public class Hra {

    HraciPole Pole, Stinove_pole;
    /**
     * 0 clovek, 1 pocitac, 99 demo ...
     */
    int Typ_hry;
    int pocet_lodi = 10;
    Boolean stinova = false;

    AudioClip zvuk_exploze;
    AudioClip zvuk_splouchnuti;
    AudioClip zvuk_potlesk;
    AudioClip zvuk_pohreb;

    public Hra(){

        System.out.println("Nahravam zvukove efekty...");
        zvuk_exploze = Applet.newAudioClip(getClass().getResource("/zvuk/explosion.wav"));
        zvuk_splouchnuti = Applet.newAudioClip(getClass().getResource("/zvuk/splash.wav"));
        zvuk_potlesk = Applet.newAudioClip(getClass().getResource("/zvuk/applause.wav"));
        zvuk_pohreb = Applet.newAudioClip(getClass().getResource("/zvuk/funeral.wav"));

    }

    public Hra (int typhry){
        this();

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
    public Hra (Hra stinova_hra){
        this();

        stinova = true;
        Pole = new HraciPole(false, 7, 7, 10);
        Stinove_pole = stinova_hra.Pole;
    }

    void Strelba(int index_policka){
        Boolean zasah;
        if (!stinova)
            zasah = Pole.Strelba(index_policka);
        else
            zasah = Stinove_pole.Strelba(index_policka);
            if(zasah){
                Pole.obsah[index_policka].NastavPotopene();
                zvuk_exploze.play();
            }
            else
                if (Pole.StavPolicka(index_policka)==0){
                    Pole.obsah[index_policka].NastavProhledane();
                    zvuk_splouchnuti.play();
                }


        // ......... obshluha strelby
    }

    byte StavPolicka(int index){
        return Pole.StavPolicka(index);
    }

    void Start(){        
        
        Pole = new HraciPole(true, 10, 10, pocet_lodi);
        // PoleHrac = new HraciPole(false, 10, 10, pocet_lodi);

    }
    void Ukonceni(Boolean vyhra){

        if (vyhra){
            zvuk_potlesk.play();
        }
        else {
            zvuk_pohreb.play();
        }
        
    }
    void Vypis(){
        System.out.println(Pole);
    }
    void Vyhodnoceni(){

    }
    void UlozeniHry(){

    }
    void NacteniHry(){

    }

    
}
