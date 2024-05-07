/*
# sort the array
# Take 3 pointers i, left, right. Check if their sum = 0. If so, create a list and add it in the response list
# Think that the sum<0. the values should be a bit greater. Increment left pointer
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if ((nums[i] + nums[left] + nums[right]) == 0) {
                    List<Integer> inner = new ArrayList<>();
                    inner.add(nums[i]);
                    inner.add(nums[left]);
                    inner.add(nums[right]);
                   if(!ans.contains(inner)) ans.add(inner);
                    left++;
                    right--;
                } else if ((nums[i] + nums[left] + nums[right]) < 0)
                    left++;
                else
                    right--;
            }
        }
        return ans;
    }
}
