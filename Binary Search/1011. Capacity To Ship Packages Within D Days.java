/*
For sure, the o/p value lies in the range [max elem in arr, sum of arr]. So, use BS
# Consider start, end, mid values as in BS. Check if the no. of days with the considered mid value is equal to the i/p days value.
# Update end value if mid is less than the i/p days value to (mid-1) and if greater update start to (mid+1)
# There can be a chance where the no. of days will be matched with multiple mid values. The goal is to find the min value. So, do a minimum check everytime
*/

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // The capacity lies in the range [max in arr, sum of arr]
        int sumOfArr = 0;
        for (int i : weights) {
            sumOfArr += i;
        }
        // Find max elem in the arr
        int[] sortedArr = weights.clone();
        Arrays.sort(sortedArr);
        int start = sortedArr[sortedArr.length - 1];
        int end = sumOfArr;
        int mid = 0;
        int subArrSum = 0;
        int minCapacity = Integer.MAX_VALUE;
        int daysCount = 0;
        while (start <= end) {
            daysCount = 0;
            mid = start + (end - start) / 2;
            subArrSum = 0;
            for (int i = 0; i < weights.length; i++) {
                if (subArrSum + weights[i] == mid) {
                    daysCount++;
                    subArrSum = 0;
                } else if (subArrSum + weights[i] > mid) {
                    daysCount++;
                    subArrSum = weights[i];
                } else {
                    subArrSum += weights[i];
                }

            }
            if (subArrSum > 0 && subArrSum < mid) {
                daysCount++;
            }
            if (daysCount < days) {
                end = mid - 1;
            } else if (daysCount > days) {
                start = mid + 1;
            } else {
                minCapacity = Math.min(minCapacity, mid);
                end = mid - 1;
                // if(start>end){return minCapacity;}
            }
        }

        return start;
    }
}
