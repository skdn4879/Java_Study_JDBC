package kr.co.test;

import kr.co.regions.RegionsDAO;
import kr.co.util.DBConnector;

public class TestMain {

	public static void main(String[] args) {
		
		RegionsDAO regionsDAO = new RegionsDAO();
		try {
			regionsDAO.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
