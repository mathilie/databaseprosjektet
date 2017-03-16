package main;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;



public class Database {
	private Connection con  =  null;
	private String url = "jdbc:mysql://localhost/prosjekt"; 
	private String user = "root";
	private String pw = "123";

	
	
	public static final String ØVELSE = "øvelse(øvelse_ID, navn, beskrivelse)";
	public static final String ØVELSE_K = "øvelse_kondisjon(kondisjons_ID, lengde, tid)";
	public static final String ØVELSE_S = "øvelse_styrke(styrke_ID, repetisjoner, sett)";
	public static final String ØVELSESHARKATEGORI = "øvelseharkategori(øvelse_ID, kategori_ID)";
	public static final String INNENDØRS = "innendørs(treningsøkt_ID, luft, ventilasjon,antall tilskuere)";
	public static final String KATEGORI = "kategori(kategori_ID)";
	public static final String KATEGORI_S = "kategori_styrke(kroppsdel_ID, kroppsdel)";
	public static final String KONDISJONSØKTHARØVELSE = "kondisjonsøktharøvelse(resultat, kondisjonsøkt_ID, kondisjonsøvelse_ID)";
	public static final String LAGDUTFRA = "lagdutfra(treningsøkt_ID, mal_ID))";
	public static final String MALHARØVELSE = "malharøvelse(mal_ID, maløvelse_ID)";
	public static final String NOTAT = "notat(treningstips, treningsformål, treningsøkt_ID)";
	public static final String PULS = "puls-og gps-informasjon(treningsøkt_ID, puls, lengdegrad, breddegrad, meter over havet, tid)";
	public static final String STYRKEØKTHARØVELSE = "styrkeøktharøvelse(styrkeøkt, styrkeøvelse, resultat)";
	public static final String TRENINGSØKT = "treningsøkt(treningsøkt_ID, dato, tidspunkt, varighet, dagsform)";
	public static final String TRENINGSØKTMAL = "treningsøktmal(mal_ID, navn)";
	public static final String UTENDØRS = "utendørs(treningsøkt_ID, temperatur, værtyper)";
	public static final String KATEGORI_K = "kategori_kondisjon(kategori_ID, intensitet)";
	public static final int STYRKE = 1;
	public static final int KONDISJON = 0;
	
	
	//TODO: skrive getØvelser og sØnnt slik at folka kan skrive riktige spØrsmØl. Deretter addTreningsØkt metoder med inputliste med Øvelser.
	
	//----------------GET SHIT------------------------
	
	public String[] getKondisjonsTips(){
		try {
			connect();
			Statement s = con.createStatement();
			String query = "SELECT treningstips FROM notat WHERE treningsøkt_ID IN (SELECT kondisjonsøkt_ID FROM kondisjonsøktharøvelse)";
			ResultSet rs = s.executeQuery(query);
			ArrayList<String> returnList = new ArrayList<String>();
			while (rs.next()) returnList.add(rs.getString(1));
			return (String[]) returnList.toArray();
			} catch (SQLException e) {e.printStackTrace();
			} finally {
				close();
			}
			return null;
	}
	
	public String[] getStyrkeTips(){
		try {
			connect();
			Statement s = con.createStatement();
			String query = "SELECT treningstips FROM notat WHERE treningsøkt_ID IN (SELECT styrkeøkt FROM styrkeøktharøvelse)";
			ResultSet rs = s.executeQuery(query);
			ArrayList<String> returnList = new ArrayList<String>();
			while (rs.next()) returnList.add(rs.getString(1));
			return (String[]) returnList.toArray();
			} catch (SQLException e) {e.printStackTrace();
			} finally {
				close();
			}
			return null;
	}
	
	public String[] getPuls(String treningsID){
		return getList(PULS, "treningsøkt_ID", treningsID, "*");
	}
	
	public String[] getNotat(String treningsID){
		return getList(NOTAT,"treningsøkt_ID", treningsID, "*");
	}
	
	
	public List<String> getMaler() {
		try {
			connect();
			Statement s = con.createStatement();
			String query = "SELECT Mal_ID navn FROM "+TRENINGSØKTMAL.split("(")[0]+";";
			ResultSet rs = s.executeQuery(query);
			ArrayList<String> returnList = new ArrayList<String>();
			while (rs.next()) returnList.add(rs.getString(1)); returnList.add(rs.getString(2));
			return returnList;
			} catch (SQLException e) {e.printStackTrace();
			} finally {
				close();
			}
			return null;
	}
	
