public class Looping {

  public static void main(String[] args) {
    for(int i = 0; i <10; i++) {
      System.out.println("Number " + i);
    }

    String largeString = "testingthisrightnow";
    String smallSubString = largeString.substring(5,9);
    System.out.println(smallSubString);
    System.out.println(largeString);
  }
}
