/*
# Create new array and place even on the left half & odd on the right half
# swap the elements
*/
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int start = 0, end = nums.length - 1;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                res[start] = nums[i];
                start++;
            } else {
                res[end] = nums[i];
                end--;
            }
        }

        for (int i = 1, k = res.length - 2; i < res.length / 2;) {

            swap(res,i, k);
            i = i + 2;
            k = k - 2;
        }
        return res;
    }

    public static void swap(int[] res, int i, int j) {
        int temp = res[i];
        res[i] = res[j];
        res[j] = temp;
    }
}
