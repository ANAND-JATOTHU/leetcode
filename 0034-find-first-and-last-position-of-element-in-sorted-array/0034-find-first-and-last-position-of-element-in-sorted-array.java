class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int fstoc=-1;
        int l=0;
        int h=n-1;
        while(l<=h)
        {
            int m=l+(h-l)/2;
            if(nums[m]==target)
            {
              fstoc=m;
              h=m-1;  
            }
            else if(target<nums[m])
            h=m-1; 
            else
            l=m+1;

        }

        int lstoc=-1;
         l=0;
         h=n-1;
        while(l<=h)
        {
            int m=l+(h-l)/2;
            if(nums[m]==target)
            {
              lstoc=m;
              l=m+1;  
            }
            else if(target>nums[m])
            l=m+1;
            else
            h=m-1;
        }

    return new int[]{fstoc,lstoc};

    }
}