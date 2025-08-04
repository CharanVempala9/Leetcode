class Solution {
    public int totalFruit(int[] fruits) {
        int l=0;
        int n=fruits.length;
        int max=Integer.MIN_VALUE;
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int r=0; r<n; r++){
            hm.put(fruits[r],hm.getOrDefault(fruits[r],0) +1);
            if(hm.size()<=2){
                max=Math.max(max,r-l+1);
            }
            while(hm.size()>2){
                hm.put(fruits[l], hm.get(fruits[l])-1);
                if(hm.get(fruits[l]) == 0) {
                    hm.remove(fruits[l]);
                }
                l++;
            }
        }
        return max;
    }
}