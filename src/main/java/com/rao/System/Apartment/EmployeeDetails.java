package com.rao.System.Apartment;

import java.util.ArrayList;

public class EmployeeDetails {


	private int employeeID;
	private int employeeAge;	
	private String employeeName;
	private String employeeCity;
	
	//Parameterized Constructor
		public EmployeeDetails(int id, int age, String name, String city)
		{
			this.employeeID = id;
			this.employeeAge = age;
			this.employeeName = name;
			this.employeeCity = city;
		}
		
		public int getEmployeeID() {
			return employeeID;
		}
		public int getEmployeeAge() {
			return employeeAge;
		}
		public String getEmployeeName() {
			return employeeName;
		}
		public String getEmployeeCity() {
			return employeeCity;
		}

	public ArrayList<EmployeeDetails> getEmployeeDetails()
	{
		ArrayList<EmployeeDetails> empList = new ArrayList<EmployeeDetails>();
		 
		empList.add(new EmployeeDetails(1, 20, "Ram", "Delhi"));  //Adding employee data to the ArrayList object via parameterized constructor
		empList.add(new EmployeeDetails(2, 30, "Raj", "Mumbai"));
		empList.add(new EmployeeDetails(3, 40, "Ron", "Pune"));
		empList.add(new EmployeeDetails(4, 50, "Rob", "Belgaum"));
		empList.add(new EmployeeDetails(5, 60, "Roy", "Bengaluru"));
		 
		 for (EmployeeDetails s : empList) //Iterates as long as there are elements in the list.
			{
				System.out.print("ID, Name and City of the employee are : ");
				System.out.println(s.employeeID + " " + s.employeeAge + " " + s.employeeName + " " + s.employeeCity);
			}
		return empList;
	}
}