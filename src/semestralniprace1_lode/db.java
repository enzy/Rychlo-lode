package semestralniprace1_lode;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * Obsluha databaze
 */
public class db {

// Nastaveni pristupovych udaju na MySQL server
	private final static String db_server = "webdev.felk.cvut.cz";
	private final static String db_port = "3306";
	private final static String db_user = "simekmat";
	private final static String db_pass = "bsi9oz5p";
	private final static String db_name = "simekmat";
	private final static String db_url = "jdbc:mysql://" + db_server + ":" + db_port + "/" +
			  db_name + "?user=" + db_user + "&password=" + db_pass;
//	Spojeni
	private static Connection db_connection;

// Predpripravene dotazy
	private static PreparedStatement updateTop, insertTop;

// Nazvy tabulek
	private final static String tab_top20 = "lode_top20";

	/**
	 * Vytvoreni spojeni s databazi
	 */
	public db() {
		loadDriver();
		getDBConnection();
	}

	/**
	 * Ziskani Top 20 z databaze
	 * @return ArrayList s Top 20 ve formatu: [poradi, jmeno, score]
	 */
	public static ArrayList<String> getTop20(){

		ArrayList<String> top20 = new ArrayList<String>();
		Statement st = null;
		ResultSet rs = null;

		try {
			// mame spojeni? distak se zkusime pripojit znovu
			if (db_connection == null || !db_connection.isValid(5)) getDBConnection();

			// ziskame data z databaze jako ResultSet a ulozime je ve spravnem tvaru do ArrayListu
			st = db_connection.createStatement();
			rs = st.executeQuery("select * from " + tab_top20 + " order by id asc");
			while(rs.next()){				
				top20.add(rs.getString("id"));
				top20.add(rs.getString("jmeno"));
				top20.add(rs.getString("score"));
			}

			// debug
			// System.out.println("DB TOP 20: " + top20.toString());

		// zpracovani vyjimek
		} catch (SQLException ex) {
            System.err.println("DB: Nepodarilo se vykonat dotaz.");
            sqlException(ex);
      } catch(Exception ex){
				System.err.print(ex.getClass() + ex.getMessage() + ex.getStackTrace());
		}
		// uzavreni
      finally {
			try {
				if (rs != null) rs.close();
            if (st != null) st.close();
				rs = null;
				st = null;
			}
         catch (SQLException ex) {
				System.err.println("DB: Nepodarilo se uvolnit dotaz.");
				sqlException(ex);
         }
      }

		// navraceni
		return top20;
	}

	/**
	 * Ulozeni highscore do databaze
	 * @param top20 - higscore pro ulozeni do databaze
	 * @return uspesnost ulozeni
	 */
	public static boolean setTop20(ArrayList<String> top20){
		boolean uspech = false;								// uspesnost ulozeni

		updateTop = null;				// dotazy pro update a insert
		insertTop = null;
		int pocetradku_db = getRows(tab_top20);		// kolik je aktualne v databazi radku
		int pocetradku_lc = top20.size()/3;				// kolik je radku lokalne
		int pocetupdate;										// kolikrat se bude delat update
		int pocetinsert;										// kolikrat se bude delat insert

		String upd_dotaz = "update " + tab_top20 + " set jmeno = ?, score = ? where id = ?"; // zacatek dotazu pro update
		String ins_dotaz = "insert into " + tab_top20 + " values(?,?,?)"; // zacatek dotazu pro insert
		
		// overeni spravneho formatu, kdy pocet prvku musi byt delitelny 3 (poradi, jmeno, score)
		if((top20.size()%3) != 0 ){
			System.err.println("DB: metoda setTop20 nedostala spravna data");
			return false;
		}

		// vypocet poctu jednotlivych operaci - pocetupdate, pocetinsert
		if(pocetradku_lc >= pocetradku_db) pocetupdate = pocetradku_db;
		else pocetupdate = pocetradku_lc;
		//System.out.println("DB: pocetupdate = " + pocetupdate); // debug

		pocetinsert = pocetradku_lc - pocetradku_db;
		//System.out.println("DB: pocetinsert = " + pocetinsert); // debug
		
		try {			
			// mame spojeni? distak se zkusime pripojit znovu
			if (db_connection == null || !db_connection.isValid(5)) getDBConnection();
			
			// update
			for (int i = 0; i < pocetupdate; i++) {
				updateTop = db_connection.prepareStatement(upd_dotaz);		// priprava dotazu				
				updateTop.setInt(3, i+1);												// poradi
				updateTop.setString(1, top20.get(i*3+1));							// jmeno
				updateTop.setInt(2, Integer.valueOf(top20.get(i*3+2)));		// score
				//System.out.println("DB: udpateTop " + i + ": " + updateTop.toString()); // debug
				updateTop.executeUpdate();	// zapis data do databaze a vycisti dotaz
				updateTop.clearParameters();
				//System.out.println("DB: proveden update: " + i); // debug
			}
					
			// insertTop - pripraveni a naplneni dotazu
			insertTop = db_connection.prepareStatement(ins_dotaz);

			for (int i = 0; i < pocetinsert*3-1; i+=3) {								
				insertTop.setInt(i+1, pocetupdate+i+1);											// poradi
				insertTop.setString(i+2, top20.get(pocetupdate*3+i+1));						// jmeno
				insertTop.setInt(i+3, Integer.valueOf(top20.get(pocetupdate*3+i+2)));	// score
				//System.out.println("DB: insertTop " + i + ": " + insertTop.toString());
				insertTop.executeUpdate();		// zapis data do databaze a vycisti dotaz
				insertTop.clearParameters();
				//System.out.println("DB: proveden insert: " + i/3); // debug
			}			

			uspech = true;
		}
		// zpracovani vyjimek
		catch (SQLException ex) {
            System.err.println("DB: Nepodarilo se vykonat dotaz.");
            sqlException(ex);}
		catch (Exception e) {
			System.err.println(e.getClass() + e.getMessage() + e.getStackTrace() + e.getLocalizedMessage());
		}
		// uzavreni 
      finally {
			try {				
            if (insertTop != null) insertTop.close();
				if (updateTop != null) updateTop.close();
			}
         catch (SQLException ex) {
				System.err.println("DB: Nepodarilo se uvolnit dotaz.");
				sqlException(ex);
         }
      }

		// navraceni uspesnosti operace
		return uspech;
	}

