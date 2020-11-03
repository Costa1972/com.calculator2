package com.calculator2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum RomanNumbers {
    I(1), IV(4), V(5),
    IX(9), X(10), XL(40),
    L(50), XC(90), C(100),
    CD(400), D(500), CM(900),
    M(1000), CZ(1900), Z(2000);

    private int number;

    RomanNumbers(int number) {
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

    public static List<RomanNumbers> getReverseNums() {
        return Arrays.stream(values()).
                sorted(Comparator.comparing((RomanNumbers e) -> e.number).reversed()).
                collect(Collectors.toList());
    }
}
