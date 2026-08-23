class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        // int[] res=new int[n];
        int k=0;
        // int c=0;
        for(int i=0;i<n;i++){
            if (nums[i]!=val){
                nums[k]=nums[i];
                k++;
            }
        }
        //     if(nums[i]!=val){
        //         res[k++]=nums[i];
        //         // c++;
        //     }
        // }
        // for(int i=0;i<n;i++){
        //     nums[i]=res[i];
        // }
    return k;
    }
}