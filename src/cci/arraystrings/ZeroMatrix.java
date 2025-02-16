package cci.arraystrings;

import java.util.Arrays;

public class ZeroMatrix {

  static void setZeros(int[][] matrix) {
    boolean[] rows = new boolean[matrix.length];
    boolean[] columns = new boolean[matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          rows[i] = true;
          columns[j] = true;
        }
      }
    }

    for (int i = 0; i < rows.length; i++) {
      if (rows[i]) {
        for (int j = 0; j < matrix[i].length; j++) {
          matrix[i][j] = 0;
        }
      }
    }

    for (int j = 0; j < columns.length; j++) {
      if (columns[j]) {
        for (int i = 0; i < matrix.length; i++) {
          matrix[i][j] = 0;
        }
      }
    }

  }


  public static void main(String[] args) {
    
    int[][] matrix = new int[][]{
      {1,1,1,0,1,1,1,1,1},
      {1,1,1,1,1,1,1,1,1},
      {1,1,1,1,1,1,1,1,1},
      {1,0,1,1,1,1,1,1,1},
      {1,1,1,1,1,1,1,1,1},
    };

    setZeros(matrix);

    System.out.println(Arrays.toString(matrix[0]));
    System.out.println(Arrays.toString(matrix[1]));
    System.out.println(Arrays.toString(matrix[2]));
    System.out.println(Arrays.toString(matrix[3]));
    System.out.println(Arrays.toString(matrix[4]));

  }

}
