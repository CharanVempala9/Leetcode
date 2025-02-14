class ProductOfNumbers {
    ArrayList<Integer>ls;
    public ProductOfNumbers() {
        ls=new ArrayList<>();
    }
    
    public void add(int num) {
        ls.add(num);
    }
    
    public int getProduct(int k) {
        int ans=1;
        int temp=ls.size()-1;
        while(k>0){
            ans*=ls.get(temp);
            temp--;
            k--;
        }
        return ans;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */