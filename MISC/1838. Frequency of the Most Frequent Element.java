/*
Question is to find the max freq with utmost "k" operations i.e., look for the sub-arrays that doesn't exceed k
# Sort the array
# Form sub-arrays and check if the sum of sub-array and K is greater than the last elem in sub-array * no.of elems in sub-array i.e., you are checking if you can make all the elements in the sub-array as the last elem in sub-array
# If the condition failed, then remove left element from the sub-array & reduce it from the sum
# Find the max b/w prev Max and the no. of elements left
*/

class Solution {
    public int maxFrequency(int[] nums, int k) {
        int[] sortedArr = nums.clone();
        Arrays.sort(sortedArr);
        int maxFreq = 0;
        long currentSum = 0;
        int countInSubArray = 0;

        for (int left = 0, right = 0; right < sortedArr.length; right++) {
            currentSum += sortedArr[right];
            while (left < sortedArr.length && currentSum + k < (long) sortedArr[right] * (right - left + 1)) {
                currentSum -= sortedArr[left];
                left++;
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
        }
        return maxFreq;

    }
}
