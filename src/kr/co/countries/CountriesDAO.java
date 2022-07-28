package kr.co.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.util.DBConnector;

public class CountriesDAO {
	
	//setCountry
	public int setCountry(CountriesDTO countriesDTO) throws Exception {
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. Query 문 작성
		String sql = "INSERT INTO countries VALUES(?, ?, ?)";
		
		//3. Query 문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ? 가 있으면 값 세팅
		st.setString(1, countriesDTO.getCountry_id());
		st.setString(2, countriesDTO.getCountry_name());
		st.setInt(3, countriesDTO.getRegion_id());
		
		//5. 최종 전송 후 결과 처리
		int result = st.executeUpdate();
		
		//6. 자원 해제
		DBConnector.disConnect(st, con);
		
		return result;
		
	}
	
	//getDetail : countries_id
	public CountriesDTO getDetail(String country_id) throws Exception {
		CountriesDTO countriesDTO = null;
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM countries WHERE country_id = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, country_id);	//자동으로 'country_id'로 넣어준다.
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			countriesDTO = new CountriesDTO();
			
			String cId = rs.getString("country_id");
			String cName = rs.getString("country_name");
			int regionId = rs.getInt("region_id");
			
			//outString(cId, cName, regionId);
			countriesDTO.setCountry_id(cId);
			countriesDTO.setCountry_name(cName);
			countriesDTO.setRegion_id(regionId);
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return countriesDTO;
		
	}

	public ArrayList<CountriesDTO> getList() throws Exception {
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM countries";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		ArrayList<CountriesDTO> countriesResults = new ArrayList<>();
		
		while(rs.next()) {
			String country_id = rs.getString("country_id");
			String country_name = rs.getString("country_name");
			int regionId = rs.getInt("region_id");
			
			//outString(id, name, regionId);
			countriesResults.add(new CountriesDTO(country_id, country_name, regionId));
			
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return countriesResults;
		
	}
	
	public ArrayList<CountriesDTO> getList(String search) throws Exception {
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM countries WHERE country_name LIKE '%' || ? || '%'";
		// SELECT * FROM countries WHERE country_name LIKE '%' || ? || '%'
		
		PreparedStatement st = con.prepareStatement(sql);
		//st.setString(1, "%" + search + "%");
		// WHERE country_name LIKE %?%일 경우 그냥 setString 하면 ''가 자동으로 붙어서 %'search'%가 된다.
		st.setString(1, search);
		
		ResultSet rs = st.executeQuery();
		
		ArrayList<CountriesDTO> countriesResults = new ArrayList<>();
		
		while(rs.next()) {
			String country_id = rs.getString("country_id");
			String country_name = rs.getString("country_name");
			int regionId = rs.getInt("region_id");
			
			//outString(id, name, regionId);
			countriesResults.add(new CountriesDTO(country_id, country_name, regionId));
			
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return countriesResults;
		
	}
	
	/*private void outString(String id, String name, int regionId) {
		System.out.println("국가코드 : " + id + "  국가명 : " + name + "  대륙코드 : " + regionId);
	}*/
	
}
