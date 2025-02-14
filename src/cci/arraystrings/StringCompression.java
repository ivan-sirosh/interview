package cci.arraystrings;

public class StringCompression {

  // Time Complexity: O(n)
  // Space Complexity: O(n) (due to StringBuffer storing compressed string)
  static String compress(String str) {

    StringBuffer buffer = new StringBuffer();

    int countChar = 0;
    for (int i = 0; i < str.length(); i++) {
      countChar++;

      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
        buffer.append(str.charAt(i));
        buffer.append(countChar);
        countChar = 0;
      }
    }

    return buffer.length() < str.length() ? buffer.toString() : str;
  }


  public static void main(String[] args) {
    System.out.println(compress("aaaabccccbaaabb"));
    System.out.println(compress("abc"));
  }

}
