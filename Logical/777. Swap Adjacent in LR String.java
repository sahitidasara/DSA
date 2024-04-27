/*
# Check if both Strings are same without X
# Count no. of 'L', 'R' & check if the count is same for both strings
# XL can be replaced by LX which means in start string, 'L' should be lie at the index that is greater than or equal to 'L' in end string
# RX can be replaced by XR which means in start string, 'R' should be lie at the index that is less than or equal to 'R' in end string
*/

class Solution {
    public boolean canTransform(String start, String end) {
        //check if count of L, R, X are same in both strings
        int lCount1=0, lCount2=0;
        int rCount1=0, rCount2=0;
        int xCount1=0, xCount2=0;

        ArrayList<Integer> lStart = new ArrayList<>();
        ArrayList<Integer> rStart = new ArrayList<>();
        ArrayList<Integer> lEnd = new ArrayList<>();
        ArrayList<Integer> rEnd = new ArrayList<>();

        //check if both strings are equal without 'X'
        if(!start.replace("X","").equals(end.replace("X",""))){return false;}

        for(int i=0;i<start.length();i++){
            if(start.charAt(i)=='L') {lCount1++; lStart.add(i);}
            else if(start.charAt(i)=='R'){rCount1++; rStart.add(i);}
            else xCount1++;
        }
        for(int i=0;i<end.length();i++){
            if(end.charAt(i)=='L') {lCount2++; lEnd.add(i);}
            else if(end.charAt(i)=='R') {rCount2++; rEnd.add(i);}
            else xCount2++;
        }
        
        if((lCount1!=lCount2) || (rCount1!=rCount2) || (xCount1!=xCount2)){return false;}

        //'L' in start should be present at the index >= index in end
        int i=0, j=0;
        while(i<lStart.size() && j<lEnd.size()){
            if(lStart.get(i)>=lEnd.get(j)){i++;j++;}
            else{return false;}
        }
         //'R' in start should be present at the index <= index in end
        i=0;
        j=0;
        while(i<rStart.size() && j<rEnd.size()){
            if(rStart.get(i)<=rEnd.get(j)){i++;j++;}
            else{return false;}
        }
        return true;
    }
}
