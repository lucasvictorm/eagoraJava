package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sql {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub
	Statement s = null;
	Connection connection = null;
	public void conectar() {
		
		    try {
		    	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poo", "root", "");
		    	System.out.println("Sucesso");
		    	
		    }
		         
		     catch (SQLException e) {
		          System.out.println("Erro");
		    }
	}
	
	public ResultSet fazerQuery(String query){
		    
		    try {
				s = connection.createStatement();
				String sql = query;
				
				ResultSet resultado = s.executeQuery(sql);
				
				return resultado;
	                
	            
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		    		
	}
	
	public void insertQuery(String query){
	    
	    try {
			s = connection.createStatement();
			String sql = query;
			
			s.executeUpdate(sql);
			
			
                
            
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    		
}

}
