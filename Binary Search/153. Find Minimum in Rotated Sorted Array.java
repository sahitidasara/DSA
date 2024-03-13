/*
since array is sorted--Binary Search
# If array is not rotated, return the min value;
# Check if you can build any comparison b/w (mid, end), (mid,mid+1), (mid,mid-1)
*/

class Solution {
    public int findMin(int[] nums) {
        int start =0;
        int end=nums.length-1;
        int mid;
        if(nums.length==1){return nums[0];}
        // sorted array without rotation
        if(nums[end] > nums[0]){return nums[0];}
        // sorted array with rotation
        while(start<end){
            mid = start + (end-start)/2;
           if(nums[mid]<nums[mid+1] && nums[mid]<nums[mid-1]){return nums[mid];}
            if(nums[mid]<nums[end]){end = mid;}
            else if(nums[mid]>nums[end]){start=mid+1;}
        }
        return nums[start];
    }
}
