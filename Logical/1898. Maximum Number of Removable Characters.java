/*
# count can be determined using BS
# replace the removing char to any special char and check if subsequence is possible
*/
class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int start=0;
        int end = removable.length-1;
        int mid;
        char[] arr = s.toCharArray();
        while(start<=end){
            mid = start + (end-start)/2;
            for(int i=start;i<=mid;i++){
                arr[removable[i]]= ' ';
            }
            if(checkSub(arr,p.toCharArray())){
                start = mid+1;
            }
            else{
                for(int i=start;i<=mid;i++){arr[removable[i]] = s.charAt(removable[i]);}
                end = mid-1;
            }
        }
        return end+1;
    }
    public boolean checkSub(char[] s,char[] p){
        int i=0;
        int j=0;
        while(i<s.length && j<p.length){
            if(s[i]==p[j]){
                i++;
                j++;
                continue;
            }
            i++;
        }

        if(j==p.length){return true;}
        return false;
    }
}
