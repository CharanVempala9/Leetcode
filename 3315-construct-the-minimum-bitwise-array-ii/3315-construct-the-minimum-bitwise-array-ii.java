class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int result[] = new int[n];
        for(int i = 0; i < n; i++){
            int num = nums.get(i);
            int x = -1;
            int d = 1;
            while((num & d) != 0){
                x = num - d;
                d <<= 1;
            }
            result[i] = x;
        }
        return result;
    }
}