package kr.co.test;

import kr.co.countries.CountriesDAO;
import kr.co.regions.RegionsDAO;
import kr.co.util.DBConnector;

public class TestMain {

	public static void main(String[] args) {
		
		RegionsDAO regionsDAO = new RegionsDAO();
		CountriesDAO countriesDAO = new CountriesDAO();
		
		try {
			regionsDAO.getList();
			countriesDAO.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
