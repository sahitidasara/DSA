/*
Since arr is sorted ==> BS
# Take middle column as base, by comparing the elements with previous row and next row, eliminate rows such that you'll be left with 2 rows at the end
# Within those 2 rows, check if target exists in the middle column else divide the 2 rows into 4 parts as below
#  Do BS for 4 parts in the resultant matrix with 2 rows and rows[0].length columns
        part1: row[0], left side cols wrt mid
        part2: row[0], right side cols wrt mid
        part3: row[1], left side cols wrt mid
        part4: row[1], right side cols wrt mid
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length; // be cautious, matrix may be empty
        if (cols == 0){
            return false;
        }
        if (rows == 1) {
            return binarySearch(matrix,0, 0, cols-1, target);
        }
        if(cols==1)
        {
            return binarySearchInCol(matrix, cols-1, 0, rows-1, target);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;

        // run the loop till 2 rows are remaining
        while (rStart < (rEnd - 1)) { // while this is true it will have more than 2 rows
            int mid = rStart + (rEnd - rStart) / 2;
            if (matrix[mid][cMid] == target) {
                return true;
            }
            if (matrix[mid][cMid] < target) {
                rStart = mid;
            } else {
                rEnd = mid;
            }
        }

        // now we have two rows
        // check whether the target is in the col of 2 rows
        if (matrix[rStart][cMid] == target) {
            return true;
        }
        if (matrix[rStart + 1][cMid] == target) {
            return true;
        }

       //Do BS for 4 parts in the resultant matrix with 2 rows and rows[0].length columns
        //part1: row[0], left col
        
        if (target <= matrix[rStart][cMid]) {
            return binarySearch(matrix, rStart, 0, cMid, target);
        }

        //part2: row[0], right col
        if (target >= matrix[rStart][cMid] && target<=matrix[rStart][matrix[0].length-1]) {
            return binarySearch(matrix, rStart, cMid, matrix[0].length - 1, target);
        }

        //part3: row[1], left col
        if (target <= matrix[rEnd][cMid]) {
            return binarySearch(matrix, rEnd, 0, cMid, target);
        }

        //part4: row[1], right col
        if (target >= matrix[rEnd][cMid]) {
            return binarySearch(matrix, rEnd, cMid, matrix[0].length - 1, target);
        }
        return false;
    }


 boolean binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;
            if (matrix[row][mid] == target) {
                return true;
            }
            if (matrix[row][mid] < target) {
                cStart = mid + 1;
            } else {
                cEnd = mid - 1;
            }
        }
        return false;
    }

    boolean binarySearchInCol(int[][] matrix, int col, int rStart, int rEnd, int target) {
        while (rStart <= rEnd) {
            int mid = rStart + (rEnd - rStart) / 2;
            if (matrix[mid][col] == target) {
                return true;
            }
            if (matrix[mid][col] < target) {
                rStart = mid + 1;
            } else {
                rEnd = mid - 1;
            }
        }
        return false;
    }
}
