public class Solution {

    public static int computation(int mid,int n,int m){
        // if mid = m return 0
        // if mid > m return 1
        // if mid < m return 2
        long ans=1;
        for(int i=1;i<=n;i++){
            ans=ans*mid;
            if(ans>m) return 1;
        }
        if(ans==m) return 0;
        else return 2;
    }
    public static int NthRoot(int n, int m) {
        int low =1 ,high = m;
        while(low <= high){
            int mid = (low + high) / 2;
            int product = computation(mid,n,m);
            if(product==0) return mid;
            else if(product==2) low=mid+1;
            else if(product==1) high=mid-1;
        }
        return -1;
    }
}
// TC: O( n * log(m) )