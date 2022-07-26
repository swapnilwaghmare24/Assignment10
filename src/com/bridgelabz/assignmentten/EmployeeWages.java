package com.bridgelabz.assignmentten;

public class EmployeeWages implements IEmployeeWages{
    String companyName;
    int fullTimeWorkingHour, wagePerHour, maxWorkingDay, maxWorkingHour;
    double totalSalary;

    public EmployeeWages(String companyName, int fullTimeWorkingHour, int wagePerHour,
                          int maxWorkingDay, int maxWorkingHour) {
        this.companyName = companyName;
        this.fullTimeWorkingHour = fullTimeWorkingHour;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDay = maxWorkingDay;
        this.maxWorkingHour = maxWorkingHour;
    }

    public int checkEmpAttendance(int totalWorkingHour, int fullTimeWorkingHour,
                                  int maxWorkingHour) {
        if (totalWorkingHour == maxWorkingHour - (fullTimeWorkingHour / 2)) {
            return PART_TIME;
        } else {
            return (int) (Math.random() * 3);
        }
    }

    public int getWorkingHour(int isEmpPresent, int fullTimeWorkingHour) {
        switch (isEmpPresent) {
            case PRESENT:
                return fullTimeWorkingHour;

            case PART_TIME:
                return fullTimeWorkingHour / 2;

            default:
                return 0;
        }
    }

    @Override
    public void calculateEmployeeWage() {
        int totalWorkingHour = 0;
        int day = 0;
        while (day < maxWorkingDay && totalWorkingHour < maxWorkingHour) {
            day++;
            int isEmpPresent = checkEmpAttendance(totalWorkingHour, fullTimeWorkingHour,
                    maxWorkingHour);

            int empHr = getWorkingHour(isEmpPresent, fullTimeWorkingHour);

            totalWorkingHour = totalWorkingHour + empHr;
        }
        totalSalary = totalWorkingHour * wagePerHour;
    }

    @Override
    public String toString() {
        return companyName + "'s Employee monthly salary = $" + totalSalary + " USD";
    }

}
