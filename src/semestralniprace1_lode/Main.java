/**
 *
 * @author Matej Simek, 3.11.2008
 *         CVUT FEL, matej.simek@gmail.com
 * 
 *                      #######################
 *                      #  SEMESTRALNI PRACE  #
 *                      #######################
 * 
 * termin odevzdani: 31.1.2009
 * vybrane tema: hra Lode
 * pozadavky: oop, prace se souborem
 * 
 * myslenkovy rozbor:
 * 
 * rozmery hraciho pole?? >> pro jednoduchost pevne, odhaduji okolo min. 20x20
 * = 400 poli s poctem lodi volitelny v rozmezi 5-100 (zaplneni 1.25% - 25%)
 *      >>  dvou rozmerne pole (x,y), jako dat. typ bych volil bud boolean anebo
 *          byte, pro rozliseni vice stavu pole (voda, lod, zasah apod.)
 *          a to cele 2x (hrac + protihrac)
 * 
 * druha strana / protihrac by byl pocitac = nahodne generovani cisel, pripadne
 * kdyz zbyde cas a nebude se to komplikovat, tak clovek
 * 
 * typ lodi bych ponechal na jednom, nevidim duvod pro vice typu, grafiku uz
 * hotovou mam z minula
 * 
 * zpusob zobrazovani, pokud to pujde rozumne, bych volil vykreslovani do okna
 * pomoci nejakych rutin, velikost bych nechal fixni, pripadne by se hraci plocha
 * pouze centrovala (posun pocatku)
 * v nouzi se to muze vykreslovat do sout, ale opravdu jen v nouzi, protoze se mi
 * to nelibi :D
 * 
 * pokusit se o co nejvíce objektový přístup (viz.: zalozoky)
 *
 *
 * menu viz obr. predloha, ale struktura:
 *      Nova Hra
 *          > hrat s PC
 *              > zadani svych lodi
 *                  > volba tahu v graf. rezimu klikanim na policko
 *      Nejrychlejsi cas
 *          > zobrazeni nejrychlejsi vyhry, ukladani do registru ci normalniho souboru....
 *      Konec Hry
 * 
 * 
 */

package semestralniprace1_lode;

public class Main {

        public static void main(String[] args) {
            
            int pocet_lodi = 10;

            HraciPole PolePocitac = new HraciPole(true, 10, 10, pocet_lodi);
            HraciPole PoleHrac = new HraciPole(false, 10, 10, pocet_lodi);

            System.out.println("debug, nahodne:\n\nPole Pocitac:\n\n" + PolePocitac + "\nPole Hrac:\n\n" + PoleHrac);
            
    }

}
