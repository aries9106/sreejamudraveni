package com.companyname.mynewproject.controller;

import com.companyname.mynewproject.service.BinaryReversalService;
import com.companyname.mynewproject.service.PalindromeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class PalindromeController {
    private final PalindromeService palindromeService;
    private final BinaryReversalService binaryReversalService;

    @Inject
    public PalindromeController(PalindromeService palindromeService,
                                BinaryReversalService binaryReversalService) {
        this.palindromeService = palindromeService;
        this.binaryReversalService = binaryReversalService;
    }

    @GetMapping("/palindrome")
    public String getPalindrome(@RequestParam(value = "name") String name) {
        return palindromeService.getLongestPalindrome(name);
    }
}
