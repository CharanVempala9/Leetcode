class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> row=new ArrayList<>();
        List<List<Integer>> ls= new ArrayList<>();
        row.add(1);
        ls.add(row);
        for(int i=1; i<numRows;  i++){
            List<Integer>temp=new ArrayList<>();
            temp.add(1);
            for(int j=1; j<i; j++){
                temp.add(ls.get(i-1).get(j-1) + ls.get(i-1).get(j));
            }
            temp.add(1);
            ls.add(temp);
        }
        return ls;
    }
}