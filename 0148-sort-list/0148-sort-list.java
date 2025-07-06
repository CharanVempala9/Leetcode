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
    public ListNode sort(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid=get(head);
        ListNode left=sort(head);
        ListNode right=sort(mid);
        return merge(left,right);
    }
    public ListNode merge(ListNode list1, ListNode list2){
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                temp.next=list1;
                list1=list1.next;
            }
            else{
                temp.next=list2;
                list2=list2.next;
            }
            temp=temp.next;
        }
        while(list1!=null){
            temp.next=list1;
            list1=list1.next;
            temp=temp.next;
        }
        while(list2!=null){
            temp.next=list2;
            list2=list2.next;
            temp=temp.next;
        }
        return dummy.next;
    }
    public ListNode get(ListNode head) {
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) prev.next = null; 
        return slow;
    }
    public ListNode sortList(ListNode head) {
        ListNode ans=sort(head);
        return ans;
    }
}