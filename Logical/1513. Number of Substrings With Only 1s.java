/*
#Do manual check that for a substring of length 4 can be written as 
(1),(1),(1),(1) ----4
(1,1),(1,1),(1,1) ---3
(1,1,1),(1,1,1) ---2
(1,1,1,1) ---1
no. of subsets = 4+3+2+1 ==>n*(n+1)/2
*/
class Solution {
    public int numSub(String s) {
        long count = 0;
        int subCount=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')subCount++;
            else{ count+=(long)subCount*(subCount+1)/2;
                subCount=0;}
        }
        count+=(long)subCount*(subCount+1)/2;
        long modulo=1000000007L;
        return (int)(count%modulo);
    }
}
