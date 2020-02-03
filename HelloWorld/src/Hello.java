import java.util.Scanner;

/**
 * Summary
 */
public class Hello {
    /**
     * This the entry point into my program.
     * @param args
     */
    private static String firstName;
    private static String lastName;
    private static String language;

    public Hello(String newName) {
        String result[] = newName.split(" ");
        firstName = result[0];
        lastName = result[1];
    }

    static String getName() {
        return firstName + " " + lastName;
    }

    static String getLanguage() {
        return language;
    }

    public static void setLanguage(String newLanguage) {
        language = newLanguage;
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        // Enter name and press Enter
        System.out.println("Enter name");
        Hello me = new Hello(myObj.nextLine());
        System.out.println("Hello " + me.getName() + "!");
        System.out.println("Enter favorite programming language");
        me.setLanguage(myObj.nextLine());
        System.out.println("My favorite programming language is " + me.getLanguage() + "!");
    }

}
