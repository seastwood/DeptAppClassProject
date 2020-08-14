package ICS141GroupProj;

import java.util.InputMismatchException;
import java.util.Scanner;

class DeptApp {

public static void main(String[] args) 
{
	

Scanner s = new Scanner(System.in);
Dept myDept = new Dept();
Emp myEmp = new Emp();
Menus myMenu = new Menus();
int DeptSelect, EmpSelect = 0;
double amount = 0, openingBudget = 0, payRate = 0;
boolean goodData = false;

//created multiple user_choices so the choices don't affect other menus
int user_choice = 0;
int user_choice2 = 0;
int user_choice3 = 0;

//Java do-while loop is an Exit control loop. Therefore, unlike for or while loop, 
//a do-while checks for the condition after executing the statements or the loop body.
do {
    //display MENU 1 to user
    //ask user for his choice and validate it (make sure it is between 1 and 6)
	myMenu.getMenu1();
    while(!goodData){
        try {
        	System.out.print("Enter choice [1-5]: ");
        	user_choice = s.nextInt();
        	goodData = true;
    	}
    	catch (InputMismatchException  ex )
    	{ 
    		System.out.println("Please enter a number.\n" );
    		s.nextLine();
    	}
    }
    goodData = false;
    System.out.println();
    
    //switch() is kind of like if/else statements, but allows you to select one "case"
    //to be executed. Once the case is done, the while loop at the end returns you
    //back to the beginning of the block ("{}") menu where you select another case.
   
    switch (user_choice) {
        case 1: 
        	//Add a department
        	//Request for & read in parameters to be sent to openNewDept()
        	//which then creates & returns what array this object is in
            System.out.print("Enter a name for your new department: ");
            s.nextLine(); //added to create white space for the scanner to work
            String deptName = s.nextLine();	 
            while(!goodData){
            try {
            	System.out.print("Enter a yearly budget for the department:");
            	openingBudget = s.nextDouble();
            	goodData = true;
            	}
            	catch (InputMismatchException  ex )
            	{ 
            		System.out.println("Please enter a number.\n" );
            		s.nextLine();
            	}
            }
            goodData = false;
            System.out.println(deptName + " was created and it has the following number: " 
            + myDept.openNewDept(deptName, openingBudget));
            System.out.println();
            break;
        case 2: 
        	//View/Edit Departments
        	//Begin with printAllDept() which returns a Boolean value
        	//The Boolean is just to ensure that there is at least one department
        	//so that the code doesn't become dead.
        	//If true it proceeds to the next menu for making changes to 
        	//the department you selected
        	//If false it skips passed this saying no departments exist
        	//and returns you to the first menu
        	if (myDept.printAllDept() == true) {
        	DeptSelect = s.nextInt();
        	System.out.println("\nYou Selected:\n");
        	myDept.printDeptInfo(DeptSelect);
        	System.out.println("Department yearly Pay Rate Expense: " 
        			+ myEmp.getDeptYearlyExpense(DeptSelect));
        	myEmp.totalDeptEmpCount(DeptSelect); 
        	}
        	else
        		break;
        do {
        	//MENU 2
        	myMenu.getMenu2();
	        while(!goodData){
	            try {
	            	System.out.print("Enter choice [1-5]: ");
	            	user_choice2 = s.nextInt();
	            	goodData = true;
            	}
            	catch (InputMismatchException  ex )
            	{ 
            		System.out.println("Please enter a number.\n" );
            		s.nextLine();
            	}
            }
            goodData = false;
	        
		switch (user_choice2) {
			//Change Budget
			//uses changeBudget() 
	        case 1:
	        	while(!goodData){
	                try {
	                	System.out.println("Enter the new Budget");
	                	amount = s.nextDouble();
	                	goodData = true;
	                }
	                catch (InputMismatchException  ex ) { 
	            		System.out.println("Please enter a number.\n" );
	            		s.nextLine();
	            	}
	            }
	        	goodData = false;
	        	myDept.changeBudget(DeptSelect, amount);
	        break;
	        case 2:
	        	System.out.println("Enter new name");
	    		s.nextLine(); //added to create white space for the scanner to work
	    		deptName = s.nextLine();
	    		myDept.changeDeptName(DeptSelect, deptName);
	    		
	        break;
	        
	        case 3:
	    		System.out.println("\n[1] Add an employee "
	        			+ "\n[2] View/Edit an Employee.\n[3] Go Back\n");
	    		 while(!goodData){
	 	            try {
	 	            	System.out.print("Enter choice [1-3]: ");
	 	            	user_choice3 = s.nextInt();
	 	            	goodData = true;
	            	}
	            	catch (InputMismatchException  ex )
	            	{ 
	            		System.out.println("Please enter a number.\n" );
	            		s.nextLine();
	            	}
	            }
	            goodData = false;
	        	if (user_choice3 == 1) {
		        	System.out.print("\nEnter new Employee's name:");
		        	s.nextLine(); //added to create white space for the scanner to work
	                String empName = s.nextLine();
	                System.out.print("Enter new Employee's job title:");
	                String JobTitle = s.nextLine();
	                while(!goodData){
		                try {
		                	System.out.print("Enter Employee's hourly pay rate:");
		                	payRate = s.nextDouble();
		                	goodData = true;
		                }
		                catch (InputMismatchException  ex ) { 
		                	System.out.println("Please enter a number.\n" );
		                	s.nextLine();
		                }
	                }
	                goodData = false;
	                System.out.println("Employee was added and has the following number: "
	                + myEmp.addEmpToDept(DeptSelect, empName, JobTitle, payRate) + "\n"); 
		        	}
	        	if (user_choice3 == 2) {
	        		if (myEmp.printAllDeptEmp(DeptSelect) == true) {
	                	EmpSelect = s.nextInt();
	                	System.out.println("You Selected:\n");
	                	myEmp.printEmpInfo(EmpSelect);
	                	
	        		do {
	        			//MENU 3
	        			myMenu.getMenu3();
	        	        while(!goodData){
	    	 	            try {
	    	 	            	System.out.print("Enter choice [1-4]: ");
	    	 	            	user_choice3 = s.nextInt();
	    	 	            	goodData = true;
	    	            	}
	    	            	catch (InputMismatchException  ex )
	    	            	{ 
	    	            		System.out.println("Please enter a number.\n" );
	    	            		s.nextLine();
	    	            	}
	    	            }
	        	        goodData = false;
	        	    switch (user_choice3) {
	        	    	case 1:
	        	    		while(!goodData){
	    		                try {
	    		                	System.out.println("Enter new pay rate");
	    		                	amount = s.nextDouble();
	    		                	goodData = true;
	    		                }
	    		                catch (InputMismatchException  ex ) { 
	    		                	System.out.println("Please enter a number." );
	    		                	s.nextLine();
	    		                }
	    	                }
	    	                goodData = false;
	        	    		myEmp.changePayRate(EmpSelect, amount);
	    	        	break;	    	        	
	        	    	case 2:
	        	    		System.out.println("Enter new name");
	        	    		s.nextLine(); //added to create white space for the scanner to work
	        	    		String empName = s.nextLine();
	        	    		myEmp.changeEmpName(EmpSelect, empName);
	        	    	break;
	        	    	case 3:
	        	    		System.out.println("Here's a list of available departments:\n");
	        	    		myDept.printAllDeptNoStrings();
	        	    		while(!goodData){
	        	                try {
	        	                	System.out.print("Enter the number of the department"
	        	    				+ " you'd like to move this employee to: ");
	        	                	DeptSelect = s.nextInt();
	        	                	goodData = true;
		    	            	}
		    	            	catch (InputMismatchException  ex )
		    	            	{ 
		    	            		System.out.println("Please enter a number.\n" );
		    	            		s.nextLine();
		    	            	}
		    	            }
	        	    		goodData = false;
	        	    		myEmp.changeEmpDept(EmpSelect, DeptSelect);
	        	    	break;
	        	    }
	        		}
	        		while (user_choice3 != 4);
	        		}
	        		else {
	        			myDept.getNameOfDept(DeptSelect);
	        			System.out.println();
	        		}
	        		
	        	}
	        	else		
	        	break;
	        break;
	        case 4:
	        	System.out.println("\nYou are in:\n");
	        	myDept.printDeptInfo(DeptSelect);
	        	System.out.println("Department yearly Pay Rate Expense: " 
	        			+ myEmp.getDeptYearlyExpense(DeptSelect));  
	        	
	        	double leftInBudget = (myDept.getBudget(DeptSelect) 
	        			- myEmp.getDeptYearlyExpense(DeptSelect));
	        	if (leftInBudget < 0) 
	        		System.out.println("Left in Budget: "+ leftInBudget 
	        				+ "\nThis department doesn't have enough money!\n");
	        	if (leftInBudget >= 0)
	        		System.out.println("Left in Budget: "+ leftInBudget); 
	        	System.out.println("Employee List:\n");
	        	myEmp.totalDeptEmpCount(DeptSelect);
	        	myEmp.printAllDeptEmpInfo(DeptSelect);
	        	break;
	        
	        }}
        
        	//ends the do loop
			while (user_choice2 != 5);	
        	break;
    case 3:
    	myDept.printAllDeptNoStrings();
    break;
    
    case 4:
    	myEmp.printAllEmpInfo();
    break;
    }  
}	

//ends the do loop
while (user_choice != 5);
if (user_choice == 5)
System.out.println("Program Stopped");
}}



