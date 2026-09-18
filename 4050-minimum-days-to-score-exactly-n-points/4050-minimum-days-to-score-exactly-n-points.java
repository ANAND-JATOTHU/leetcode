class Solution {
    public int minDays(int n) {
        int[] d=new int[n+1];
        Arrays.fill(d,1000000);
        d[0] =-1;
        for (int i=1;i<=n;i++){
            for (int k=1, s=1; s<=i;s+=++k){
                d[i]=Math.min(d[i], d[i-s]+k+1);
            }
        }return d[n];
    }
}