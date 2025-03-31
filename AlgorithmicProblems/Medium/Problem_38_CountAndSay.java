class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        else{
            String cas = countAndSay(n - 1);
            return encode(cas);
        }
    }

    public String encode(String cas){
        String ans = "";
        int n = cas.length();
        int i = 0;
        int count;
        char val;
        while( i < n ){
            val = cas.charAt(i);
            count = i;
            while(i < n && cas.charAt(i) == val){
                i += 1;
            }
            ans += Integer.toString(i - count) + Character.toString(val);
        }
        return ans;
    }
}
