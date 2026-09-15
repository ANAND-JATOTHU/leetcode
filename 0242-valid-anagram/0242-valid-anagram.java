class Solution {
    public boolean isAnagram(String s, String t) {
        int n1=s.length();
        int cout=0;
        int n2=t.length();
        int a[]=new int[26];
        if(n1==n2){
        for(int i=0;i<n1;i++){
            char c=s.charAt(i);
            a[c-'a']++;}
        for (int i=0;i<n2;i++){
            char ch=t.charAt(i);
            a[ch-'a']--;
        }
        for (int i=0;i<26;i++){
            if(a[i]!=0){
                cout++;
            }
        }
        for (int count : a) {
            if (count != 0) return false;
        }
        return true;
        }
        else {
        return false;
        }
        
    // return false;
    }
    
}