package cci.arraystrings;

public class OneAway {


  // complexity O(n) whe n is the longest string
  // space O(1)
  static boolean oneAwayEdit(String str1, String str2) {
    if (str1.length() == str2.length()) {
      return checkReplace(str1, str2);
    } else if (str1.length() + 1 == str2.length()) {
      return checkInsertion(str2, str1);
    } else if (str1.length() == str2.length() + 1) {
      return checkInsertion(str1, str2);
    }

    return false;
  }

  static boolean checkReplace(String str1, String str2) {
    int differnce = 0;

    for (int i = 0; i < str1.length(); i++) {
      if (str1.charAt(i) != str2.charAt(i)) {
        differnce++;
      }
    }

    return differnce == 1;
  }

  static boolean checkInsertion(String result, String source){
    int sourceIndex = 0;
    int resultIndex = 0;
    
    while(sourceIndex < source.length() && resultIndex < result.length()){
      if (source.charAt(sourceIndex) == result.charAt(resultIndex)) {
        sourceIndex++;
        resultIndex++;
      } else {
        if(sourceIndex != resultIndex){
          return false;
        }
        resultIndex++;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(oneAwayEdit("pale", "ple"));
    System.out.println(oneAwayEdit("pales", "pale"));
    System.out.println(oneAwayEdit("pale", "bale"));
    System.out.println(oneAwayEdit("pale", "bae"));
  }
}
