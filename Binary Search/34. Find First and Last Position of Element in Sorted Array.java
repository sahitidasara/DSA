/*
since array is sorted--Binary Search
# For lowest index, find on the left side of the interim mid values
# For highest index, find on the right side of the interim mid values
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] resArray = { -1, -1 };
        if (nums.length > 0) {
            findIndex(nums, true, resArray, target);
            findIndex(nums, false, resArray, target);
        }
        return resArray;
    }

    public void findIndex(int[] nums, boolean isLowestIndex, int[] resArray, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                if (isLowestIndex) {// find lowest index
                    resArray[0] = mid;
                    end = mid - 1;
                } else { // find largest index
                    resArray[1] = mid;
                    start = mid + 1;
                }
            }
        }
    }
}
