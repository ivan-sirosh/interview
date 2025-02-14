package cci.arraystrings;

public class PalindromPermutation {


  // complexity O(n)
  // space O(1)
  static boolean isPermutationOfPalindrome(String str) {

    
    int z = Character.getNumericValue('z');
    int a = Character.getNumericValue('a');
    
    int[] charTable = new int[z - a + 1];
    
    int countOdd = 0;
    
    for (char c : str.toCharArray()) {

      int x = Character.getNumericValue(c);
      if (a <= x && x <= z) {
        charTable[x - a]++;
        if (charTable[x - a] % 2 == 1) {
          countOdd++;
        } else {
          countOdd--;
        }
      }
    }

    return countOdd <= 1;
  }

  public static void main(String[] args) {
    System.out.println(isPermutationOfPalindrome("Tact Coa")); // "tacocat"
  }
}
