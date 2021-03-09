package com.zeros.algo.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack = new Stack<>();
        String l1 = "";
        String l2 = "";

        for(char c : S.toCharArray()){
            if(c != '#'){
                stack.push(c);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()){
            l1 = stack.pop() + l1;
        }

        for(char c : T.toCharArray()){
            if(c != '#'){
                stack.push(c);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()){
            l2 = stack.pop() + l2;
        }
        System.out.println(l1);
        System.out.println(l2);
        return l1.equals(l2);
    }





    public void run(){
        String[] words = {"met", "me"};
        System.out.println(backspaceCompare("ac#b","ac#b"));

    }
}
