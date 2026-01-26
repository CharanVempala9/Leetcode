class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>>ls=new ArrayList<>();
        int n=arr.length;
        Arrays.sort(arr);
        int min=Integer.MAX_VALUE;
        for(int i=1; i<n; i++){
            min=Math.min(arr[i]-arr[i-1],min);
        }
        System.out.println(min);
        for(int i=1; i<n; i++){
            if(min==(arr[i]-arr[i-1])){
                ls.add(new ArrayList<>());
                ls.get(ls.size()-1).add(arr[i-1]);
                ls.get(ls.size()-1).add(arr[i]);
            }
        }
        return ls;
    }
}