/* 
since array is sorted--Binary Search
# Find the maximum element
# check in left-side of peak then right-side
*/

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int start = 0;
        int end = len - 1;
        int mid;
        int index = -1;
         int maxIndex = -1;
        while(start<=end){
            mid = start + (end-start)/2;
             if(mid == 0){
                maxIndex = mountainArr.get(0)>mountainArr.get(1) ? 0:1;
                break;
            }
            if(mountainArr.get(mid) > mountainArr.get(mid-1)){
                start = mid + 1;
            }
            else if(mountainArr.get(mid) < mountainArr.get(mid-1)){
                end = mid - 1;
            }
        }
      if(maxIndex <0){  maxIndex = start -1 ;}
        //check for target in left side of peak
        start =0;
        end = maxIndex;
        while(start<= end){
            mid = start + (end-start)/2;
            if(mountainArr.get(mid)>target){
                end = mid -1;
            }
            else if(mountainArr.get(mid) < target){
                start = mid + 1;
            }
            else
            {
                index = mid; 
                break;
            }
        }
        if(index >=0){
            return index;
        }

        //check for target in right side of peak
        start = maxIndex;
        end = len -1;
        while(start<= end){
            mid = start + (end-start)/2;
            if(mountainArr.get(mid)<target){
                end = mid -1;
            }
            else if(mountainArr.get(mid) > target){
                start = mid + 1;
            }
            else
            {
                index = mid; 
                break;
            }
        }
        if(index >=0){
            return index;
        }
        return -1;
    }
}
