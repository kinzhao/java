public class Employee {
    private static String firstName;
    private static String lastName;
    private static String language;
    private int salary;

    //Getters
    public String getName() {return this.firstName + " " + this.lastName;}
    public String getLanguage() {return this.language;}
    public int getSalary() {return this.salary; }

    //Setters
    public void setName(String newName) {
        String result[] = newName.split(" ");
        this.firstName = result[0];
        this.lastName = result[1];
    }

    public void setLanguage(String newLanguage) {
        this.language = newLanguage;
    }

    public void setSalary(int newSalary) {
        this.salary = newSalary;
    }

}
