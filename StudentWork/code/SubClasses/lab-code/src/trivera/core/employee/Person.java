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



public class Person {
    // LAB HINT: Declare the private instance field called name
  private String name;

  // LAB HINT: Don't forget the default constructor

  public Person(){}

  // LAB HINT: Complete constructor which takes a string argument for name
  public Person(String name){
    this.setName(name);
  }


  // LAB HINT: Override the equals() method

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Person) {
      Person p = (Person) obj;
      if(this.name.equals(p.name)) {
        return true;
      }
    }
    return false;
  }

  // LAB HINT: Override the toString() method

  @Override
  public String toString() {
    return super.toString();
  }

  // LAB HINT: Write the get and set methods for the name instance variable
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
