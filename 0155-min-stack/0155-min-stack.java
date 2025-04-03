class MinStack {
    static int min=Integer.MAX_VALUE;
    Stack<Integer>st;
    PriorityQueue<Integer>pq;
    public MinStack() {
        st=new Stack<>();
        pq=new PriorityQueue<>();
    }
    
    public void push(int val) {
        pq.add(val);
        st.push(val);
    }
    
    public void pop() {
        if(!st.isEmpty()){
            int val=st.pop();  
            pq.remove(val); 
        }
    }
    
    public int top() {
        if(!st.isEmpty()){
            return st.peek();   
        }
        return -1;
    }
    
    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */