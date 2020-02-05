package trivera.core.employee;

public class Vendor implements Payable{

  @Override
  public double calcSalary() {
    return 5000;
  }

  @Override
  public String getName() {
    return "Richie Rich";
  }
}
