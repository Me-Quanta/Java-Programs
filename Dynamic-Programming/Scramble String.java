/*
Given a string A, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of A = “great”:


    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
 

To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node “gr” and swap its two children, it produces a scrambled string “rgeat”.

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t

We say that “rgeat” is a scrambled string of “great”.

Similarly, if we continue to swap the children of nodes “eat” and “at”, it produces a scrambled string “rgtae”.

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a

We say that “rgtae” is a scrambled string of “great”.


Given two strings A and B of the same length, determine if B is a scrambled string of S.

*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isScramble(final String s1, final String s2) {
          if(s1.length()!= s2.length())
            return 0;
        if(s1 == s2)
            return 1;
        int n = s1.length();
        if(n == 1)
        {
            return s1.charAt(0) == s2.charAt(0)?1:0;
        }
        // check char distribution
        int dist1[]=new int[256];
        for(int i = 0; i<n; ++i)
        {
            dist1[s1.charAt(i)]++;
            dist1[s2.charAt(i)]--;
        }
        for(int i = 0; i<256; ++i)
            if(dist1[i]!=0)
                return 0;
        // check every possible division
        for(int i = 1; i <n; ++i)
        {
            String s11 = s1.substring(0,i);
            String s21 = s2.substring(0,i);
            String s22 = s2.substring(i);
            String s12 = s1.substring(i);
            if((isScramble(s11,s21) ==1) && (isScramble(s12, s22)==1))
                return 1;
            
            s22 = s2.substring(0, n-i); // check the swapped order
            s21 = s2.substring(n-i);
            if((isScramble(s11,s21) ==1) && (isScramble(s12, s22) ==1))
                return 1;
        }
        return 0;
    }
}
