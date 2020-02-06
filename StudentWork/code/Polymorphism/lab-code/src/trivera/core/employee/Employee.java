package trivera.core.employee;

/**
 * <p>
 * This component and its source code representation are copyright protected
 * and proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera Technologies
 *
 * This component and source code may be used for instructional and
 * evaluation purposes only. No part of this component or its source code
 * may be sold, transferred, or publicly posted, nor may it be used in a
 * commercial or production environment, without the express written consent
 * of Trivera Technologies, LLC
 *
 * Copyright (c) 2020 Trivera Technologies, LLC.
 * http://www.triveratech.com   
 * </p>
 * @author Trivera Technologies Tech Team.
 */


public class Employee extends Person implements Payable{
    private int empID;

    private Employee manager;

    public Employee() {
    }

    public Employee(String name, int empID){
        super(name);
        setEmpID(empID);
    }

    public int getEmpID() {
        return empID;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public void setEmpID(int empID){
        if(empID > 99 && empID < 1000)
            this.empID = empID;
        else
            throw new IllegalArgumentException("Invalid Employee Id");
    }

    public double calcSalary() {
        return 0.0;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append(" - empID: ").append(empID);
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
