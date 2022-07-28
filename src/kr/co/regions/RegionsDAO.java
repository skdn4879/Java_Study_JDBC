package kr.co.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.util.DBConnector;

public class RegionsDAO {
	
	//3. Regions에 데이터 추가
	public int setRegion(RegionsDTO regionsDTO) throws Exception {
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. Query문 작성
		String sql = "INSERT INTO regions VALUES(?, ?)";
		
		//3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ? 가 있으면 값 세팅
		st.setInt(1, regionsDTO.getRegion_id());
		st.setString(2, regionsDTO.getRegion_name());
		
		//5. 최종 전송 후 결과 처리
		// 성공한 row수 반환
		int result = st.executeUpdate();
		
		//6. 자원 해제
		DBConnector.disConnect(st, con);
		
		return result;
		
	}
	
	//2. Regions에서 하나의 결과(Row)
	public RegionsDTO getDetail(int region_id) throws Exception {
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. Query 문 작성
		String sql = "SELECT * FROM regions WHERE region_id = ?";
		
		//3. Query 문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ? 값 세팅
		// WHERE NUM BETWEEN ? AND ? 앞의 ?는 인덱스1번, 뒤의 ?는 인덱스2번
		st.setInt(1, region_id);
		
		//5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		RegionsDTO regionsDTO = null;
		
		if(rs.next()) {
			regionsDTO = new RegionsDTO();
			
			int rId = rs.getInt(1);
			String rName = rs.getString(2);
			
			//outString(rId, rName);
			regionsDTO.setRegion_id(rId);
			regionsDTO.setRegion_name(rName);
		}
		
		//6. 자원해제
		DBConnector.disConnect(rs, st, con);
		
		return regionsDTO;
		
	}
	
	//1. Regions의 모든 데이터 가져오기
	public ArrayList<RegionsDTO> getList() throws Exception {
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. Query 문 작성
		String sql = "SELECT * FROM regions";
		
		//3. Query 문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. 
		
		//5. 최종 전송 후 결과를 처리
		ResultSet rs = st.executeQuery();
		
		ArrayList<RegionsDTO> results = new ArrayList<>();
		
		while(rs.next()) {
			int region_id = rs.getInt("region_id");
			String region_name = rs.getString("region_name");
			
			//outString(id, name);
			results.add(new RegionsDTO(region_id, region_name));
		}
		
		//6. 자원해제
		DBConnector.disConnect(rs, st, con);
		
		return results;
		
	}
	
	/*private void outString(int id, String name) {
		System.out.println("대륙코드 : " + id + "  대륙명 : " + name);
	}*/

}
