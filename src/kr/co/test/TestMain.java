package kr.co.test;

import kr.co.util.DBConnector;

public class TestMain {

	public static void main(String[] args) {
		
		DBConnector dbConnector = new DBConnector();
		try {
			dbConnector.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
