class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] prefOpen = new int[n];
        int[] sufClosed = new int[n];

        if(customers.charAt(0) == 'N')
            prefOpen[0] = 1;
        for(int i=1;i<n;i++) {
            prefOpen[i] = prefOpen[i-1];
            if(customers.charAt(i) == 'N')
                prefOpen[i] += 1;
        }

        if(customers.charAt(n-1) == 'Y')
            sufClosed[n-1] = 1;
        for(int i=n-2;i>=0;i--) {
            sufClosed[i] = sufClosed[i+1];
            if(customers.charAt(i) == 'Y')
                sufClosed[i] += 1;
        }
        int ans = 0;
        int penality = sufClosed[0];

        for(int i=1;i<n;i++) {
            if(prefOpen[i-1] + sufClosed[i] < penality) {
                penality = prefOpen[i-1] + sufClosed[i];
                ans = i;
            }
        }
        if(prefOpen[n-1] < penality) {
            penality = prefOpen[n-1];
            ans = n;
        }
        return ans;

    }
}