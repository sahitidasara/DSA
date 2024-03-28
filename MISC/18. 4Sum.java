/*
# Consider 2 base elements and adjacent to the 2nd element as 3rd elem & last elem as 4th elem
# Calculate the sum. If sum exceeds target which means decrease the elem===> last elem--. lly if sum is less than target ==> 3rd elem ++
# Arrays should be distinct. So, add sub-arrays into set then to ArrayList
*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        //Consider 2 base elements & check if you can create sub-arrays
        for(int i =0;i<nums.length-1;i++){
            for(int j = i+1; j<nums.length;j++){
                int k = j+1;
                int last = nums.length-1;
                long sum=0;
                while(k<last){
                sum =(long) nums[i]+(long)nums[j]+(long)nums[k] + (long)nums[last];
                if(sum==target){
                    List<Integer> sublist = new ArrayList<>();
                    sublist.add(nums[i]);
                    sublist.add(nums[j]);
                    sublist.add(nums[k]);
                    sublist.add(nums[last]);
                    set.add(sublist);

                    k++;
                    last--;
                }
                else if(sum<target){k++;}
                else{last --;}
                }
            }
        }
        resList.addAll(set);
        return resList;
    }
}
