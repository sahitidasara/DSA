#completely logical part
#case1: sum%3!=0====>return 0
#case2: sum==0===>(n-1)c2 combinations
#case3: set s1, s3. Now s2 has some zeroes towards left of first occurence of 1 and towards right of last occurence of 1. Generalising it, no. of ways become (leftcountOfZeros+1)*(rightcountOfZeros+1)

class Solution {
    public int numWays(String s) {
        long sum=0;

        for(char ch:s.toCharArray()){
            if(ch=='1'){sum++;}
        }
        long modul=1_000_000_007;
        long len=s.length();
        if(sum==0){return (int)(((len-1)*(len-2)/2)%modul);}
        if(sum%3!=0){return 0;}
        long split = sum/3;
        int i=0;
        long s1Sum=0;
        for(;i<s.length() && s1Sum<split;i++){
            if(s.charAt(i)=='1'){s1Sum++;}
        }
        long s3Sum=0;
        int j=s.length()-1;
        for(;j>i && s3Sum<split;j--){
            if(s.charAt(j)=='1'){s3Sum++;}
        }
        //s2 is a substring with index range[i,j]
        
        long firstOccur = 0;
        long lastOccur=0;
        for(int c=i;c<=j;c++){
            if(s.charAt(c)=='1'){firstOccur = c;break;}}
        for(int c=j;c>=i;c--){
            if(s.charAt(c)=='1'){lastOccur = c;break;}}
        //count no. of zeros in left part of s2 and right part of s2
        long leftCount=0;
        long rightCount=0;
        for(int c=i;c<=firstOccur;c++){
            if(s.charAt(c)=='0'){leftCount++;}}
        
        for(int c=j;c>=lastOccur;c--){
            if(s.charAt(c)=='0'){rightCount++;}}

        return (int)(((leftCount+1)*(rightCount+1))%modul);
    }
}
