package com.calculator2;


import java.util.List;

public class ArabicToRomanConverter {

    static String convertArabicToRoman(int input){

        if(input < 0 && input > 4000){
            throw new IllegalArgumentException(input + " Введенное число выходит и диапазона[0, 4000]");
        }

        List<com.calculator2.RomanNumbers> romanNumbers = com.calculator2.RomanNumbers.getReverseNums();
        int index = 0;

        StringBuilder stringBuilder = new StringBuilder();
        while(input > 0){
            com.calculator2.RomanNumbers currentNumber = romanNumbers.get(index);
            if (currentNumber.getNumber() <= input) {
                stringBuilder.append(currentNumber.name());
                input -= currentNumber.getNumber();
            } else {
                index++;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String result = convertArabicToRoman(234);
        System.out.println(result);
        System.out.println(result);
    }

}
