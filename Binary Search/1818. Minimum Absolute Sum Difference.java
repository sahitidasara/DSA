/*
For each element in nums2, find floor and ceil. This reduces the difference.
# Make a copy of nums1---> sort it---> find floor and ceil of nums2's elements in sorted nums1 using BS
# For each elem, calculate the difference by replacing with floor and then with ceil. Keep track of the max difference occurred wrt the actual diff for that elem and also track position.
*/

class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
int mod = (int) 1e9+7;

        // Check if replacement can reduce absolute diff
        int[] nums1Copy = nums1.clone();
        Arrays.sort(nums1Copy);

        int maxDiff = 0; // maximum difference between original and new absolute diff
        int pos = 0; // where the maximum difference occurs
        int newn1 = 0; // nums1 value to copy to nums1[pos]

        // For each element in nums2, find it's ceil and floor in nums1 which can reduce
        // the diff by replacing with ceil/floor.

        for (int i = 0; i < nums2.length; i++) {
            int origDiff = Math.abs(nums1[i] - nums2[i]);
            int floor = floorVal(nums1Copy, nums2[i]);
            if (floor > Integer.MIN_VALUE) {
                int newDiff = Math.abs(floor - nums2[i]);
                int diff = origDiff - newDiff;
                if (diff > maxDiff) {
                    pos = i;
                    newn1 = floor;
                    maxDiff = diff;
                }
            }

            int ceil = ceilVal(nums1Copy, nums2[i]);
            if (ceil < Integer.MAX_VALUE) {
                int newDiff = Math.abs(ceil - nums2[i]);
                int diff = origDiff - newDiff;
                if (diff > maxDiff) {
                    pos = i;
                    newn1 = ceil;
                    maxDiff = diff;
                }
            }

        }

        //If found a replacement value, overwrite in nums1 and find the absolute diff now
        if(newn1>0){
            nums1[pos] = newn1;
        }

        int abs=0;
        for (int i = 0; i < nums1.length; i++) {
            abs = (abs + Math.abs(nums1[i] - nums2[i]))% mod;
        }
        return abs;
    }

    int floorVal(int[] arr, int val) {
        // Here array is sorted
        int start = 0;
        int end = arr.length - 1;
        int mid;
        int max = Integer.MIN_VALUE;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] <= val) {
                max = arr[mid];
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return max;
    }

    int ceilVal(int[] arr, int val) {
        // Here array is sorted
        int start = 0;
        int end = arr.length - 1;
        int mid;
        int min = Integer.MAX_VALUE;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] >= val) {
                min = arr[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return min;
    }
}
