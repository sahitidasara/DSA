/*
since array is sorted--Binary Search
# As all elements except one has one duplicate value, based on index do BS on left or right side of mid
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start =0;
        int end = nums.length-1;
        int mid;
        while(start<end){
            mid=start+(end-start)/2;
            if(mid ==0){return nums[0];}
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){return nums[mid];}
            if(mid%2==0){
                if(nums[mid]==nums[mid-1]){end=mid-2;}
                if(nums[mid]==nums[mid+1]){start=mid+2;}
                
            }
            else{
                if(nums[mid]==nums[mid-1]){start=mid+1;}
                if(nums[mid]==nums[mid+1]){end=mid-1;}
            }
        }
        return nums[start];
    }
}
