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
    public ListNode middleNode(ListNode head) {
      //Finding length and then mid index
//         ListNode temp = head;
//         int length =0;
//         while(temp!=null){
//             length++;
// temp = temp.next;
//         }
//         ListNode start = head;
//       int middleNodeIndex=  middle(length);
//       while(middleNodeIndex>1){
//         start = start.next;
//         middleNodeIndex--;
//       }
//       ListNode res = start;
//       return res;

//Using s,f
ListNode s= head;
ListNode f = head;
while(f!=null && f.next!=null){
s = s.next;
f = f.next.next;
}
return s;
    }

    public int middle(int n){
        return (n/2)+1;
    }
}
