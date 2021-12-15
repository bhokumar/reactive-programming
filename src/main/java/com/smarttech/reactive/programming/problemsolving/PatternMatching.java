package com.smarttech.reactive.programming.problemsolving;

import java.util.Stack;

public class PatternMatching {
    public static void main(String[] args) {
        String s = "[()";

        Stack<Character> stack = new Stack<>();

         for (int i = 0 ; i < s.length(); i++) {
             char ch = s.charAt(i);

             if (ch == '[' || ch == '(') {
                 stack.push(ch);
             } else {
                char poppedCharacter = stack.pop();

                if (ch == ')' && poppedCharacter != '(') {
                    System.out.println("Pattern did not match!");
                    break;
                } else if (ch == ']' && poppedCharacter != '[') {
                    System.out.println("Pattern did not match!");
                }
             }
         }

         if (stack.isEmpty()) {
             System.out.println("Pattern matched");
         } else {
             System.out.println("Pattern did not matched !");
         }
    }
}
