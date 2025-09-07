class Solution {
    public long bowlSubarrays(int[] nums) {
        long ans=0;
        int n=nums.length;
        Stack<Integer>st=new Stack<>();
        int[] left=new int[n];
        int[] right=new int[n];
        Arrays.fill(left,-1);
        Arrays.fill(right,-1);
        st.push(0);
        for(int i=1; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                left[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        st.push(n-1);
        for(int i=n-2; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                right[i]=st.peek();
            }
            st.push(i);
        }
        for(int i=0; i<n; i++){
            if(left[i]!=-1 && right[i]!=-1){
                ans++;
            }
        }
        return ans;
    }
}