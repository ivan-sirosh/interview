package cci.arraystrings;

public class StringRotation {

  static boolean isRotation(String str1, String str2) {

    if (str1.length() > 0 && str1.length() == str2.length()) {
      return (str1 + str1).contains(str2);

    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(isRotation("watermelon", "elonwaterm"));
    System.out.println(isRotation("watermelon", "elonwate1m"));
  }

}
