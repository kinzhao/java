package trivera.core.employee;

//import trivera.core.employee.*;

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



public class Employee extends Person // LAB HINT: What goes here for sub-classing
{
  // LAB HINT: Add the instance variable
  private int emplID;

  // LAB HINT: Add your constructors here
  public Employee() {

  }

  public Employee(String name) {
    super(name);
  }

  public Employee(String name, int emplId) {
    super(name);
    setEmplID(emplId);
  }
  // LAB HINT: Code get and set methods for the instance variable


  // LAB HINT: Place calcSalary() method here
  public int calcSalary() {
    return 4+3;
  }

  // LAB HINT: Override toString() and equals() method using parent version

  @Override
  public String toString() {
    return super.toString();
  }

  public int getEmplID() {
    return emplID;
  }

  public void setEmplID(int emplID) {
    this.emplID = emplID;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  /*public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append(" - empID: ").append(empID);
        return sb.toString();
    }
    */

    // For Mailable exercise;
/*    public void mailNote(String note) {
        System.out.println("Sending note internal to colleague " + name
                + " with message " + note);
	}
*/


}
