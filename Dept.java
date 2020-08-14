package ICS141GroupProj;

public class Dept {
	private DeptAccount[] accountsDept;     // all the department accounts at this bank
	private int numOfDepartments = 0;      // the number of departments at this bank

	// Constructor: A new Dept object initially doesn’t contain any departments.
	public Dept() {
	    accountsDept = new DeptAccount[10];
	    numOfDepartments = 0;
	    }
	
	// Creates a new Department using the Department name and the budget given as parameters
	// and returns the department number of this new department. It also adds this 
	// department into the department list of the department calling object.
	public int openNewDept(String deptName, double openingBudget) {

	    DeptAccount b = new DeptAccount(deptName, openingBudget);
	    accountsDept[numOfDepartments] = b;
	    numOfDepartments++;
	    return b.getDepartmentNum();
	}

	// Changes the department budget
	public void changeBudget(int DeptNumber, double amount) {
		
	    for (int i =0; i<numOfDepartments; i++) {
	        if (DeptNumber == accountsDept[i].getDepartmentNum()  ) {
	            accountsDept[i].changeBudget(amount);
	            System.out.println("Budget changed successfully\n");
	            return;
	        }
	    }
	    System.out.println("Department number not found.\n");
	}
	
	public double getBudget(int DeptNumber) {
		double b = 0;
	    for (int i =0; i<numOfDepartments; i++) {
	        if (DeptNumber == accountsDept[i].getDepartmentNum()  ) {
	        	b = accountsDept[i].getBudget();
	        }
	    }
		return b;
	}
	
	public void changeDeptName(int DeptNumber, String newName) {
		
	    for (int i =0; i<numOfDepartments; i++) {
	        if (DeptNumber == accountsDept[i].getDepartmentNum()  ) {
	            accountsDept[i].changeDeptName(newName);
	            System.out.println("Name changed successfully\n");
	            return;
	        }
	    }
	}
	public void getNameOfDept(int DeptNumber){
		
	    for (int i =0; i<numOfDepartments; i++) {
	        if (DeptNumber == accountsDept[i].getDepartmentNum()  ) {
	            System.out.println(accountsDept[i].getDeptName());
	            return;
	        }
	    }
	}

	// Prints the account number, the customer name and the balance of the bank account whose
	// account number is given. If the account is not available at the bank, it should print a message.
	public void printDeptInfo(int DeptNumber) {
		
	    for (int i =0; i<numOfDepartments; i++) {
	    	if (DeptNumber == accountsDept[i].getDepartmentNum()) {
	        System.out.println(accountsDept[i].getDepartmentInfo());
	        return;
	    	}
	    }	
	    System.out.println("\nDepartment number not found.\n");
	}
	
	public boolean printAllDept() {
		if (numOfDepartments != 0) {
			System.out.println("WHICH DEPARTMENT WOULD YOU LIKE TO VIEW/EDIT?\n");
	    	for (int i =0; i<numOfDepartments; i++) {
	    		System.out.println(accountsDept[i].getDepartmentInfo());
	    	}	
        System.out.print("ENTER THE DEPARTMENT NUMBER TO SELECT ONE: ");
        return true;
        }
	    else
	    System.out.println("No departments exist.\n");
		return false;
	}

	public void printAllDeptNoStrings() {
		if (numOfDepartments != 0) {
	    	for (int i =0; i<numOfDepartments; i++) {
	    		System.out.println(accountsDept[i].getDepartmentInfo());
	    	}	
        }
	    else
	    System.out.println("No departments exist.\n");
	}
	
static class DeptAccount{
	

	
    private int DepartmentNum;
    private String deptName;
    private double budget;
    private  static int noOfAccounts=0;
    
	public String getDeptName(){		
		return deptName;
	}

    public String getDepartmentInfo(){
        return "Department number: [" + DepartmentNum + "]\nDepartment Name: " 
        		+ deptName + "\nBudget:" + budget + "\n";
    }


    public DeptAccount(String abc, double xyz){
      deptName = abc;
      budget = xyz;
      noOfAccounts ++;
      DepartmentNum = noOfAccounts;
    }


    public int getDepartmentNum(){
    	return DepartmentNum;
    }
    public void changeBudget(double amount){
    	budget = amount;

     }
    public void changeDeptName(String newName) {
    	deptName = newName;
    }
    public double getBudget(){
    	return budget;

    }
}
}






