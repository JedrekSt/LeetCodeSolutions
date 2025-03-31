class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        int i = 0;
        Stack_ st = new Stack_();
        st.push(Integer.valueOf(tokens[i]));
        if(n == 1){
            return st.pop();
        }
        int n1,n2;
        i++;
        while(! st.Empty()){
            switch (tokens[i]){
                case "+":
                    st.push(st.pop() + st.pop());
                    break;
                case "-":
                    n1 = st.pop();
                    n2 = st.pop();
                    st.push(n2 - n1);
                    break;
                case "*":
                    st.push(st.pop() * st.pop());
                    break;
                case "/":
                    n1 = st.pop();
                    n2 = st.pop();
                    st.push(n2 / n1);
                    break;
                default:
                    st.push(Integer.valueOf(tokens[i]));
                    break;
            }
            i++;
            if(i == n){
                return st.pop();
            }
        }
        return 0;
    }
}

class Stack_{
    List <Integer> stack;
    Stack_(){
        stack = new ArrayList<>();
    }

    public void push(int num){
        stack.add(num);
    }

    public Integer pop(){
        if(stack.isEmpty()){
            return null;
        }
        Integer out = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return out;
    }

    public boolean Empty(){
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
