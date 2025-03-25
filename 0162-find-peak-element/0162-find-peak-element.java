class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0; 
        Stack<Integer> st = new Stack<>();
        st.push(nums[0]);
        for (int i = 1; i < nums.length - 1; i++) {
            int val = nums[i];
            if (st.peek() < val && val > nums[i + 1]) {
                return i;
            }
            st.push(val);
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        return 0;
    }
}
