
package semestralniprace1_lode;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class JBHraciPole extends JButton{

    Hra hra;
    Image lod, otaznik, dira;
    private int sirka_policka, vyska_policka;
    private int sirka, vyska;

    public JBHraciPole (Hra hra_, int sirka_, int vyska_,Image lod_, Image otaznik_, Image dira_){
        hra = hra_;
        lod = lod_;
        otaznik = otaznik_;
        dira = dira_;

        setSize(sirka_, vyska_);

        sirka_policka = (int)Math.round((double)sirka_/7);
        vyska_policka = (int)Math.round((double)vyska_/7);
        sirka = sirka_policka * 7;
        vyska = vyska_policka * 7;

        setBorderPainted(false);
        setContentAreaFilled(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                mysKlik(evt);
            }
        });
    }

    public void mysKlik(MouseEvent e){
        if(e.getButton() != MouseEvent.BUTTON1) return;

        int px = e.getX() + 5;
        int py = e.getY() + 5;

        if(px >= sirka || py >= vyska) return; // klik mimo policka

        int index_policka; // y*7 + x

        index_policka = (py/vyska_policka)*7 + (px/sirka_policka);

        hra.Strelba(index_policka);

        // debug //  System.out.println("Klik na x:" + px + ", y:" + py);
        // debug // System.out.println("index: " + index_policka);
        // debug // System.out.println(sirka_policka + " " + vyska_policka + " " + sirka + " " + vyska);

    }

    @Override
    public void paintComponent(Graphics g){
        int sirka, vyska;
        sirka = (int)Math.round((double)this.getWidth()/7);
        vyska = (int)Math.round((double)this.getHeight()/7);

        int k2 = 0;

        for (int i = 0; i < this.getHeight()-vyska+2; i+=vyska) {
            for (int j = 0; j < this.getWidth()-sirka+2; j+=sirka) {
                switch(hra.StavPolicka(k2)){
                    case 0:
                        g.drawImage(otaznik, j, i, null);
                        break;
                    case 1:
                        g.drawImage(lod, j, i, null);
                        break;
                    case 2:
                        g.drawImage(dira, j, i, null);
                        break;
                    case 3:
                        break;
                }

                k2++;

            }
        }

    }


}
