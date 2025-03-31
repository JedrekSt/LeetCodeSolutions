class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int i0max = 0;
        int j0max = 0;
        boolean check;
        for(int i = 1; i <= s.length(); i++){
            // i is the length of the window
            int j = 0;
            // j is the starting position of the string 
            while(j + i <= s.length()){
                check = checkPal(s,j,i);
                if(check && i > max){
                    max = i;
                    i0max = j;
                    j0max = j + i;
                }
                j += 1;
            }
        }
        return s.substring(i0max,j0max);
    }

    public boolean checkPal(String s, int j, int i){
        int k0,km;
        k0 = j;
        km = j+i-1;
        while(k0 <= km){
            if(s.charAt(k0) != s.charAt(km)){
                return false;
            }
            k0 += 1;
            km -= 1;
        }
        return true;
    }
}
