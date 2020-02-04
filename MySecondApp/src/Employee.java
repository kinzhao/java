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
    public void setName(String name) {
        if(name != null) {
            String result[] = name.split(" ");
            this.firstName = result[0];
            this.lastName = result[1];
        }
    }

    public void setLanguage(String language) {
        if(language != null) {
            this.language = language;
        }
    }

    public void setSalary(int salary) {
        if(salary > 0) {
            this.salary = salary;
        }
    }

    public Employee() {
        this("John Doe");
    }

    public Employee(String name) {
        this.setName(name);
    }

    public Employee(String name, int salary) {
        this.setName(name);
        this.setSalary(salary);
    }

    public Employee(String name, int salary, String language) {
        this.setName(name);
        this.setSalary(salary);
        this.setLanguage(language);
    }
}
