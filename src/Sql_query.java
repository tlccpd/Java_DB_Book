import java.sql.*;

public class Sql_query implements Sql_query_interface 
{
	
	
	PreparedStatement pstmt;
	ResultSet rs;
	String sql_a, sql_b;
	Connection conn = Sql_connection.getConnection();
	String[] data;
	Test test;

	public Sql_query(){
		if(conn==null){
			System.out.println("[WARNNING]DB Disconnected");
			System.exit(0);
		}else{
			System.out.println("[OK]DB Connected");
			
		}
	}
	public void insert_date(String str, String strb, String strc, String strd){
		try{
			sql_a="select * from eBook_item where e_code=?";
			pstmt = conn.prepareStatement(sql_a,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1,str);
			rs = pstmt.executeQuery();
			
		if(rs.first()==false){
			
			sql_b="INSERT INTO eBook_item(e_code,e_title,e_price,e_totalStoke) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql_b);		
							
				pstmt.setString(1,str);
				pstmt.setString(2,strb);
				pstmt.setString(3,strc);
				pstmt.setString(4,strd);
				pstmt.executeUpdate();			
					
			}
				
			/*int result= ;
			
			if(result ==1){
				System.out.println("Success for insert Query");
			} else {
			System.out.println("===== SQL Insert Error | public void insert_date =====");
			System.out.println("입력하신 "+rs.getString("e_code")+"는 중복됩니다. 변경해주세요.");
			System.out.println("===== End");
			}*/
			
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void dayOfTheWeek(){
	}
	@Override
	public void delete_table(String code) {
		// TODO Auto-generated method stub
		sql_b="delete eBook_item where e_code=?";
		try {
			pstmt = conn.prepareStatement(sql_b);
			pstmt.setString(1,code);
			pstmt.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public ResultSet select(){
		sql_b="select * from eBook_item";
		try{
			pstmt = conn.prepareStatement(sql_b);
			rs=pstmt.executeQuery();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
}