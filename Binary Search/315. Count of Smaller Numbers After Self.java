/*
When you sort the array, it becomes BS
# Consider an element and sort elements. Slicing into sub-arrays directly could lead to TLE
# Create arrayList and sort this list. Remove element from the list once you get the answer for that element. This reduces the runtime.
# Within the arrayList do BS and search for the element. This index itself tells how many elements are smaller ( to it's left all are small elements). Later, remove this element from list
*/
class Solution {
    public List<Integer> countSmaller(int[] nums) {

        List<Integer> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<Integer>();
        for(int num: nums){arr.add(num);}Collections.sort(arr);
        for (int i = 0; i < nums.length - 1; i++) {
            int count = 0;
            int start = 0;
            int end = arr.size() - 1;
            int mid;
            int target = nums[i];
            while (start <= end) {
                mid = start + (end - start) / 2;
              //There is a possibility of duplicate values. So, not setting count = mid as there could be same value as mid to it's left which will add to the count (So, removing this validation)
                // if (arr.get(mid) == target) {
                //     count = mid;
                //     break;
               if (arr.get(mid) < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            if(arr.get(start) == target){count=start;}
            res.add(count);
           arr.remove(count);
        }
        // For last element, appending 0
        res.add(0);
        return res;

        // Brute force approach
        // List<Integer> res = new ArrayList<>();
        // for (int i = 0; i < nums.length - 1; i++) {
        // int count = 0;
        // for (int j = i + 1; j < nums.length; j++) {
        // if (nums[j] < nums[i]) {
        // count++;
        // }
        // }
        // res.add(count);
        // }
        // // For last element, appending 0
        // res.add(0);
        // return res;
    }
}
