
package semestralniprace1_lode;

import java.awt.*;
import javax.swing.*;
import java.applet.*;
import java.io.*;

public class hlavniokno extends javax.swing.JFrame {
    /**
     * Image objekty obrazku, se kterymi pracuje okno
     */
    public static Image img_dira, img_hratspc, img_hratskamosem, img_konechry, img_lod,
          img_napislode, img_novahra, img_pozadiocean, img_prohraljsi,
          img_zviteziljsi, img_otaznik;
    /**
     * Hudba na pozadi
     */
    static public AudioClip zvuk_pozadi;
    /**
     * Nejlepsi vysledky
     */
    static public String highscore = "Nej hra";
    /**
     * Boolean informujici o prvnim spusteni metodu pro vytvoreni nove hry
     */
    static public Boolean prvni_spusteni = true;
    /**
     * Demo hra pri spusteni programu
     */
    Hra hra_demo;
    /**
     * Hra proti pocitaci
     */
    Hra hra_pocitac, hra_clovek;
    Hra hra_pocitac_stinova, hra_clovek_stinova;
    /**
     * Zobrazovac hraciho pole
     */
    JBHraciPole hracipole_demo;

    JBHraciPole hracipole_pocitac, hracipole_clovek;
    /**
     * zobrazovac mrizky
     */
    Mrizka mrizka;
    /**
     * zobrazovac pozadi
     */
    ImagePanel hraciplocha_pozadi;

    /** Creates new form hlavniokno */
    public hlavniokno() {
        initComponents();

        jButton_nejcas.setText(highscore);

        // nacteni obrazku ze souboru
        if (img_pozadiocean == null){
            System.out.println("Nacitam grafiku...");

            img_pozadiocean = new ImageIcon(getClass().getResource("/grafika/pozadi-ocean.jpg")).getImage();
            img_dira = new ImageIcon(getClass().getResource("/grafika/dira.gif")).getImage();
            img_hratspc = new ImageIcon(getClass().getResource("/grafika/hrat s PC.gif")).getImage();
            img_hratskamosem = new ImageIcon(getClass().getResource("/grafika/hrat s kamosem.gif")).getImage();
            img_konechry = new ImageIcon(getClass().getResource("/grafika/konechry.jpg")).getImage();
            img_lod = new ImageIcon(getClass().getResource("/grafika/lod.gif")).getImage();
            img_napislode = new ImageIcon(getClass().getResource("/grafika/napislode.jpg")).getImage();
            img_novahra = new ImageIcon(getClass().getResource("/grafika/novahra.jpg")).getImage();
            img_prohraljsi = new ImageIcon(getClass().getResource("/grafika/prohraljsi.jpg")).getImage();
            img_zviteziljsi = new ImageIcon(getClass().getResource("/grafika/zviteziljsi.jpg")).getImage();
            img_otaznik = new ImageIcon(getClass().getResource("/grafika/otaznik.gif")).getImage();
        }

        // nacteni a spusteni zvuku na pozadi
        if (zvuk_pozadi==null){
            System.out.println("Nahravam hudbu na pozadi...");
            zvuk_pozadi = Applet.newAudioClip(getClass().getResource("/zvuk/sea.wav"));
            zvuk_pozadi.loop();
        }

        // pozadi hraci plochy
        hraciplocha_pozadi = new ImagePanel(img_pozadiocean);
        jPanel1.add(hraciplocha_pozadi);
        jPanel1.setComponentZOrder(hraciplocha_pozadi, 5);

        hraciplocha_pozadi.setLocation(jPanel1.getWidth()/2-img_pozadiocean.getWidth(null)/2+1, jLabel1.getHeight()+jLabel1.getY()*2+5);
        hraciplocha_pozadi.setSize(img_pozadiocean.getWidth(null), img_pozadiocean.getHeight(null));
        
        // mrizka - policka hraci plochy
        mrizka = new Mrizka();
        jPanel1.add(mrizka);
        jPanel1.setComponentZOrder(mrizka, 4);

        mrizka.setLocation(hraciplocha_pozadi.getX()+5, hraciplocha_pozadi.getY()+5);
        mrizka.setSize(hraciplocha_pozadi.getWidth()-10, hraciplocha_pozadi.getHeight()-10);
        mrizka.setForeground(new Color(200,200,200));

        // vytvoreni hry pro uvodni obrazovku
        hra_demo = new Hra(99);

        // vykreslovaci a odchytavaci cast hraci plochy, jako tlacitko
        hracipole_demo = new JBHraciPole(hra_demo, mrizka.getWidth(), mrizka.getHeight(), img_lod, img_otaznik, img_dira);
        jPanel1.add(hracipole_demo);
        jPanel1.setComponentZOrder(hracipole_demo, 3);

        hracipole_demo.setLocation(mrizka.getX()+5, mrizka.getY()+5);

    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton_novahra = new javax.swing.JButton();
        jButton_konechry = new javax.swing.JButton();
        jButton_nejcas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton_nahrathru = new javax.swing.JButton();
        jLabel_pruvodce = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rychlo lodě");
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(311, 541));

