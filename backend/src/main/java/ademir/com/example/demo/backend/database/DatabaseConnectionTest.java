package ademir.com.example.demo.backend.database;

import java.sql.*;

class DatabaseConnectionTest
{
	public static void main(String [] args)
	{
		Connection conn = DatabaseConnection.getConnection();
		
		try
		{
			String query = "Select * from role";
			Statement st = conn.createStatement();
			ResultSet rst = st.executeQuery(query);
			
			while(rst.next())
			{
				System.out.println(rst.getString("id")+" "+rst.getString("name"));	
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try{
				conn.close();
			}catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}
		
	}
}