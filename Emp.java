package ICS141GroupProj;


public class Emp {
	
	private EmpAccount[] accountsEmp; 
	private int numOfEmployees = 0;
	
	public Emp() {

	    accountsEmp = new EmpAccount[10];
	    numOfEmployees = 0;
	    }
	public int addEmpToDept(int DeptSelect, String empName, String JobTitle, double payRate) {
	    EmpAccount b = new EmpAccount(DeptSelect, empName, JobTitle, payRate);
	    accountsEmp[numOfEmployees] = b;
	    numOfEmployees++;    
	    return b.getEmployeeNum();
	}
	
	public void printEmpInfo(int EmpSelect) {
		
	    for (int i =0; i<numOfEmployees; i++) {
	    	if (EmpSelect == accountsEmp[i].getEmployeeNum()) {
	        System.out.println(accountsEmp[i].getEmployeeInfo());
	        return;
	    	}
	    }	
	}	
	
	public void changePayRate(int EmpSelect, double newRate) {
		
	    for (int i =0; i<numOfEmployees; i++) {
	        if (EmpSelect == accountsEmp[i].getEmployeeNum()) {
	        	accountsEmp[i].changePayRate(newRate);
	            System.out.println("Pay Rate Changed Successfully\n");
	            return;
	        }
	    }
	}
	
	public double getDeptYearlyExpense(int DeptSelect) {
		double DeptExpense = 0;
		    for (int i =0; i<numOfEmployees; i++) { 
		        if (DeptSelect == accountsEmp[i].getEmployeeDeptNum()) 
		        	DeptExpense = (accountsEmp[i].getEmpYearlyExpense()) + DeptExpense;
		        }        
		return DeptExpense; 
	}
	
	public void getAllDeptYearlyExpense() {
		double Expense = 0;
	    	for (int i =0; i<numOfEmployees; i++) {
	    		Expense = (accountsEmp[i].getEmpYearlyExpense()) + Expense;	            
	        }	   
	    System.out.println("Yearly Pay Rate Expense: " + Expense +"\n");
	}
	
	public void changeEmpDept(int EmpSelect, int newDept) {
		
	    for (int i =0; i<numOfEmployees; i++) {
	        if (EmpSelect == accountsEmp[i].getEmployeeNum()) {
	        	accountsEmp[i].changeEmpDept(newDept);
	            System.out.println("Employee Department Changed Successfully\n");
	            return;
	        }
	    }
	}
	
	public void changeEmpName(int EmpSelect, String newName) {
		
	    for (int i =0; i<numOfEmployees; i++) {
	        if (EmpSelect == accountsEmp[i].getEmployeeNum()) {
	        	accountsEmp[i].changeEmpName(newName);
	            System.out.println("Name Changed Successfully\n");
	            return;
	        }
	    }
	}

	public boolean printAllDeptEmp(int DeptSelect) {
		int i = 0;
		int empCount = 0;
		for (i =0; i<numOfEmployees; i++) {
			if(DeptSelect == accountsEmp[i].getEmployeeDeptNum())
				empCount++;
		}
		if (empCount != 0) { 
			System.out.println("\nWHICH EMPLOYEE WOULD YOU LIKE TO VIEW/EDIT?\n");
	    	for (i =0; i<numOfEmployees; i++) {
	    		if(DeptSelect == accountsEmp[i].getEmployeeDeptNum()) {
	    		System.out.println(accountsEmp[i].getEmployeeInfo());
	    		}
	    	}	
	    System.out.print("ENTER THE EMPLOYEE'S NUMBER TO SELECT ONE: \n");
	    return true;
	    }
	    else
	    System.out.print("No employees exist in ");//getDeptName()
		return false;
	}
	public void totalDeptEmpCount(int DeptSelect) {
		int i = 0;
		int empCount = 0;
		for (i =0; i<numOfEmployees; i++) {
			if(DeptSelect == accountsEmp[i].getEmployeeDeptNum())
				empCount++;
		}
		System.out.println("Total Number of Employees in department "
							+ DeptSelect + ":  " + empCount + "\n");
	}
	
	public void printAllDeptEmpInfo(int DeptSelect) {
		int i = 0;
		int empCount = 0;
		for (i =0; i<numOfEmployees; i++) {
			if(DeptSelect == accountsEmp[i].getEmployeeDeptNum()) {
				empCount++;
		}}
		if (empCount != 0) {
    	for (i =0; i<numOfEmployees; i++) {
    		if(DeptSelect == accountsEmp[i].getEmployeeDeptNum()) {
    		System.out.println(accountsEmp[i].getEmployeeInfo());
    		}
    	}	
		}
	    else
	    System.out.println("No employees exist in this department.\n");
	}
	
	public void printAllEmpInfo() {
		if (numOfEmployees != 0) {
    	for (int i =0; i<numOfEmployees; i++) {
    		System.out.println(accountsEmp[i].getEmployeeInfo());
    	}	
		}
	    else
	    System.out.println("No employees exist.\n");
	}



static class EmpAccount{
	private int EmployeeNum;
    private String empName;
    private String JobTitle;
    private double payRate;
    private int EmployeeDeptNum;
    private static int noOfAccounts=0;
	
    public int getEmployeeNum(){
        return EmployeeNum;
    }
    
    public int getEmployeeDeptNum(){
        return EmployeeDeptNum;
    }
    public double getEmpPayRate(){
        return payRate;
    }
    public double getEmpYearlyExpense(){
        return payRate*2080;
    }
    public String getEmployeeInfo(){
        return "Employee number: [" + EmployeeNum + "]\nEmployee Name: " 
        		+ empName + "\nJob Title: " + JobTitle + "\nHourly Pay Rate:" + payRate + "\nYearly Expense: " + payRate * 2080 
        		+ "\nDepartment Number: " + EmployeeDeptNum +"\n";
    }
    public void changePayRate(double newRate){
    	payRate = newRate;
    }
    public void changeEmpName(String newName){
    	empName = newName;
    }
    public void changeEmpDept(int newDept){
    	EmployeeDeptNum = newDept;
    }
    
    public EmpAccount(int a, String b, String c, double d){
    	EmployeeDeptNum = a;
        empName = b;
        JobTitle = c;
        payRate = d;
        noOfAccounts ++;
        EmployeeNum = noOfAccounts;
      }
    
	  }
}	