public class MySecondApp {

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
