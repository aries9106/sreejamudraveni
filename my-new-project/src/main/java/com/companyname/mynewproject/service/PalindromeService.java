package com.companyname.mynewproject.service;

import com.companyname.mynewproject.domain.Palindrome;
import com.companyname.mynewproject.persistence.PalindromeDao;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class PalindromeService {
    static int EVEN = 1;
    static int ODD = 2;
    private final PalindromeDao palindromeDao;

    @Inject
    public PalindromeService(PalindromeDao palindromeDao) {
        this.palindromeDao = palindromeDao;
    }

    public  String getLongestPalindrome(String _s_) {
        int stringSize = _s_.length();
        int max = stringSize - 2;
        String longestPalindrome = "";

        if(stringSize == 1) {
            return _s_ ;
        } else if(stringSize == 2) {
            if(_s_.charAt(0) == _s_.charAt(1)){
                Palindrome p = new Palindrome();
                p.setName(longestPalindrome);
                palindromeDao.save(p);
                return "Longest Palindrome : " +_s_;
            } else {
                return "Palindrome doesn't exist for the string!";
            }
        }

        for(int i = 0; i < max; i++){
            String temp = new String();
            if(_s_.charAt(i) == _s_.charAt(i+1)){
                temp = getPalindrome(_s_, i, EVEN);
            }

            if (_s_.charAt(i+1) == _s_.charAt(i+2)) {
                String temp1 = getPalindrome(_s_, i+1, EVEN);
                if(temp1.length() > temp.length()) {
                    temp = temp1;
                }
            }

            if (_s_.charAt(i) == _s_.charAt(i+2)) {
                String temp2 = getPalindrome(_s_, i+1, ODD);
                if(temp2.length() > temp.length()) {
                    temp = temp2;
                }
            }

            if (temp.length() > longestPalindrome.length()){
                longestPalindrome = new String(temp);
            }
        }

        if (longestPalindrome.isEmpty()) {
            return "Palindrome doesn't exist for the string!";
        } else {
            Palindrome p = new Palindrome();
            p.setName(longestPalindrome);
            palindromeDao.save(p);
            return "Longest Palindrome : " +longestPalindrome;
        }
    }

    public  String getPalindrome(String s, int center, int type) {
        int a1, a2;
        int size = s.length();

        if(type == EVEN) {
            a1 = center;
            a2 = center + 1;
        } else {
            a1 = center - 1;
            a2 = center + 1;
        }

        while(a1 >= 0 && a2 < size && s.charAt(a1) == s.charAt(a2)) {
            a1--;
            a2++;
        }

        String sub = new String(s.substring(++a1, a2));

        return sub;
    }

}
