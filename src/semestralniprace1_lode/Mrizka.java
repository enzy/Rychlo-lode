
package semestralniprace1_lode;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * Trida pro vytvoreni komponenu vykreslujiciho mrizku
 */
public class Mrizka extends JPanel{

    @Override
    public void paintComponent(Graphics g){
        int sirka, vyska;
        sirka = (int)Math.round((double)this.getWidth()/7);
        vyska = (int)Math.round((double)this.getHeight()/7);

        for (int i = sirka; i < this.getWidth()-sirka+2; i+=sirka) {
            g.drawLine(i, 0, i, this.getHeight());
        }
        for (int i = vyska; i < this.getHeight()-vyska+2; i+=vyska) {
            g.drawLine(0, i, this.getWidth(), i);
        }
    }
}
