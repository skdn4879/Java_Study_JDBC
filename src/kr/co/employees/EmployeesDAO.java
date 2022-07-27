package kr.co.employees;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.util.DBConnector;

public class EmployeesDAO {
	
	public EmployeesDTO getDetail(int employee_id) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM employees WHERE employee_id = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, employee_id);
		
		ResultSet rs = st.executeQuery();
		
		EmployeesDTO employeesDTO = null;
		
		if(rs.next()) {
			Integer eId = rs.getInt("employee_id");
			String first_name = rs.getString("first_name");
			String last_name = rs.getString("last_name");
			String email = rs.getString("email");
			String phone_number = rs.getString("phone_number");
			Date hire_date = rs.getDate("hire_date");
			String job_id = rs.getString("job_id");
			Integer salary = rs.getInt("salary");
			Double commission_pct = rs.getDouble("commission_pct");
			Integer manager_id = rs.getInt("manager_id");
			Integer department_id = rs.getInt("department_id");
			
			employeesDTO = new EmployeesDTO(eId, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id);
			
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return employeesDTO;
		
	}

	public ArrayList<EmployeesDTO> getList() throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM employees";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		ArrayList<EmployeesDTO> employeesResults = new ArrayList<>();
		
		while(rs.next()) {
			Integer employee_id = rs.getInt("employee_id");
			String first_name = rs.getString("first_name");
			String last_name = rs.getString("last_name");
			String email = rs.getString("email");
			String phone_number = rs.getString("phone_number");
			Date hire_date = rs.getDate("hire_date");
			String job_id = rs.getString("job_id");
			Integer salary = rs.getInt("salary");
			Double commission_pct = rs.getDouble("commission_pct");
			Integer manager_id = rs.getInt("manager_id");
			Integer department_id = rs.getInt("department_id");
			
			employeesResults.add(new EmployeesDTO(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id));
			
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return employeesResults;
		
	}
	
}
