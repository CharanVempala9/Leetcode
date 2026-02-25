class Solution {
    public int setBits(int n){
        int tot=0;
        while(n>0){
            int temp=n&1;
            tot+=temp;
            n=n>>1;
        }
        return tot;
    }
    public int[] sortByBits(int[] arr) {
        int n=arr.length;
        int[] res=new int[n];
        TreeMap<Integer,List<Integer>>hm=new TreeMap<>();
        for(int i=0; i<n; i++){
            int val=setBits(arr[i]);
            if(!hm.containsKey(val)) hm.put(val,new ArrayList<>());
            hm.get(val).add(arr[i]);
        }
        int idx=0;
        for(int val:hm.keySet()){
            int size=hm.get(val).size();
            Collections.sort(hm.get(val));
            int tmp=0;
            while(tmp<size){
                res[idx]=hm.get(val).get(tmp);
                tmp++;
                idx++;
            }
        }
        return res;
    }
}