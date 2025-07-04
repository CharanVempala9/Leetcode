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
    public int getDecimalValue(ListNode head) {
        StringBuilder res=new StringBuilder();
        ListNode temp=head;
        while(temp!=null){
            res.append((char)(temp.val+'0'));
            temp=temp.next;
        }
        int idx=0;
        int ans=0;
        for(int i=res.length()-1; i>=0; i--){
            ans+=(int)(res.charAt(i)-'0')*(int)(Math.pow(2,idx));
            idx++;
        }
        return ans;
    }
}