package zth.datastructure.hashtables;

import java.util.HashSet;
import java.util.Set;

public class FirstRecuringCharacter {

  static int findValuesOf(int[] arr) {

    Set<Integer> knownValues = new HashSet<Integer>();

    for (int i = 0; i < arr.length; i++) {
      int v = arr[i];
      if (knownValues.contains(v)) {
        return v;
      } else {
        knownValues.add(v);
      }
    }

    throw new NullPointerException("no values");
  }

  public static void main(String[] args) {

    // Given an array = [ 2,5,1,2,3,5,1,2,4]
    // should return 2

    int[] input = new int[] { 2, 5, 1, 2, 3, 5, 1, 2, 4 };
    findValuesOf(input);

    // Given an array = [ 2,1,1,2,3,5,1,2,4]
    // should return 1

    input = new int[] { 2, 1, 1, 2, 3, 5, 1, 2, 4 };
    findValuesOf(input);

    // Given an array = [ 2,3,4,5]
    // should trow an exception

    input = new int[] { 2, 3, 4, 5 };
    findValuesOf(input);

  }

}