	/**
	 *
	 * @param nazevTabulky
	 * @return Pocet radku v tabulce (nazevTabulky)
	 */
	public static int getRows(String nazevTabulky){
      try
		{
			Statement st = db_connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM " + nazevTabulky);
			rs.next();

			return rs.getInt(1);
		}
		catch(SQLException ex){
			System.err.println("DB: chyba pri ziskavani poctu radku");
			sqlException(ex);
			return 0;
		}

	}
	/**
	 * Nacteni JDBC driveru
	 * @author Ales Pilny
	 */
	public static void loadDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("JDBC driver uspesne nacten.");
		} catch (Exception ex) {
			System.err.println("Nenacetl jsem JDBC driver, chyba: " + ex.getMessage());
		}
	}

	/**
	 * Spojeni s databazi
	 * @author Ales Pilny
	 */
	public static void getDBConnection () {
		try {
			db_connection = DriverManager.getConnection(db_url);
			db_connection.setAutoCommit(true);
			System.out.println("Uspesne jsem se spojil s databazi :)");
		} catch (SQLException ex) {
			db_connection = null;
			System.err.println("Nepodarilo se mi spojit s databazi. Jsi pripojen k internetu?");
			JOptionPane.showMessageDialog(hlavniokno.getFrames()[0],
			"Nepodařilo se mi spojit s databází. Jsi připojen k internetu?",
			"Chyba připojení",
			JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Odpojeni od databaze
	 */
	public static void closeConnection() {
		try {
			if (insertTop != null) insertTop.close();
			insertTop = null;

			if (updateTop != null) updateTop.close();
			updateTop = null;

			if (db_connection != null) db_connection.close();
			db_connection = null;

		} catch (SQLException ex) {
			System.err.println("Nepodarilo se odpojit od databaze.");
			sqlException(ex);
		}
	}

	/**
	 * Zajisti vypis zretezenych SQL vyjimek
	 * @param ex vyjimka
	 * @author Ales Pilny
	 */
	public static void sqlException(SQLException ex) {
		System.err.println("SQL EXCEPTIONS CHAIN: ");
		sqlException(ex, "");
		System.err.println("--------------------------------------");
	}

	/**
	 * Servisni metoda pro public static void sqlException(SQLException ex) realizujici
	 * vypis a odsazovani
	 * @param ex vyjimka
	 * @param odsazeni retezec reprezentujici odsazeni
	 * @author Ales Pilny
	 */
	private static void sqlException(SQLException ex, String odsazeni) {
		if (ex != null) {
			System.err.println(odsazeni + "> SQLException: " + ex.getMessage());
			System.err.println(odsazeni + "> SQLState: " + ex.getSQLState());
			System.err.println(odsazeni + "> VendorError: " + ex.getErrorCode());
			sqlException(ex.getNextException(), odsazeni + "-");
		}
	}

	/**
	 * Testovani db tridy
	 * @param args
	 */
	public static void main(String[] args) {
		
		db.getTop20();
		System.out.println("Pocet radku v databazi: " + db.getRows("lode_top20"));
		ArrayList<String> topdvacet = new ArrayList<String>();
		topdvacet.add("1"); topdvacet.add("Buh"); topdvacet.add("0");
		topdvacet.add("2"); topdvacet.add("Rektor"); topdvacet.add("2");
		topdvacet.add("3"); topdvacet.add("Děkan"); topdvacet.add("3");

		System.out.println("Uspech ulozeni Top 20: " + db.setTop20(topdvacet));
		db.getTop20();
	}
}
