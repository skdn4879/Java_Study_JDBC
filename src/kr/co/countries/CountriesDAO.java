package kr.co.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.util.DBConnector;

public class CountriesDAO {
	
	//getDetail : countries_id
	public CountriesDTO getDetail(String country_id) throws Exception {
		CountriesDTO countriesDTO = null;
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM countries WHERE country_id = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, country_id);
		
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
	
	/*private void outString(String id, String name, int regionId) {
		System.out.println("국가코드 : " + id + "  국가명 : " + name + "  대륙코드 : " + regionId);
	}*/
	
}