	//Get alle Øvelser
	public List<String> getØvelser(){
		try {
		connect();
		Statement s = con.createStatement();
		String query = "SELECT øvelse_ID navn FROM "+ØVELSE.split("(")[0]+";";
		ResultSet rs = s.executeQuery(query);
		ArrayList<String> returnList = new ArrayList<String>();
		while (rs.next()) returnList.add(rs.getString(1)); returnList.add(rs.getString(2));
		return returnList;
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}
	
	
	//alle Øvelser 
	public List<String> getØvelser(String treningsID){
		try {
			connect();
			Statement s = con.createStatement();
			String query = "SELECT øvelse_ID navn FROM "+ØVELSE.split("(")[0]+" WHERE trenings_ID= "+treningsID+";";
			ResultSet rs = s.executeQuery(query);
			ArrayList<String> returnList = new ArrayList<String>();
			while (rs.next()) returnList.add(rs.getString(1)); returnList.add(rs.getString(2));
			return returnList;
			} catch (SQLException e) {e.printStackTrace();
			} finally {
				close();
			}
			return null;
	}
	
	public List<String> getØkter(){
		try {
		connect();
		Statement s = con.createStatement();
		String query = "SELECT treningsøkt_ID FROM "+TRENINGSØKT.split("(")[0]+";";
		ResultSet rs = s.executeQuery(query);
		ArrayList<String> returnList = new ArrayList<String>();
		while (rs.next()) returnList.add(rs.getString(1));
		return returnList;
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}
	
	public List<String> getKategorier(){
		return null;
	}
	
	public List<String> getNotat(int treningsØktID){
		try {
		connect();
		Statement s = con.createStatement();
		String query = "SELECT * FROM "+NOTAT.split("(")[0]+" WHERE treningsøkt_ID="+treningsØktID+";";
		ResultSet rs = s.executeQuery(query);
		ArrayList<String> returnList = new ArrayList<String>();
		while (rs.next()) returnList.add(rs.getString(1)); returnList.add(rs.getString(2));
		return returnList;
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}
	
	
	
	
	/*****************************************************
	 * 
	 * LAGE ØKTER
	 * 
	 * 
	 *****************************************************/
	
	public void lagUtTreningFraMal(String MalID){
		String[] Øvelser = getList(MALHARØVELSE, "mal_ID", MalID, "maløvelse_ID");
	}
	public void lagInnTreningFraMal(String MalID){
		String[] Øvelser = getList(MALHARØVELSE, "mal_ID", MalID, "maløvelse_ID");
	}
	public void lagStyrkeTreningFraMal(String MalID){
		String[] Øvelser = getList(MALHARØVELSE, "mal_ID", MalID, "maløvelse_ID");
	}
	
	public void settPulsData(String treningsØkt_ID, String puls, String lengdegrad, String breddegrad,String moh,String tid){
		insert(PULS, new String[]{treningsØkt_ID, puls, lengdegrad, breddegrad, moh, tid});
	}
	
	public void lagNotat(String treningsID, String tips,String formØl){
		insert(NOTAT,new String[] {tips, formØl,treningsID});
	}
	
	public void lagMal(String treningsID, String navn){
		insert(TRENINGSØKTMAL, new String[] {navn});
		List<String> maler = getMaler();
		String malID = maler.get(maler.size()-2);
		insert(LAGDUTFRA, new String[] {treningsID,malID});
		List<String> Øvelser = getØvelser(treningsID);
		for(int i=0;i<Øvelser.size();i+=2) insert(MALHARØVELSE,  new String[] {malID,Øvelser.get(i)});
	}

	
	public void lagStyrkeØvelse(String navn, String beskrivelse, String repetisjoner, String sett){
		String id = lagØvelse(navn, beskrivelse);
		insert(ØVELSE_S, new String[] {id,repetisjoner, sett});
	}
	
	public void lagKondisjonsØvelse(String navn, String beskrivelse, String lengde, String tid){
		String id = lagØvelse(navn, beskrivelse);
		insert(ØVELSE_K, new String[] {id, lengde, tid});
	}

/*	public void lagStyrkeØkt(String dato, String tidspunkt, String varighet, String dagsform, String[] Øvelser, String[] resultater){
		String treningsID = lagTrening(dato, tidspunkt, varighet, dagsform);
		if(Øvelser.length==resultater.length){
			for(int i=0;i<Øvelser.length;i++) insert(STYRKEØKTHARØVELSE, new String[] {treningsID, Øvelser[i],resultater[i]});
		}
	}*/
	
	public void lagInnendØrsØkt(String dato, String tidspunkt, String varighet, String dagsform, String[] Øvelser, String[] resultater, String luft, String ventilasjon, String tilskuere, int SorK){
		String treningsID = lagTrening(dato, tidspunkt, varighet, dagsform);
		if(Øvelser.length==resultater.length){
			if(SorK==KONDISJON) for(int i=0;i<Øvelser.length;i++) insert(KONDISJONSØKTHARØVELSE, new String[] {resultater[i],treningsID, Øvelser[i]});
			if(SorK==STYRKE) for(int i=0;i<Øvelser.length;i++) insert(STYRKEØKTHARØVELSE, new String[] {resultater[i],treningsID, Øvelser[i]});
		}
		insert(INNENDØRS, new String[] {treningsID, luft,ventilasjon, tilskuere});
	}
	
	public void lagUtendØrsØktØkt(String dato, String tidspunkt, String varighet, String dagsform, String[] Øvelser, String[] resultater, String temp, String vØr, int SorK){
		String treningsID = lagTrening(dato, tidspunkt, varighet, dagsform);
		if(Øvelser.length==resultater.length){
			if(SorK==KONDISJON) for(int i=0;i<Øvelser.length;i++) insert(KONDISJONSØKTHARØVELSE, new String[] {resultater[i],treningsID, Øvelser[i]});
			if(SorK==STYRKE) for(int i=0;i<Øvelser.length;i++) insert(STYRKEØKTHARØVELSE, new String[] {resultater[i],treningsID, Øvelser[i]});
		}
		insert(UTENDØRS, new String[] {treningsID, temp, vØr});
	}
	
	
	private String lagTrening(String dato, String tidspunkt, String varighet, String dagsform){
		insert(TRENINGSØKT, new String[] {dato, tidspunkt, varighet, dagsform});
		List<String> Økter = getØkter();
		String treningsID = Økter.get(Økter.size()-1);
		return treningsID;
	}
	
	
	
	private String lagØvelse(String navn, String beskrivelse){
		insert(ØVELSE, new String[] {navn, beskrivelse});
		List<String> Øvelser = getØvelser();
		String ØvelsesID = Øvelser.get(Øvelser.size()-2);
		return ØvelsesID;
	}
	

	
	
	
	
	/*************************************************************************
	---------------------Metoder fra PU-----------------------------------
	 * 
	 * 
	 * 
	 * @param tableName
	 * @param args
	 **************************************************************************/

	public void insert(String tableName, String[] args){
		try{
			connect();
			Statement s = con.createStatement();
			//Making insert query
			String values = "(";
			for (String arg:args) values+=arg+",";
			values = values.substring(0, values.length()-1);
			String query = "INSERT INTO "+tableName+" VALUES "+values+");";
			
			s.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("insert command failed");
			e.printStackTrace();
		}finally{
			close();
		}
	}
	

	public double getAverage(String table, String idColumn, int id){
		String query = "SELECT AVG(ranking) FROM "+table+" WHERE " +idColumn+"="+id;
		try {
			Statement s = con.createStatement();
			ResultSet r = s.executeQuery(query);
			if (r.next()){
				return r.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0.0;
	}
	public int getInt(String from, String what, String condition1, String condition2){
		return 0;
	}
	
	public String getString(String from, String what, String Condition1,String Condition2){
		return null;
	}
	
	
	/**
	 * Sends a query which returns a list.
	 * @param table
	 * @param condition1
	 * @param condition2
	 * @param what
	 * @return
	 */
	public String[] getList(String table, String condition1, String condition2, String... what){
		Statement s;
		try {
			s = con.createStatement();
		String what2="";
		for(String w:what) what2+=" "+w;
		String query = "SELECT"+what2+" FROM "+table.split("(")[0]+"WHERE "+condition1+"="+condition2+";";
		ResultSet rs = s.executeQuery(query);
		int numCol = rs.getMetaData().getColumnCount();
		ArrayList<String> list = new ArrayList<String>();
		while(rs.next()) {
			for(int i=1;i<=numCol;i++){
				list.add(rs.getString(i));
			}
			list.add("NEXT");
		}
		list.remove(list.size()-1);
		list.add("END");
		return (String[]) list.toArray();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Used by testclass to test connection. 
	 * @return true if method finishes (connection opens and closes)
	 */
	public boolean testConnection(){
			connect();
			close();
		return true;
	}
	
	
	/**
	 * Connects to database
	 */
	private void connect(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url,user,pw);
			System.out.println("Tilkoblingen fungerte.");
			  } catch (SQLException ex) {
			    System.out.println("Tilkobling feilet: "+ex.getMessage());
			  } catch (ClassNotFoundException ex) {
			    System.out.println("Feilet under driverlasting: "+ex.getMessage());
			  } catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  } catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  } 
	}
	
	
	/**
	 * Closes database connection
	 */
	private void close(){
		{
		    try {
		      if (con !=  null) con.close();
		    } catch (SQLException ex) {
		      System.out.println("Epic fail: "+ex.getMessage());
		    }
		  }
	}
	

	/**
	 * testing method.
	 */
	public static void main(String[] args) {
		Database sdc = new Database();
		sdc.testConnection();
		
		
	}

}