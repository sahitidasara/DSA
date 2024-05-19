/*
# find the length of the cycle
# Initialise 's' and 'f' to head;
# Move 's' pointer till length of the cycle from head
# The distance from 's' to the start node of the cycle is same as that of the distance from 'f'(head) to the start node of the cycle
# Move 's' and 'f' one step by step and the node at which both pointers meet is the start node
*/


/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        // find length of cycle
        int count = 0;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                s = s.next;
                count++;
                while (s != f) {
                    s = s.next;
                    count++;
                }
                break;
            }
        }
        System.out.println(count);
        if (count == 0)
            {return null;}
        int length = count;
        //find the start node of the cycle
  s = head;
         f = head;
         while(length>0){
            s = s.next;
            length--;
         }
         while(s!=f){
            f = f.next;
            s = s.next;
         }
         return s;
    }

}
