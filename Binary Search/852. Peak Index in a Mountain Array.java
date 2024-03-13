/*
Mountain refers that array is partially sorted--BS
*/

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        // Linear search
        // int max = 0;
        // for(int i =1; i<arr.length;i++){
        //     if(arr[i]>arr[max]){
        //         max = i;
        //     }
        // }
        // return max;


        //Binary search
        int start =0;
        int end = arr.length -1;
        int mid;
        while(start<=end){
            mid = start + (end-start)/2;
            if(mid == 0){
                return arr[0]>arr[1] ? 0:1;
            }
            if(arr[mid] > arr[mid-1] ){
                start = mid +1;
            }else if(arr[mid] < arr[mid-1] ){
                end = mid - 1;
            }
        }
        return start-1;
    }
}
