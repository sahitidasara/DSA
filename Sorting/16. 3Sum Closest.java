/*
# Sort the elements
# Take 3 pointers. One is iteration from 0 to length-2, left from i+1 and right as length-1
# Consider a variable closest as sum of first three elements. For every iteration, check if i+left+ right == target
# If not compare the absolute diff of this sum with target and absolute diff of the closest with target. If sum<target increment left pointer;
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum =nums[i] + nums[left] + nums[right];
                if(sum==target) return target;
                if(Math.abs(target-sum) < Math.abs(target-closest)) closest = sum;
                if(sum<target) left++;
                else right--;
            }
        }
        return closest;
    }
}
