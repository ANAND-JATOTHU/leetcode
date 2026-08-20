class Solution {
    public int findKthPositive(int[] arr, int k) {
        int j=1;
        int n=arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }
}