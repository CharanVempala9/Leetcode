class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer>st=new Stack<>();
        int n=nums.length;
        int ans=0;
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && st.peek()>nums[i]){
                st.pop();
            }
            if(nums[i]==0){
                continue;
            }
            if(st.isEmpty() || st.peek()<nums[i]){
                ans++;
                st.push(nums[i]);
            }
        }
        return ans;
    }
}