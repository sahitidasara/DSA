/*
# When you are summing up the squares of digits in a number, for sure cycle is formed
# The meeting point definitely would be 1 or any
# The idea has come up based on taking a happy no. and a non-happy no.
*/

class Solution {
    public boolean isHappy(int n) {
        int s = n;
        int f = n;
        do{
            s = squaredSum(s);
            f = squaredSum(squaredSum(f));
        }while(s!=f);
        if(s==1) return true;
        return false;
    }

     public int squaredSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}
