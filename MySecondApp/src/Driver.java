public class Driver {
    public static void main(String[] args) {
        Employee liam = new Employee();
        Employee linda = new Employee();
        System.out.println(liam.getName());
        liam.setName("Liam Jones");
        linda.setName("Liam Jones");
        liam.setLanguage("Java");
        linda.setLanguage("Java");
        liam.setSalary(150000);
        linda.setSalary(180000);

        System.out.println(liam.getName() + " makes $" + liam.getSalary() + " and likes " + liam.getLanguage() + " programming language.");
        System.out.println(linda.getName() + " makes $" + linda.getSalary() + " and likes " + linda.getLanguage() + " programming language.");

        Employee david = new Employee("David Jones", 170000,"Java");
        System.out.println(david.getName() + " makes $" + david.getSalary() + " and likes " + david.getLanguage() + " programming language.");

        int five = 5;

        five %= 2;
        System.out.println(five);
    }
}
