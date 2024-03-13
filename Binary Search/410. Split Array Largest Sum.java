/*
Bring a conclusion from question that answer lies in the range of max element and sum which means you can try using Binary search for the range.
# Take mid value and sum up the elements in the array no greater than the mid value. Likewise, form sub-arrays. Check if the no. of subarrays are same as per requirement
# If no.of sub arrays are more than the required, increase the mid value else decrease it.
*/

class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int max = nums[0];
        // finding max value and sum of array
        for (int num=0;num<nums.length; num++) {
            sum +=nums[num];
            max = Math.max(max, nums[num]);
        }

        // Desired ans lies in the range[max,sum]
        int start = max;
        int end = sum;
        int mid;

        while (start < end) {
            mid = start + (end - start) / 2;
            sum = 0;
            int pieces = 1;
            for (int num : nums) {
                if (sum + num <= mid) {
                    sum += num;
                } else {
                    sum = num;
                    pieces++;
                }
            }
            if (pieces > k) { // increase mid value
                start = mid + 1;
            } else if (pieces <= k) {
                end = mid;
            }
        }
        return start;
    }
}
