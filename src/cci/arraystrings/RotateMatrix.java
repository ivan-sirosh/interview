package cci.arraystrings;

import java.util.Arrays;

public class RotateMatrix {
  static boolean rotate(int[][] matrix) {
    if (matrix.length == 0 || matrix.length != matrix[0].length) {
      return false;
    }

    int n = matrix.length;

    for (int layer = 0; layer < n / 2; layer++) {
      int first = layer;
      int last = n - 1 - layer;
      for (int i = first; i < last; i++) {
        int offset = i - first;

        int top = matrix[first][i]; // save top

        // left to top
        matrix[first][i] = matrix[last - offset][first];

        // bottom to left
        matrix[last - offset][first] = matrix[last][last - offset];

        // right to bottom
        matrix[last][last - offset] = matrix[i][last];

        // top to right
        matrix[i][last] = top;

      }
    }

    return true;
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][] {
        { 1, 1, 1, 1 },
        { 2, 2, 2, 2 },
        { 3, 3, 3, 3 },
        { 4, 4, 4, 4 }
    };

    rotate(matrix);
    rotate(matrix);

    System.out.println(Arrays.toString(matrix[0]));
    System.out.println(Arrays.toString(matrix[1]));
    System.out.println(Arrays.toString(matrix[2]));
    System.out.println(Arrays.toString(matrix[3]));
  }
}
