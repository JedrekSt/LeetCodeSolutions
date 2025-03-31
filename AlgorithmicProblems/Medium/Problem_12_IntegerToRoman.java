class Solution {
    public String intToRoman(int num) {
        int num2 = num;
        int digit;
        String output = "";
        String [][] symbols = {
            {"I","V"},
            {"X","L"},
            {"C","D"},
            {"M"}
        };
        String [] nexts = {"X","C","M",""};
        int i = 0;
        while (num2 != 0){
            digit = num2 % 10;
            output = DigitToRoman(digit,symbols[i],nexts[i]).concat(output);
            num2 /= 10;
            i += 1;
        }
        return output;

    }

    public String DigitToRoman(int digit, String [] symbols, String Next ){
        if(digit == 0){
            return "";
        }else if(digit <=3 && digit > 0){
            return symbols[0].repeat(digit);
        }else if(digit == 4){
            return symbols[0].concat(symbols[1]);
        }else if(digit == 5){
            return symbols[1];
        }else if(digit > 5 && digit < 9){
            return symbols[1].concat(symbols[0].repeat(digit - 5));
        }else{
            return symbols[0].concat(Next);
        }
    }
}
