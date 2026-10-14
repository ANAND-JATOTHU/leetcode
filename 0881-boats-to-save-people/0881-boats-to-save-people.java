class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n=people.length;
        int l=0;
        int r=n-1;
        Arrays.sort(people);
        int boats=0;
        while(l<=r)
        {
            if(people[l]+people[r]<=limit)
            {
                boats++;
                l++;
                r--;
            }
            else if(people[r]<=limit)
            {
                boats++;
                r--;
            }
            else
            r--;
        }
        return boats;
    }
}