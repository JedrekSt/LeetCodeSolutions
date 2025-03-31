import java.util.ArrayList;

class Solution {
    public List<String> generateParenthesis(int n) {
        List <String> output = new ArrayList<> ();
        generate("",n,0,0,output);
        return output;
    }

    public void generate(String actual, int n, int left_num, int right_num, List <String> output){
        if (actual.length() == 2 * n){
            output.add(actual);
        }
        else{
            if(left_num < n){
                generate(actual + "(",n,left_num + 1,right_num,output);
            }
            if(right_num < left_num){
                generate(actual + ")",n,left_num,right_num + 1, output);
            }
        }
    }
}
