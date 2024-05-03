/*
# Without using sets
# sort the arrays and compare
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                int current = nums1[i];
                while(i<nums1.length && nums1[i]==current) i++;
                while(j<nums2.length && nums2[j]==current) j++;
            } else if (nums1[i] < nums2[j])
                i++;
            else
                j++;
        }
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) == res.get(i - 1)) {
                res.remove(res.get(i));
                i--;
            }
        }
        int[] arr = new int[res.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
