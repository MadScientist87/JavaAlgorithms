package Algorithms.BloomBerg;

import java.util.ArrayList;
import java.util.List;

public class MatrixMultiplication {

    public int[][] multiply(int[][] mat1, int[][] mat2) {
        ArrayList<Integer> masterList = new ArrayList<>();
        int[][] result = new int[mat1.length][mat2[0].length];

        for(int i = 0; i < mat1.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            for(int j = 0; j < mat1[0].length;j++) {
                tmp.add(mat1[i][j]);
            }
            // traverse through columns of mat2
            for(int col = 0; col < mat2[0].length; col++) {
                int sum = 0;
                for(int row = 0; row < mat2.length; row++) {
                    sum += tmp.get(row) * mat2[row][col];
                }
                masterList.add(sum);
            }

        }

        int listCounter = 0;
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length; j++) {
                result[i][j] = masterList.get(listCounter++);
            }
        }


        return  result;
    }
}
