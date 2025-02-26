package leetcode.easy;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be
 * constructed by using the letters from magazine and false otherwise.
 * 
 * Each letter in magazine can only be used once in ransomNote.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * 
 * Example 2:
 * 
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * 
 * Example 3:
 * 
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 * 
 * 
 */

public class RansomNode {
  static boolean canConstruct(String ransomNote, String magazine) {
    if (ransomNote == null || magazine == null) {
      return false;
    }

    int[] buffer = new int[128];
    for (int i = 0; i < magazine.length(); i++) {
      char c = magazine.charAt(i);
      buffer[c] = buffer[c] + 1;
    }

    for (int i = 0; i < ransomNote.length(); i++) {
      char c = ransomNote.charAt(i);
      buffer[c] = buffer[c] - 1;
      if (buffer[c] < 0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(canConstruct("a","b"));
    System.out.println(canConstruct("aa","ab"));
    System.out.println(canConstruct("aa","aab"));
    System.out.println(canConstruct("aa","AA"));
  }
}
