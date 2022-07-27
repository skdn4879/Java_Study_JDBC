package kr.co.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.util.DBConnector;

public class CountriesDAO {

	public void getList() throws Exception {
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM countries";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			String id = rs.getString("country_id");
			String name = rs.getString("country_name");
			int regionId = rs.getInt("region_id");
			
			outString(id, name, regionId);
			
		}
	}
	
	private void outString(String id, String name, int regionId) {
		System.out.println("국가코드 : " + id + "  국가명 : " + name + "  대륙코드 : " + regionId);
	}
	
}
