package kr.co.test;

import java.util.ArrayList;

import kr.co.countries.CountriesDAO;
import kr.co.countries.CountriesDTO;
import kr.co.countries.CountriesView;
import kr.co.regions.RegionsDAO;
import kr.co.regions.RegionsDTO;
import kr.co.regions.RegionsView;

public class TestMain {

	public static void main(String[] args) {
		
		RegionsDAO regionsDAO = new RegionsDAO();
		CountriesDAO countriesDAO = new CountriesDAO();
		RegionsView regionsView = new RegionsView();
		CountriesView countriesView = new CountriesView();
		
		try {
			//regionsDAO.getList();
			//countriesDAO.getList();
			//regionsDAO.getDetail(3);
			//countriesDAO.getDetail("US");
			
			/*regionsView.view(regionsDAO.getDetail(3));
			ArrayList<RegionsDTO> regionsResults = regionsDAO.getList();
			regionsView.view(regionsResults);*/
			
			countriesView.view(countriesDAO.getDetail("US"));
			ArrayList<CountriesDTO> countriesResults = countriesDAO.getList();
			countriesView.view(countriesResults);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
