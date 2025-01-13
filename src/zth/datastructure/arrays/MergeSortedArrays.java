package zth.datastructure.arrays;

import java.util.Arrays;

public class MergeSortedArrays {

  // arrays are sorted
  // input: ([0,3,4,31], [4,6,30])
  // outpput: [0,3,4,4,30,31]

  // complexity O(n)
  // space O(n)

  static int[] mergeSortedArrays(int[] input1, int[] input2) {

    if (input1 == null && input2 == null) {
      return null;
    }

    if (input1 == null || input1.length == 0) {
      return input2;
    }

    if (input2 == null || input2.length == 0) {
      return input1;
    }

    int[] result = new int[input1.length + input2.length];

    int ri = 0;
    int i1 = 0;
    int i2 = 0;

    while (ri < result.length) {
      if (i1 < input1.length && i2 < input2.length) {
        int item1 = input1[i1];
        int item2 = input2[i2];

        if (item1 < item2) {
          result[ri++] = item1;
          i1++;
        } else {
          result[ri++] = item2;
          i2++;
        }
      } else {
        if (input1.length > input2.length) {
          result[ri++] = input1[i1++];
        } else {
          result[ri++] = input2[i2++];
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {

    int[] input1 = new int[] { 0, 3, 4, 31 };
    int[] input2 = new int[] { 4, 6, 30 };

    System.out.println(Arrays.toString(mergeSortedArrays(input1, input2)));
  }

}
