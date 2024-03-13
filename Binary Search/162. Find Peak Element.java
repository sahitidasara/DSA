/* 
since array is sorted--Binary Search
*/

class Solution {
    public int findPeakElement(int[] nums) {
        //Linear Search
        // int max = 0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]>nums[max]){
        //         max = i;
        //     }
        // }
        // return max;

        //Binary Search
        int start=0;
        int end= nums.length-1;
        int mid;
        if(nums.length==1){return 0;}
        while(start<=end){
            mid = start + (end-start)/2;
            if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]){return mid;}
            if(mid<end && nums[mid] < nums[mid+1]){start=mid+1;}
            if(mid<end && nums[mid] > nums[mid+1]){end=mid;}
        }
        return start;
    }
}
