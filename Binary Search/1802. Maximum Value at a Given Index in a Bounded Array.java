/*
The desired value lies in the range of [1,maxSum]. So, come to a conclusion to use BS
# Use left, right, mid same as typical BS
# Check if the array is forming with the requested no. of elements and maxSum. Form array and calculate sum. 
# Calculate the <left side elem sum> + mid + <right side elem sum>.   If sum > desired maxSum, left = mid+1 else right = mid-1
# The logic for left side and right elements sum is same
# consider left terms for now. Check if no. of left terms are more than the possible target value(mid-1). PS: mid is not constant. It changes if desired sum is not obtained by summing left and right terms
# For eg., left terms are 6, target =5, then for sure 1 term has to be 1 and the rest 5 terms can be in Arithmetic Progression
# if left terms are 5 and target =6, then apply AP for all 6 elements then subtract the AP for the diff of left terms and target.
*/

class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int left = 1;
        int right = maxSum;
        int ans = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(isPossible(mid,n,index,maxSum)){
                ans = Math.max(ans,mid);
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return ans;
    }
    public boolean isPossible(int mid, int n, int index , long maxSum){
        int right = n-index-1;
        int left = index;
        maxSum -= mid;
        maxSum -= findSum(mid,left);
        maxSum -= findSum(mid,right);
        return maxSum>=0;
    }
    public long findSum(int mid , int space){
        long target = mid-1;
        long sum = 0;
        if(space>=target){
            sum += (space-target);
            sum += (target*(target+1))/2;
        }
        else{
            long diff = target-space;
            sum += (target*(target+1))/2;
            sum -= ((diff)*(diff+1))/2;
        }
        return sum;
    }
}
