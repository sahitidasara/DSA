/*
The desired value lies in the range of 1 to maximum no. in the piles array. With that Binary Search idea comes up
# Take the mid value with start and end boundaries and see with this mid value, you are able to reach the value of "h". If not update the boundaries
*/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int start = 1;
        int end = piles[piles.length - 1];
        int mid=0;
        int timeToEat=0;
       
        while (start<end) {
              mid = start + (end - start) / 2;
            timeToEat = 0;
            for (int i = 0; i < piles.length; i++) {
                if (piles[i] > mid) {
                    timeToEat+= findTimePerPile(piles[i],mid);
                }
                else{timeToEat++;}
            }
            if(timeToEat > h){
                start = mid +1;
            }
            else if(timeToEat <= h){
                end = mid;
            }
        }
        return start;
    }

    int findTimePerPile(int pileCount, int capacity) {
        double time = (double) pileCount / capacity;
        if (time % 1.0 > 0) {
            time++;
        }
        return (int) time;
    }
}
