import java.util.Scanner;

class Project1 {
    public static void main(String[] args) {
        // Initialize employee data
        int[] empNo = {1001, 1002, 1003, 1004, 1005, 1006, 1007};
        String[] empName = {"Ashish", "Sushma", "Rahul", "Chahat", "Ranjan", "Suman", "Tanmay"};
        String[] joinDate = {"01/04/2009", "23/08/2012", "12/11/2008", "29/01/2013", "16/07/2005", "1/1/2000", "12/06/2006"};
        char[] designationCode = {'e', 'c', 'k', 'r', 'm', 'e', 'c'};
        String[] department = {"R&D", "PM", "Acct", "Front Desk", "Engg", "Manufacturing", "PM"};
        int[] basic = {20000, 30000, 10000, 12000, 50000, 23000, 29000};
        int[] hra = {8000, 12000, 8000, 6000, 20000, 9000, 12000};
        int[] it = {3000, 9000, 1000, 2000, 20000, 4400, 10000};

        // DA table
        char[] daCode = {'e', 'c', 'k', 'r', 'm'};
        String[] designation = {"Engineer", "Consultant", "Clerk", "Receptionist", "Manager"};
        int[] da = {20000, 32000, 12000, 15000, 40000};

        // Get the input empID from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID: ");
        int inputEmpID = sc.nextInt();

        // Find the employee details
        int empIndex = -1;
        for (int i = 0; i < empNo.length; i++) {
            if (empNo[i] == inputEmpID) {
                empIndex = i;
                break;
            }
        }

        // Check if employee exists
        if (empIndex == -1) {
            System.out.println("There is no employee with empid : " + inputEmpID);
        } else {
            // Find designation and DA
            int daValue = 0;
            String empDesignation = "";
            switch (designationCode[empIndex]) {
                case 'e':
                    empDesignation = "Engineer";
                    daValue = 20000;
                    break;
                case 'c':
                    empDesignation = "Consultant";
                    daValue = 32000;
                    break;
                case 'k':
                    empDesignation = "Clerk";
                    daValue = 12000;
                    break;
                case 'r':
                    empDesignation = "Receptionist";
                    daValue = 15000;
                    break;
                case 'm':
                    empDesignation = "Manager";
                    daValue = 40000;
                    break;
            }

            // Calculate salary
            int salary = basic[empIndex] + hra[empIndex] + daValue - it[empIndex];

            // Output the employee details
            System.out.println("Emp No   Emp Name   Department   Designation   Salary");
            System.out.println(empNo[empIndex] + "    " + empName[empIndex] + "    " + department[empIndex]
                    + "    " + empDesignation + "    " + salary);
        }

        sc.close();
    }
}
