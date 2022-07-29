package kr.co.employees;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.util.DBConnector;

public class EmployeesDAO {
	
	public void getJoinTest(EmployeesDTO employeesDTO) throws Exception {
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. Query문 작성 (Query가 길 경우 내려줄 수 있는데 띄어쓰기 신경쓸것, StringBuffer 사용해도 무관)
		String sql = "SELECT E.first_name, E.salary, D.department_name "
				+ "    FROM employees E "
				+ "        INNER JOIN departments D "
				+ "        ON (E.department_id = D.department_id) "
				+ "    WHERE E.employee_id = ?";
		
		//3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?가 있으면 값 세팅
		st.setInt(1, employeesDTO.getEmployee_id());
		
		//5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			employeesDTO = new EmployeesDTO();
			employeesDTO.setFirst_name(rs.getString("E.first_name"));
			employeesDTO.setSalary(rs.getInt("E.salary"));
			// JOIN하면서 여러 테이블에서 값을 가져오므로 하나의 DTO에 모든 정보를 담을 수 없다. (서로 다른 DTO의 멤버가 필요함)
			// 그렇다고 DTO를 또 생성하기에도 그렇다. -> 상속을 받거나 멤버로 선언
			// employee는 department이다. -> x (employee는 department를 상속 x)
			// employee는 department를 가지고 있다. -> 애매함 (employee는 department를 멤버로 가지지 않는다.)
			// department는 employee이다. -> x
			// department는 employee를 가지고 있다. -> 애매함
			// department는 employee들을 가지고 있다. -> 정확함 (즉, departmentDTO의 멤버로 employee타입 ArrayList를 선언하는 것이 제일 적합)
			// 물론 각자 따로 각각에 맞는 DTO에 담을 수도 있지만 반환하는 것이 좀 문제이다. -> 협의 후 결정
		}
		
		//6. 자원해제
		DBConnector.disConnect(rs, st, con);
		
	}
	
	public void getSalaryInfo() throws Exception {
		//1. DB연결
		Connection con = DBConnector.getConnection();
		
		//2. SQL문 작성
		String sql = "SELECT SUM(salary), AVG(salary), MAX(salary) AS MAX FROM employees";
		
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?가 있으면 값 세팅
		
		//5. 최종 전송후 결과처리
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			int sum = rs.getInt("SUM(salary)");
			double avg = rs.getDouble(2);
			int max = rs.getInt("MAX");	//alias 가능
			
			System.out.println(sum);
			System.out.println(avg);
			System.out.println(max);
		}
		
		//6. 자원 해제
		DBConnector.disConnect(rs, st, con);
		
	}
	
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
