package com.calculator2;

import static com.calculator2.ArabicCalculator.*;


import static com.calculator2.RomanToArabicConverter.*;
import static com.calculator2.ArabicToRomanConverter.*;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    static boolean isArabic(String s) {
        return s.matches("-?[\\d]+");
    }

    public static void main(String[] args) throws NumberFormatException{

        while (true) {
            System.out.println("Введите аргументы и операцию через пробел: ");
            Scanner scanner = new Scanner(System.in);
            expression = scanner.nextLine();
            Pattern pattern = Pattern.compile(" ");
            String[] operands = pattern.split(expression);
            if (isArabic(operands[0]) == true && isArabic(operands[2]) == true) {
                firstNum = Integer.parseInt(operands[0]);
                secondNum = Integer.parseInt(operands[2]);
                operation = operands[1];
                switch (operation) {
                    case "+":
                        System.out.println(firstNum + " " + operation + " " + secondNum + " = " + sum(firstNum, secondNum));
                        break;
                    case "-":
                        System.out.println(firstNum + " " + operation + " " + secondNum + " = " + subtraction(firstNum, secondNum));
                        break;
                    case "*":
                        System.out.println(firstNum + " " + operation + " " + secondNum + " = " + multiplication(firstNum, secondNum));
                        break;
                    case "/":
                        if (secondNum == 0) {
                            System.out.println("На ноль делить нельзя!!!");
                        } else {
                            System.out.println(firstNum + " " + operation + " " + secondNum + " = " + division(firstNum, secondNum));
                        }

                }
            } else {
                firstNum = convertRomanToArabic(operands[0]);
                secondNum = convertRomanToArabic(operands[2]);
                operation = operands[1];
                if (isArabic(operands[0]) != true && isArabic(operands[2]) != true) {
                    switch (operation) {
                        case "+":
                            System.out.println(operands[0] + " " + operation + " " + operands[2] + " = " + convertArabicToRoman(sum(firstNum, secondNum)));
                            break;
                        case "-":
                            System.out.println(operands[0] + " " + operation + " " + operands[2] + " = " + convertArabicToRoman(subtraction(firstNum, secondNum)));
                            break;
                        case "*":
                            System.out.println(operands[0] + " " + operation + " " + operands[2] + " = " + convertArabicToRoman(multiplication(firstNum, secondNum)));
                            break;
                        case "/":
                            System.out.println(operands[0] + " " + operation + " " + operands[2] + " = " + convertArabicToRoman(division(firstNum, secondNum)));
                            break;
                        default:
                            System.out.println("Что-то пошло не так. Попробуйте еще раз.");

                    }
                } else {
                    throw new NumberFormatException();
                }
            }

        }

    }

}



