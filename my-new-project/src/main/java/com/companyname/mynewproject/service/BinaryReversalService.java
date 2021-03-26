package com.companyname.mynewproject.service;

import org.springframework.stereotype.Component;

@Component
public class BinaryReversalService {

    public Integer getReversedNumber(int num) {
        String reversedBinaryNumber = "";

        char[] convertedNum = String.format("%8s", Integer.toBinaryString(num)).replace(' ', '0').toCharArray();
        for (int i = convertedNum.length - 1; i >= 0; i--) {
            reversedBinaryNumber += convertedNum[i];
        }
        return Integer.parseInt(reversedBinaryNumber,2);
    }
}
