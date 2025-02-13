package cci.arraystrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

  static String sort(String str){
    var arr = str.toCharArray();
    Arrays.sort(arr);
    return new String(arr);
  }


  // complexity: O(n log n)
  // space: O(n)
  static boolean isPermutationBySort(String str1, String str2){
    if(str1.length() != str2.length()){
      return false;
    }

    return sort(str1).equals(str2);
  }

  // complexity: O(n)
  // space: O(n)
  static boolean isPermutationByBuffer(String str1, String str2){

    if(str1.length() != str2.length()){
      return false;
    }

    Map<Character, Integer> buffer = new HashMap<>();

    for(char c : str1.toCharArray()){
      buffer.put(c, buffer.getOrDefault(c, 0) + 1);
    }

    for(char c: str2.toCharArray()){
      Integer count = buffer.get(c);
      if(count == null || count <= 0){
        return false;
      } else {
        buffer.put(c, count - 1);
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(" " + isPermutationByBuffer("abc", "cde"));
    System.out.println(" " + isPermutationByBuffer("abc", "cba"));
    System.out.println(" " + isPermutationByBuffer("abc", "abb"));
  }
}
