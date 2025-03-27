class Solution {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int max=0;
        int f=-1;
        for(int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
            max=Math.max(max,hm.get(num));
        }
        for(int key:hm.keySet()){
            if(hm.get(key)==max){
            f=key;
            break;
            }
        }
        System.out.println(f+" "+max);
        int cnt=0;
        int n=nums.size();
        for(int i=0; i<n; i++){
            if(f==nums.get(i)){
                cnt++;
            }
            if(cnt*2>i+1 && (max-cnt)*2>n-1-i){
                return i;
            }
        }
        return -1;
    }
}