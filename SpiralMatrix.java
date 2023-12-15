/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 */

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> items = new ArrayList<>();
        returnOuterFrame(matrix, items, 0, n-1, m-1);
        return items;
    }

    public void returnOuterFrame(int[][] matrix, List<Integer> items, int startRow, int endColumn, int endRow) {
        for (int j=startRow; j<=endColumn; j++) {
            items.add(matrix[startRow][j]);
        }
        if (startRow == endRow) return;
        for (int i=startRow+1; i<=endRow; i++) {
            items.add(matrix[i][endColumn]);
        }
        if (startRow == endColumn) return;
        for (int j=endColumn-1; j>=startRow; j--) {
            items.add(matrix[endRow][j]);
        }
        for (int i=endRow-1; i>=startRow+1; i--) {
            items.add(matrix[i][startRow]);
        }
        if (startRow + 1 > endRow - 1 || startRow + 1 > endColumn - 1) return;
        returnOuterFrame(matrix, items, startRow+1, endColumn-1, endRow-1);
    }

}
