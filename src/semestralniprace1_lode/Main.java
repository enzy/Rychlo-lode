/**
 *
 * @author Matej Simek, 3.11.2008 - 25.5.2009
 *         CVUT FEL, matej.simek@gmail.com
 * 
 *                      #######################
 *                      #  SEMESTRALNI PRACE  #
 *                      #######################
 *
 *
 *      ______              __     __          __           __
 *     |   __ \.--.--.----.|  |--.|  |.-----. |  |.-----.--|  |.-----.
 *     |      <|  |  |  __||     ||  ||  _  | |  ||  _  |  _  ||  -__|
 *     |___|__||___  |____||__|__||__||_____| |__||_____|_____||_____|
 *             |_____|
 *
 *
 *
 *
 *  SVN: http://code.google.com/p/matejsimek-alg1-semestralniprace/
 *  VIZ.: DOKUMENTACE : dokumentace.pdf
 */

package semestralniprace1_lode;

import java.io.*;

public class Main {

    @SuppressWarnings("static-access")
        public static void main(String[] args) {
            
// nacteni highscore
            System.out.println("Ctu highscore...");

            String userDir = System.getProperty("user.dir");
            String fileSeparator = System.getProperty("file.separator");
            String celaCesta = userDir + fileSeparator + "highscore.bin";
            File soubor = new File(celaCesta);

            if (!soubor.exists()) {
                try {
                    soubor.createNewFile();
                }
                catch (IOException ex){
                    System.out.println("Tak prej dneska máme smůlu. Chlapy, balíme to!");
                }

                hlavniokno.NastavHighscore("Zahraj nej score");
            }
            else {
                try {
                    DataInputStream dis = new DataInputStream(new FileInputStream(soubor));
                    hlavniokno.NastavHighscore("Nej hra: " + dis.readInt());
                    dis.close();
                }
                catch(IOException ex){
                    System.out.println("Jeste nikdo nic nenahral, to je skoda...");
                    hlavniokno.NastavHighscore("Zahraj nej score");
                }
            }

// predani ovladani hlavnimu oknu

            System.out.println("Vytvarim okno...");
            
            hlavniokno.main(args);
            
    }

}