        jButton_novahra.setBackground(new java.awt.Color(0, 0, 0));
        jButton_novahra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafika/novahra.jpg"))); // NOI18N
        jButton_novahra.setToolTipText("Nová hra");
        jButton_novahra.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(20, 20, 20), 1, true));
        jButton_novahra.setDoubleBuffered(true);
        jButton_novahra.setFocusPainted(false);
        jButton_novahra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_novahra_klik(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                zmenaOkraje(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                zmenaOkrajeZpet(evt);
            }
        });

        jButton_konechry.setBackground(new java.awt.Color(0, 0, 0));
        jButton_konechry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafika/konechry.jpg"))); // NOI18N
        jButton_konechry.setToolTipText("Konec Hry");
        jButton_konechry.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(20, 20, 20), 1, true));
        jButton_konechry.setDoubleBuffered(true);
        jButton_konechry.setFocusPainted(false);
        jButton_konechry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_konechry_klik(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                zmenaOkraje(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                zmenaOkrajeZpet(evt);
            }
        });

        jButton_nejcas.setBackground(new java.awt.Color(0, 0, 0));
        jButton_nejcas.setForeground(new java.awt.Color(255, 255, 255));
        jButton_nejcas.setText("Nejlepší hra");
        jButton_nejcas.setToolTipText("Nejlepší hra a počet tvých tahů");
        jButton_nejcas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(20, 20, 20), 1, true));
        jButton_nejcas.setEnabled(false);
        jButton_nejcas.setFocusPainted(false);
        jButton_nejcas.setFocusable(false);
        jButton_nejcas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                zmenaOkraje(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                zmenaOkrajeZpet(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grafika/napislode.jpg"))); // NOI18N
        jLabel1.setDoubleBuffered(true);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getSize()-1f));
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("2009 © Matěj Šimek [ Enzy ] matej.simek@gmail.com");

        jButton_nahrathru.setBackground(new java.awt.Color(0, 0, 0));
        jButton_nahrathru.setForeground(new java.awt.Color(255, 255, 255));
        jButton_nahrathru.setText("Nahrát hru");
        jButton_nahrathru.setToolTipText("");
        jButton_nahrathru.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(20, 20, 20)));
        jButton_nahrathru.setFocusable(false);
        jButton_nahrathru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_nahranihry(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                zmenaOkraje(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                zmenaOkrajeZpet(evt);
            }
        });

        jLabel_pruvodce.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_pruvodce.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_pruvodce.setText("Vítejte ve hře Rychlo lodě !");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_konechry, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_pruvodce, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_nejcas, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_nahrathru, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                    .addComponent(jButton_novahra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(310, 310, 310)
                .addComponent(jLabel_pruvodce)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton_nejcas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_nahrathru, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_novahra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_konechry)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Zmena border objektu JButton na bilou barvu
     */
    private void zmenaOkraje(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zmenaOkraje
        javax.swing.JButton tlacitko = new javax.swing.JButton();

        tlacitko = (javax.swing.JButton)evt.getSource();

        tlacitko.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
    }//GEN-LAST:event_zmenaOkraje
    /**
     *
     * Zmena border objektu JButton na cernou barvu
     */
    private void zmenaOkrajeZpet(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zmenaOkrajeZpet
        javax.swing.JButton tlacitko = new javax.swing.JButton();

        tlacitko = (javax.swing.JButton)evt.getSource();

        tlacitko.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(20, 20, 20), 1, true));
    }//GEN-LAST:event_zmenaOkrajeZpet
    /**
     *
     * Obsluha udalosti stisknuti tlacitka Konec hry
     */
    private void jButton_konechry_klik(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_konechry_klik
        System.out.println("\nNashledanou :)\n");
        System.exit(0);
    }//GEN-LAST:event_jButton_konechry_klik
    /**
     *
     * Metoda obluhujici klik na start tlacitko, spusteni a vykresleni hry
     */
    private void jButton_novahra_klik(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_novahra_klik
                
        JButton tlacitko = (JButton)evt.getSource();
        
        if (tlacitko.isEnabled()==false) return;
        else {
            tlacitko.setEnabled(false);
            // tlacitko.setVisible(false);
            jButton_nejcas.setEnabled(false);
            jButton_nahrathru.setText("Uložit hru");

            System.out.println("Cisteni...");

            if (prvni_spusteni){
                jPanel1.remove(hracipole_demo);
                prvni_spusteni = false;
            }
            else {
                jPanel1.remove(hracipole_pocitac);
                hra_pocitac = null;
                hra_pocitac_stinova = null;
                hracipole_pocitac = null;
            }            

            System.out.println("Zacinam novou hru...");

            jButton_nejcas.setText("Počet tahů: 0");

            hra_pocitac = new Hra(1);

            System.out.println("Napoveda: "); hra_pocitac.Vypis();

            hra_pocitac_stinova = new Hra(hra_pocitac);            

            hracipole_pocitac = new JBHraciPole(hra_pocitac_stinova, mrizka.getWidth(), mrizka.getHeight(), img_lod, img_otaznik, img_dira);
            jPanel1.add(hracipole_pocitac);
            jPanel1.setComponentZOrder(hracipole_pocitac, 3);

            hracipole_pocitac.setLocation(mrizka.getX()+5, mrizka.getY()+5);
        }

    }//GEN-LAST:event_jButton_novahra_klik

    private void jButton_nahranihry(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_nahranihry
        
        String userDir = System.getProperty("user.dir");
        String fileSeparator = System.getProperty("file.separator");
        String celaCesta = userDir + fileSeparator + "savegame.bin";
        System.out.println(celaCesta);

        File soubor = new File(celaCesta);

        // rozpoznani stavu hry podle priznaku Star tlacitka - je to humus

        if(jButton_novahra.isEnabled()){
            // Nacitani hry, hra totiz neprobiha

      // spusteni nove hry
            jButton_novahra.setEnabled(false);
            // tlacitko.setVisible(false);
            jButton_nejcas.setEnabled(false);
            jButton_nahrathru.setText("Uložit hru");

            System.out.println("Cisteni...");

            if (prvni_spusteni){
                jPanel1.remove(hracipole_demo);
                prvni_spusteni = false;
            }
            else {
                jPanel1.remove(hracipole_pocitac);
                hra_pocitac = null;
                hra_pocitac_stinova = null;
                hracipole_pocitac = null;
            }

            System.out.println("Zacinam novou hru...");

            jButton_nejcas.setText("Počet tahů: 0");

            hra_pocitac = new Hra(1);

            System.out.println("Napoveda: "); hra_pocitac.Vypis();

            hra_pocitac_stinova = new Hra(hra_pocitac);

            hracipole_pocitac = new JBHraciPole(hra_pocitac_stinova, mrizka.getWidth(), mrizka.getHeight(), img_lod, img_otaznik, img_dira);
            jPanel1.add(hracipole_pocitac);
            jPanel1.setComponentZOrder(hracipole_pocitac, 3);

            hracipole_pocitac.setLocation(mrizka.getX()+5, mrizka.getY()+5);

       // nahrani her

            try {
                if (soubor.exists()) {
                    DataInputStream dis = new DataInputStream(new FileInputStream(soubor));

                    hra_pocitac.NacteniHry(dis);
                    hra_pocitac_stinova.NacteniHry(dis);

                    dis.close();

                    NastavStatus("Hra načtena");
                }
                else{
                    NastavStatus("Uložená hra neexistuje");
                }

            }
            catch (IOException ex) {
                System.out.println("Ups, tak jsme nic neprecetli ani nezapsali, hold mame spatne konstelace hvezd, zkusme to za nejaky cas...");
        }

        }
        else {
            // Ukladani hry, hra probiha

        try {            

            if (!soubor.exists()) {
                soubor.createNewFile();
            }
            
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(soubor));
            
            hra_pocitac.UlozeniHry(dos);
            hra_pocitac_stinova.UlozeniHry(dos);

            dos.close();

            NastavStatus("Hra uložena");

        }
        catch (IOException ex) {
                System.out.println("Ups, tak jsme nic neprecetli ani nezapsali, hold mame spatne konstelace hvezd, zkusme to za nejaky cas...");
        }        

        // return povedlose;

        }
 
    }//GEN-LAST:event_jButton_nahranihry

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hlavniokno().setVisible(true);
            }
        });
    }
    public static void NastavStatus(String s){
        jLabel_pruvodce.setText(s);
    }
    public static void NastavNejTlacitko(String s){
        NastavHighscore(s);
        jButton_nejcas.setText(highscore);
    }
    public static void NastavHighscore(String h){
        highscore = h;
    }
    public static void NastavStart(Boolean b){
        jButton_novahra.setEnabled(b);
    }
    public static void NastavNahratHru(Boolean b){
        if (b) jButton_nahrathru.setText("Nahrát hru");
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton jButton_konechry;
    private static javax.swing.JButton jButton_nahrathru;
    private static javax.swing.JButton jButton_nejcas;
    private static javax.swing.JButton jButton_novahra;
    private static javax.swing.JLabel jLabel1;
    private static javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel jLabel_pruvodce;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
