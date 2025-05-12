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
            int a=i%10;
            if(hm1.containsKey(a)){
                hm1.put(a,hm1.get(a)-1);
                if(hm1.get(a)==0)
                hm1.remove(a);
                int b=(i/10)%10;
                if(hm1.containsKey(b)){
                    hm1.put(b,hm1.get(b)-1);
                    if(hm1.get(b)==0)
                    hm1.remove(b);
                    int c=(i/100)%10;
                    if(hm1.containsKey(c)){
                        hm1.put(c,hm1.get(c)-1);
                        if(hm1.get(c)==0)
                        hm1.remove(c);
                    }
                    else{
                        continue;
                    }
                }
                else{
                    continue;
                }
            }
            else{
                continue;
            }
            if(i%2==0)
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