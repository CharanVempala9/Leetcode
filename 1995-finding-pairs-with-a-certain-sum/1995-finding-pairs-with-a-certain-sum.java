class FindSumPairs {
    ArrayList<Integer>n1;
    ArrayList<Integer>n2;
    HashMap<Integer,Integer>hm=new HashMap<>();
    public FindSumPairs(int[] nums1, int[] nums2) {
        n1=new ArrayList<>();
        for(int n:nums1){
            n1.add(n);
        }
        n2=new ArrayList<>();
        for(int n:nums2){
            n2.add(n);
        }
        for(int i=0; i<nums2.length; i++){
            hm.put(nums2[i],hm.getOrDefault(nums2[i],0)+1);
        }
    }
    
    public void add(int index, int val) {
        int key=n2.get(index);
        n2.set(index,n2.get(index)+val);
        if(hm.containsKey(key)){
            hm.put(key,hm.get(key)-1);
            if(hm.get(key)==0){
                hm.remove(key);
            }
        }
        hm.put(key+val,hm.getOrDefault(key+val,0)+1);

    }
    
    public int count(int tot) {
        int cnt=0;
        ArrayList<Integer>ls=new ArrayList<>();
        for(int i=0; i<n1.size(); i++){
            ls.add(tot-n1.get(i));
        }
        for(int i=0; i<ls.size(); i++){
            if(hm.containsKey(ls.get(i))){
                cnt+=hm.get(ls.get(i));
            }
        }
        return cnt;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */