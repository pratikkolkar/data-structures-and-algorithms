package stack;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {

        String str = "3[a2[c]]";
        System.out.println(decodeString(str));
        
    }

    public static String decodeString(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()){
            if(c != ']'){
                stack.push(c);
            }else{
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() != '['){
                    sb.insert(0,stack.pop());
                }
                String str = sb.toString();
                stack.pop();

                sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek()))
                    sb.insert(0, stack.pop());
                int count = Integer.valueOf(sb.toString());
                // int count = Integer.valueOf(String.valueOf(stack.pop()));

                while(count > 0){
                    for(char ch: str.toCharArray()){
                        stack.push(ch);
                    }
                    count--;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.insert(0,stack.pop());
        }
        return ans.toString();
    }
}
