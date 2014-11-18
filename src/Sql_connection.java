import java.sql.*;

class Sql_connection 
{
	public static Connection dbConn;

	public static Connection getConnection(){
	if(dbConn ==null){
		try{
			 String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
			String dbId = "scott";
			String dbPass = "trwthlogic5";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			dbConn = DriverManager.getConnection(jdbcUrl,dbId,dbPass);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}
	return dbConn;
}
public static void close(){
	if(dbConn != null){
		try{
			if(!dbConn.isClosed())
				dbConn.close();
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	dbConn=null;
	}
}