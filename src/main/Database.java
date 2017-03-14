package main;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;



public class Database {
	private Connection con  =  null;
	private String url = "jdbc:mysql://localhost/prosjekt"; 
	private String user = "root";
	private String pw = "123";
	


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