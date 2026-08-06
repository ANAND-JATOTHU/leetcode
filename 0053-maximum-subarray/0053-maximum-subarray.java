class Solution {
    public int maxSubArray(int[] nums) {
	int n=nums.length;
	int cumsum=0;
	int maxsum=Integer.MIN_VALUE;

    for (int i=0; i<n;i++){
        cumsum=cumsum+nums[i];
        if (cumsum>maxsum){
            maxsum=cumsum;
        }
        if (cumsum<0)
        cumsum=0;

    }
	
   
return maxsum;    
	}
}
    
