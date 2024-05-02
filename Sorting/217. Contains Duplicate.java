/*
# Don't use Arrays.sort(), sets, nested loops
# Use Insertion sort
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        for(int i=0;i<=nums.length-2;i++){
            int j = i+1;
            while(j>0){
            if(nums[j]<nums[j-1]){
                //swap j and j-1 th terms
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
                j--;
            }else if(nums[j]==nums[j-1]) return true;
            else break;
            }
            
        }
return false;
    }
}
