package org.problems.BinarySearch;

public class SearchInMatrix {
    public static void main(String[] args) {

        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,24,60}
        };
        int target = 3;

        System.out.println(searchMatrix(matrix, target));
    }

    // Time : O(log(m * n))
    // Space : O(1)
    private static boolean searchMatrix(int[][] matrix, int target) {

        int rowIndex = searchPotentialRow(matrix, target);

        if(rowIndex != -1){
            return binarySearchOnRow(matrix, target, rowIndex);
        }
        else {
            return false;
        }

    }

    private static int searchPotentialRow(int[][] matrix, int target) {

        int left = 0;
        int right = matrix.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (matrix[mid][0] <= target && target <= matrix[mid][matrix[mid].length - 1]) {
                return mid;
            } else if (target > matrix[mid][0]) {
                left = mid + 1;
            } else if (target < matrix[mid][0]) {
                right = mid - 1;
            }

        }

        return -1;
    }


    private static boolean binarySearchOnRow(int[][] matrix, int target, int rowIndex) {

        int left = 0;
        int right = matrix[rowIndex].length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (matrix[rowIndex][mid] == target) {
                return true;
            } else if (target < matrix[rowIndex][mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
