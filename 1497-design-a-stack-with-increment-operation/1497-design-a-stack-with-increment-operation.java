class CustomStack {
    Stack<Integer>st;
    int size;
    int cnt=0;
    public CustomStack(int maxSize) {
        st=new Stack<>();
        size=maxSize;
    }

    public void push(int x) {
        if(cnt<size){
            st.push(x);
            cnt++;
        }
    }
    
    public int pop() {
        if(!st.isEmpty()){
            cnt--;
            return st.pop();
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        int n=st.size();
        int[] arr=new int[n];
        for(int i=n-1; i>=0; i--){
            if(i<k)
            arr[i]=val+st.pop();
            else
            arr[i]=st.pop();
        }
        for(int i=0; i<n; i++){
            st.push(arr[i]);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */