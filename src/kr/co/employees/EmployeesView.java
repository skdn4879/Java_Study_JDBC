package kr.co.employees;

import java.util.ArrayList;

public class EmployeesView {

	public void view(EmployeesDTO employeesDTO) {
		System.out.println("id\tfirst_name\tlast_name\temail\t\tphone_number\thire_date\tjob_id\t\tsalary\t\tcommission\tmanager\t\tdepart");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.print(employeesDTO.getEmployee_id() + "\t");
		System.out.print(employeesDTO.getFirst_name() + "\t\t");
		System.out.print(employeesDTO.getLast_name() + "\t\t");
		System.out.print(employeesDTO.getEmail() + "\t\t");
		System.out.print(employeesDTO.getPhone_number() + "\t");
		System.out.print(employeesDTO.getHire_date() + "\t");
		System.out.print(employeesDTO.getJob_id() + "\t\t");
		System.out.print(employeesDTO.getSalary() + "\t\t");
		System.out.print(employeesDTO.getCommission_pct() + "\t\t");
		System.out.print(employeesDTO.getManager_id() + "\t\t");
		System.out.println(employeesDTO.getDepartment_id());
		//System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void view(ArrayList<EmployeesDTO> results) {
		
		System.out.println("id\tfirst_name\tlast_name\temail\t\tphone_number\thire_date\tjob_id\t\tsalary\t\tcommission\tmanager\t\tdepart");
		
		for(EmployeesDTO result : results) {
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.print(result.getEmployee_id() + "\t");
			System.out.print(result.getFirst_name() + "\t\t");
			System.out.print(result.getLast_name() + "\t\t");
			System.out.print(result.getEmail() + "\t\t");
			System.out.print(result.getPhone_number() + "\t");
			System.out.print(result.getHire_date() + "\t");
			System.out.print(result.getJob_id() + "\t\t");
			System.out.print(result.getSalary() + "\t\t");
			System.out.print(result.getCommission_pct() + "\t\t");
			System.out.print(result.getManager_id() + "\t\t");
			System.out.println(result.getDepartment_id());
			//System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
	}
	
}
