package cci.arraystrings;

import java.util.HashSet;
import java.util.Set;

public class IsUnique {

  // complexity O(n)
  // space O(n)
  static boolean isUniqueByHash(String str){

    Set<Character> cache = new HashSet<Character>();

    for(int i = 0; i < str.length(); i++){
      if(cache.contains(str.charAt(i))) {
        return false;
      } else {
        cache.add(str.charAt(i));
      }
    }

    return true;
  }

  // complexity O(n)
  // space O(1)
  static boolean isUnique(String str){

    // if ASCII table is not extended, then - 128
    boolean[] cache = new boolean[256];

    if(str.length() >= cache.length) {
      return false;
    }

    for(int i = 0; i < str.length(); i++){
      if(cache[str.charAt(i)]){
        return false;
      }

      cache[str.charAt(i)] = true;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(" " + isUniqueByHash("asd"));
    System.out.println(" " + isUnique("asa"));
    System.out.println(" " + isUnique("1sd"));
  }
}
