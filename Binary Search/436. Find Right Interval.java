//Regular search
/*
# For each element, find the element that is greater than or equal to the chosen element.
# There could be a possibility where the start and end intervals are same
*/

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] == intervals[i][1]) {
                res[i] = i;
            } else {
                res[i] = findGreaterElement(intervals, i);
            }
        }
        return res;
    }

    public static int findGreaterElement(int[][] intervals, int rowNo) {
        int min = rowNo;
        for (int i = 0; i < intervals.length; i++) {
            if (i == rowNo) {
                continue;
            }
            // find min value that is greater than or equal to the element
            if (intervals[rowNo][1] <= intervals[i][0]) {
                if (min == rowNo) {
                    min = i;
                } else if (intervals[min][0] > intervals[i][0]) {
                    min = i;
                }
            }
        }
        if (min == rowNo) {
            return -1;
        } else {
            return min;
        }
    }
}
