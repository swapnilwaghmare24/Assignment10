package com.bridgelabz.assignmentten;

import java.util.ArrayList;


public class EmployeeWagesTest {
    ArrayList<IEmployeeWages> companyBasedWages;
    public EmployeeWagesTest() {
        companyBasedWages=new ArrayList<>();
    }

    public void addCompany(String companyName, int fullTimeWorkingHour, int wagePerHour,
                           int maxWorkingDay, int maxWorkingHour) {
        IEmployeeWages employeeWages = new EmployeeWages(companyName,
                fullTimeWorkingHour, wagePerHour, maxWorkingDay, maxWorkingHour);
        employeeWages.calculateEmployeeWage();
        companyBasedWages.add(employeeWages);
    }

    public void printAllCompanies() {
        for (IEmployeeWages ie:companyBasedWages)
        {
          System.out.println(ie);
          System.out.println("<---------------------------------------------------------------------------->");
        }

    }

    public static void main(String[] args) {
        EmployeeWagesTest employeeWagesTest = new EmployeeWagesTest();

        employeeWagesTest.addCompany("Tcs", 8, 20, 20, 60);
        employeeWagesTest.addCompany("Wipro", 9, 22, 22, 80);
        employeeWagesTest.addCompany("Google", 10, 26, 20, 80);
        employeeWagesTest.addCompany("Microsoft", 8, 20, 25, 60);
        employeeWagesTest.addCompany("Hcl", 9, 22, 25, 100);
        employeeWagesTest.addCompany("Dell", 10, 26, 20, 90);
        employeeWagesTest.printAllCompanies();
    }
}
