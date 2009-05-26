
package semestralniprace1_lode;

import java.util.ArrayList;

/**
 *
 * Trida pro obsluhu TOP 20 score
 * 
 */
public class Top20 {

	ArrayList<String> top20;

	private int min; // nejmensi pocet tahu - lepsi
	private int max; // nejvetsi pocet tahu - horsi

	private int[] poradi; // pole s pocty tahu

	public Top20() {
		this.aktualizuj();
	}

	/**
	 * Aktualizuje top 20 udaje
	 */
	public void aktualizuj(){
		top20 = db.getTop20();

		poradi = new int[top20.size()/3];

		for (int i = 0; i < poradi.length; i++) {
			if((i*3 + 2) < top20.size()){
			poradi[i] =	Integer.valueOf(top20.get(i*3 + 2));
			}
		}				
	}

	/**
	 * 
	 * @return Nejmensi pocet tahu
	 */
	public int getMin(){
		min = Integer.MAX_VALUE;
		// System.out.println("Hledam minumum z: " + poradi.toString()); // debug

		for (int i = 0; i < poradi.length; i++) {
		 if (poradi[i]<min) min=poradi[i];
		}

		return min;
	}
	/**
	 *
	 * @return Nejvetsi pocet tahu, v pripade zaznamu mene nez 20 vraci MAX_VALUE
	 */
	public int getMax(){
		max = Integer.MIN_VALUE;
		// String message = "Hledam maximum z: "; // debug

		for (int i = 0; i < poradi.length; i++) {
			if(poradi[i]>max) max=poradi[i];
			// message += poradi[i] + ", "; // debug
		}
		// System.out.println(message); // debug

		if(top20.size()/3 < 20) return Integer.MAX_VALUE;
		return max;
	}

	/**
	 * Zapise score do highscore top20
	 * @param jmeno
	 * @param pocettahu
	 */
	public boolean putScore(String jmeno, int pocettahu){

		boolean uspech = false;
		int pozice = Integer.MAX_VALUE;

		// najdi pozici - poradi
		if (pocettahu >= poradi[poradi.length-1]){
			pozice = poradi.length+1;
			top20.add(String.valueOf(pozice));
			top20.add(jmeno);
			top20.add(String.valueOf(pocettahu));
			System.out.println("Pozice: " + pozice);
		} 
		else {
			for (int i = poradi.length-1; i >= 0; i--){
				if(pocettahu < poradi[i]) pozice = i;
			}
			if(pozice!=Integer.MAX_VALUE){
				top20.add(pozice*3, String.valueOf(pozice));
				top20.add(pozice*3 + 1, jmeno);
				top20.add(pozice*3 + 2, String.valueOf(pocettahu));
			}
			System.out.println("Pozice: " + pozice);
		}
		
		// chceme Top 20, ne Top xyxzzzz
		if(top20.size()/3 > 20){
			System.out.println("Moc zaznamu, mazu posledni...");
			top20.remove(top20.size()-1);
			top20.remove(top20.size()-1);
			top20.remove(top20.size()-1);
		}

		// ulozit do databaze
		uspech = db.setTop20(top20);

		// aktualizovat lokalni score
		this.aktualizuj();

		return uspech;
	}

	/**
	 * Navrati pole s poradim, jmenem a poctem tahu na danem radku
	 * @param radek
	 * @return
	 */
	public String[] getRadek(int radek){
		if(radek > top20.size()/3) return null;

		String[] obsahradku = new String[3];
		obsahradku[0]=top20.get((radek-1)*3);
		obsahradku[1]=top20.get((radek-1)*3+1);
		obsahradku[2]=top20.get((radek-1)*3+2);
		return obsahradku;
	}

