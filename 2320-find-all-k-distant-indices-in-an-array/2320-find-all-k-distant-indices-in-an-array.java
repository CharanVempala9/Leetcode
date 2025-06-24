class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer>keyIndex=new ArrayList<>();
        int n=nums.length;
        for(int i=0; i<n; i++){
            if(nums[i]==key)
            keyIndex.add(i);
        }
        List<Integer>result=new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<keyIndex.size(); j++){
                if(Math.abs(i-keyIndex.get(j))<=k){
                    result.add(i);
                    break;
                }
            }
        }
        return result;
    }
}