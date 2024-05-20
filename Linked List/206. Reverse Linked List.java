/*
1. Recursion:
  Modifying pointers
2. Iteration:
  Take three pointers prev, pres, pt3 points to null, temp, temp.next respectively. These are maintained in sequence
  Point pres.next to prev, pres to pt3, prev to pres, pt3 to pt3.next
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
      // return recursiveMeth(temp);
      return iterativeMeth(temp);
    }

    public ListNode recursiveMeth(ListNode temp){ 
       
        if(temp==null || temp.next==null) return temp; 
       // rev = new ListNode(temp.val);
       ListNode rev= recursiveMeth(temp.next);
       temp.next.next = temp;
       temp.next=null;
        return rev;
    }

    public ListNode iterativeMeth(ListNode temp){
        if(temp==null || temp.next==null) return temp;
        ListNode prev = null;
        ListNode pres = temp;
        ListNode pt3 = temp.next;
        while(pres!=null){
           pres.next = prev;
           prev= pres;
           pres = pt3;
           if(pt3!=null)pt3 = pt3.next;
        }
        return prev;
    }
}
