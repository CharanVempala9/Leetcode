class Bank {
    ArrayList<Long>ls;
    public Bank(long[] balance) {
        ls=new ArrayList<>();
        int n=balance.length;
        for(int i=0; i<n; i++){
            ls.add(balance[i]);
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1>ls.size() || account2>ls.size())return false;
        long m1=ls.get(account1-1);
        if(m1<money){
            return false;
        }
        ls.set(account1-1,m1-money);
        ls.set(account2-1,ls.get(account2-1)+money);
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(account>ls.size())return false;
        ls.set(account-1,ls.get(account-1)+money);
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account>ls.size())return false;
        long m=ls.get(account-1);
        if(m<money)return false;
        ls.set(account-1,m-money);
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */