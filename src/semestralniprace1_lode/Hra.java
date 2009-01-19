
package semestralniprace1_lode;

import java.applet.*;
import java.io.*;

/**
 *
 * Trida pro tvoreni instanci jednotlivých her
 */
public class Hra implements Serializable{

    HraciPole Pole, Stinove_pole;
    /**
     * 0 clovek, 1 pocitac, 99 demo ...
     */
    int typ_hry;
    int pocet_lodi = 10;
    int pocet_strel = 0;
    Boolean probiha = true;
    Boolean stinova = false;

    static public AudioClip zvuk_exploze;
    static public AudioClip zvuk_splouchnuti;
    static public AudioClip zvuk_potlesk;
    static public AudioClip zvuk_pohreb;

    public Hra(){

        if (zvuk_exploze == null) System.out.println("Nahravam zvukove efekty...");
        if (zvuk_exploze == null) zvuk_exploze = Applet.newAudioClip(getClass().getResource("/zvuk/explosion.wav"));
        if (zvuk_splouchnuti == null) zvuk_splouchnuti = Applet.newAudioClip(getClass().getResource("/zvuk/splash.wav"));
        if (zvuk_potlesk == null) zvuk_potlesk = Applet.newAudioClip(getClass().getResource("/zvuk/applause.wav"));
        if (zvuk_pohreb == null) zvuk_pohreb = Applet.newAudioClip(getClass().getResource("/zvuk/funeral.wav"));        

    }

    public Hra (int typhry){
        this();

        typ_hry = typhry;

        switch(typ_hry){
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

    // obsluha strelby + vyhodnoceni
    void Strelba(int index_policka){
        if (!probiha) return;
        Boolean zasah = false;                       

        if (!stinova)
            zasah = Pole.Strelba(index_policka);
        else {
            zasah = Stinove_pole.Strelba(index_policka);
            if(zasah){
                Pole.obsah[index_policka].NastavPotopene();
                zvuk_exploze.play();
                pocet_strel++;
                hlavniokno.NastavNejTlacitko("Počet tahů: " + pocet_strel);

                if (Stinove_pole.PocetLodi() == 0){
                    if (typ_hry == 0)
                        Ukonceni(true);
                    else if (typ_hry == 1)
                        Ukonceni(false);
                }
            }
            else
                if (Pole.StavPolicka(index_policka)==0){
                    Pole.obsah[index_policka].NastavProhledane();
                    zvuk_splouchnuti.play();
                    pocet_strel++;
                    hlavniokno.NastavNejTlacitko("Počet tahů: " + pocet_strel);
                }                
        }
        // ......... obshluha strelby
    }

    byte StavPolicka(int index){
        return Pole.StavPolicka(index);
    }
    
    public Boolean isRunning(){
        return probiha;
    }

    /**
     *
     * Ukonceni hry a potrebne ukony
     */
    void Ukonceni(Boolean vyhra){

        probiha = false;

        hlavniokno.NastavStart(true);
        hlavniokno.NastavNahratHru(true);

        if (vyhra){
            zvuk_potlesk.play();
            System.out.println("\n(" + pocet_strel + ")Konec hry, vyhral jsi :)");
        }
        else {
            zvuk_pohreb.play();
            System.out.println("\n(" + pocet_strel + ")Konec hry, vyhral jsem, HA, HA, HA 8-)");
        }

        if(typ_hry==0)
            UlozeniHighScore();
        
    }
    void Vypis(){
        System.out.println(Pole);
    }

    /**
     *
     * Ukladani highscore do souboru
     */
    Boolean UlozeniHighScore(){
        Boolean povedlose = false;
        int starescore = Integer.MAX_VALUE;

        try {

            String userDir = System.getProperty("user.dir");
            String fileSeparator = System.getProperty("file.separator");
            String celaCesta = userDir + fileSeparator + "highscore.bin";
            System.out.println(celaCesta);

            File soubor = new File(celaCesta);

            if (!soubor.exists()) {
                soubor.createNewFile();                
            }
            else {
                try {
                    DataInputStream dis = new DataInputStream(new FileInputStream(soubor));
                    starescore = dis.readInt();
                    if (starescore==0) starescore = Integer.MAX_VALUE;
                    dis.close();
                }
                catch(IOException ex){
                    System.out.println("Jeste nikdo nic nenahral, to je skoda...");
                    starescore = Integer.MAX_VALUE;
                }
            }
            
            if (starescore > pocet_strel){
                starescore = pocet_strel;
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(soubor));
                dos.writeInt(starescore);
                dos.close();

                hlavniokno.NastavStatus("Blahopřeji! Zahrál jsi zatím nejlepší hru.");
            }
            else{
                hlavniokno.NastavStatus("To bylo špatné, zkus to znovu ;)");
            }

            povedlose = true;

        }
        catch (IOException ex) {
                System.out.println("Ups, tak jsme nic neprecetli ani nezapsali, hold mame spatne konstelace hvezd, zkusme to za nejaky cas...");
        }

        hlavniokno.NastavNejTlacitko("Nej hra: " + starescore);

        return povedlose;
    }

    /**
     *
     * Neimplementovano zatim
            void UlozeniHry(){}
            void NacteniHry(){}
    */
    
}
