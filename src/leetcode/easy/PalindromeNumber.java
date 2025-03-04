package leetcode.easy;

/**
 * Given an integer x, return true if x is a
 * 
 * , and false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * 
 * Example 2:
 * 
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it
 * becomes 121-. Therefore it is not a palindrome.
 * 
 * Example 3:
 * 
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * 
 * 
 * 
 * Constraints:
 * 
 * -231 <= x <= 231 - 1
 * 
 * 
 * Follow up: Could you solve it without converting the integer to a string?
 */
public class PalindromeNumber {
  static boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }

    if (x < 10) {
      return true;
    }

    int[] buffer = new int[(int) Math.log10(x) + 1]; // Math.log10(11) returns 1.000043, Math.log10(121) returns 2.08922

    int d = 0;

    while (x > 0) {
      buffer[d] = (x % 10);
      x /= 10; // shift left (5943 -> 594)
      d++;
    }

    int i = 0;
    int j = buffer.length - 1;

    while (i <= j) {
      if (buffer[i] != buffer[j]) {
        return false;
      } else {
        i++;
        j--;
      }
    }

    return true;

  }

  public static void main(String[] args) {
    System.out.println(isPalindrome(121));
    System.out.println(isPalindrome(0));
    System.out.println(isPalindrome(11));
    System.out.println(isPalindrome(-121));
  }
}
