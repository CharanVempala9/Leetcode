class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int n=digits.length;
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0; i<n; i++){
            hm.put(digits[i],hm.getOrDefault(digits[i],0)+1);
        }
        ArrayList<Integer>ls=new ArrayList<>();
        for(int i=100; i<=998; i++){
            HashMap<Integer,Integer>hm1=new HashMap<>(hm);
            int temp=i;
            boolean ans=true;
            while(temp>0){
                int rem=temp%10;
                if(!hm1.containsKey(rem)){
                    ans=false;
                    break;
                }
                else{
                    hm1.put(rem,hm1.get(rem)-1);
                    if(hm1.get(rem)==0)
                    hm1.remove(rem);
                }
                temp=temp/10;
            }
            if(ans && i%2==0)
            ls.add(i);
        }
        int size=ls.size();
        int[] res=new int[size];
        for(int i=0; i<size; i++){
            res[i]=ls.get(i);
        }
        return res;
    }
}