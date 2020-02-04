public class Driver {
    public static void main(String[] args) {
        Employee liam = new Employee();
        Employee linda = new Employee();

        liam.setName("Liam Jones");
        linda.setName("Liam Jones");
        liam.setLanguage("Java");
        linda.setLanguage("Java");
        liam.setSalary(150000);
        linda.setSalary(180000);

        System.out.println(liam.getName() + " makes $" + liam.getSalary() + " and likes " + liam.getLanguage() + " programming language.");
        System.out.println(linda.getName() + " makes $" + linda.getSalary() + " and likes " + linda.getLanguage() + " programming language.");
    }
}