	/**
	 * Navrati dvourozmerne pole [radek][sloupec - poradi, jmeno, score]
	 * @return
	 */
	public String[][] getVsechnyRadky(){
		String[][] vysledek = new String[20][3];

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 3; j++) {
				vysledek[i][j] = new String("");
			}
		}

		for (int i = 0; i < 20; i++) {
			if(this.getRadek(i+1)!=null) {
				vysledek[i] = this.getRadek(i+1);
			}
		}
		return vysledek;
	}


	/**
	 * Zformatovany vystup highscore
	 * @return
	 */
	public String getFormatedList(){

		String vystup = "<html><body>";				// vystupni zformatovana data
		String[][] pole = this.getVsechnyRadky(); // zdorojova data
		int[] delkyjmen = new int[20];				// delky jmen pro vypocet mezer
		int nejdelsijmeno = Integer.MIN_VALUE;		// delka nejdelsiho jmena pro vypocet mezer
		String mezera = "&nbsp;";								// mezera pro oddeleni zaznamu
		String nr = "<br>\n";							// znak noveho radku
		String bf = ""; // "<b>";								// zvyrazneni zacatek
		String bl = ""; // </b>";								// zvyrazneni konec

		if(pole==null) return "... prazdno ...";

		/*
		 * 1. mezera
		 *		4 mezery pokud je radek do 9 vcetne, 3 mezery nad 10
		 * 2. mezera
		 *		 nejvetsi sirka radku - nejdelsi jmeno
		 *		 nejkratsi mezera - nejvetsi sirka radku + 4 mezery;
		 */

		// zjisteni delky jmen + delky nejdelsiho jmena pro nasledny vypocet mezer
		for (int i = 0; i < pole.length/3; i++) {
			delkyjmen[i] = new Integer(pole[i][1].length());
			if (delkyjmen[i] > nejdelsijmeno) nejdelsijmeno = delkyjmen[i];
		}
		if (nejdelsijmeno>31) nejdelsijmeno = 31;

		// sestaveni formatovaneho retezce
		for (int i = 0; i < pole.length/3; i++) {

			vystup += pole[i][0];									// poradi
			for (int j = 0; j < 3; j++) vystup += mezera;	// za kazdym poradim nejmene 3 mezery
			if (i<9) vystup += mezera;							// za jednotkami o mezeru vic

			if(i<3) vystup += bf;									// zvyrazneni prvnich 3
			if(delkyjmen[i] > 31) vystup += pole[i][1].substring(0, 28) + "..." + mezera + mezera + mezera; // pro zabraneni dlouheho vypisu
			else vystup += pole[i][1];								// jmeno
			if(i<3) vystup += bl;									// zvyrazneni prvnich 3, ukonceni tagu
			
			for (int j = 0; j < (nejdelsijmeno - delkyjmen[i] + 3); j++) vystup += mezera; // mezery za jmeny podle delky

			vystup += pole[i][2];									// pocet tahu
			
			vystup += nr;												// novy radek
		}

		return vystup + "</body></html>";
	}

	@Override
	public String toString() {
		String vypis = "";
		for (int i = 0; i < top20.size(); i+=3) {
			vypis += top20.get(i) + ". " + top20.get(i+1) + "  (" + top20.get(i+2) + ")<br>\n";
		}

		return vypis;
	}

	
	/**
	 * Testovani Top 20 tridy
	 * @param args
	 */
	public static void main(String[] args) {

		Top20 highscore = new Top20();

		System.out.println(highscore);	

		// zapis score
		int pocettahu = 50;
		System.out.println("Highscore max: " + highscore.getMax());

		// pokud je pocettahu mensi nez nejhorsi, vloz ho
		if(pocettahu < highscore.getMax()) highscore.putScore("looser2", pocettahu);

		// vypis higscore
		for (int i = 1; i <= 20; i++) {
			if(highscore.getRadek(i)!=null) {
				System.out.println(highscore.getRadek(i)[0] + " " + highscore.getRadek(i)[1] + " (" + highscore.getRadek(i)[2] + ")");
			}			
		}
		
	}

}
