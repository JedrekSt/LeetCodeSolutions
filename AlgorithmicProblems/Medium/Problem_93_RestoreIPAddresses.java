class Solution {
    public List<String> restoreIpAddresses(String s) {
       if(s.length() > 12){
            return new ArrayList<String>();
       }else{
            List <String> ans = new ArrayList<>();
            recurse(ans,s,s,0,0);
            return ans;
       }
    }

    public void recurse(List<String> ans,String s,String cand, int i, int num){
        if(num == 3 && checkNum(s.substring(i))){
            ans.add(cand);
        }
        else if(i < s.length() && num < 3){
            for(int j = 1; j <= 3; j++){
                if(i + j < s.length()){
                    if(checkNum(s.substring(i,i + j))){
                        String new_cand = cand.substring(0,i + num + j) + "." + cand.substring(i + num + j);
                        recurse(ans,s,new_cand , i + j, num+1);
                    }
                }
            }
        }
    }

    public boolean checkNum(String s){
        if(s.length() > 1){
            if(s.charAt(0) == '0'){
                return false;
            }
        }
        int val = Integer.parseInt(s);
        if(val <= 255){
            return true;
        }
        return false;
    }
}
