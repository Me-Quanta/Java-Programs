/*
Given a string A containing just the characters ’(‘ and ’)’.

Find the length of the longest valid (well-formed) parentheses substring.
*/



     public class Solution {
        public int longestValidParentheses(String s) {
            
            int maxLen = 0;
            int last = -1;
            
            Stack<Integer> left = new Stack<Integer>();
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    left.push(i);
                } else {
                    if (left.isEmpty()) {
                        last = i;
                    } else {
                        left.pop();
                        if (left.isEmpty()) {
                            //all matched by now
                            maxLen = Math.max(maxLen, i - last);
                        } else {
                            maxLen = Math.max(maxLen, i - left.peek());
                        }
                    }
                    
                }
            }
            
            return maxLen;
            
        }
    }
