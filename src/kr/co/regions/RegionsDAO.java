package kr.co.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.util.DBConnector;

public class RegionsDAO {
	
	//1. Regions의 모든 데이터 가져오기
	public void getList() throws Exception {
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. Query 문 작성
		String sql = "SELECT * FROM regions";
		
		//3. Query 문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. 
		
		//5. 최종 전송 후 결과를 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("region_id");
			String name = rs.getString("region_name");
			
			outString(id, name);
		}
		
	}
	
	private void outString(int id, String name) {
		System.out.println("대륙코드 : " + id + "  대륙명 : " + name);
	}

}
