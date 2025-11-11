/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int s1=0;
        int s2=0;
        ListNode tmp=headA;
        ListNode tmp2=headB;
        while(tmp!=null){
            s1++;
            tmp=tmp.next;
        }
        while(tmp2!=null){
            s2++;
            tmp2=tmp2.next;
        }
        if(s1>s2){
            int d=s1-s2;
            while(d-->0){
                headA=headA.next;
            }
        }
        else{
            int d=s2-s1;
            while(d-->0){
                headB=headB.next;
            }
        }
        while(headA!=null && headB!=null){
            if(headA==headB) return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}