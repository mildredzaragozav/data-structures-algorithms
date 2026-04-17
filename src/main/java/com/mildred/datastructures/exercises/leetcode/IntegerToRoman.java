package com.mildred.datastructures.exercises.leetcode;

public class IntegerToRoman {

    /**
     * Given an integer, convert it to a Roman numeral.
     * @param num: a decimal number
     * @return the roman numeral
     */
    public static String intToRoman(int num) {
        if(num < 1 || num > 3999) return null;

        StringBuilder romanianString = new StringBuilder();
        int res = num / 1000;

        if(res != 0) {
            num = num % 1000;
            append(romanianString, 'M', res);
        }

        res = num / 100;
        if(res != 0) {
            num = num % 100;
            helper(romanianString, res, "CD", "CM");
        }

        res = num / 10;
        if (res != 0) {
            num = num % 10;
            helper(romanianString, res,"XL", "XC");
        }

        if (num != 0) {
            helper(romanianString, num, "IV", "IX");
        }

        return romanianString.toString();
    }

    private static void helper(StringBuilder sb, int num, String sFor4, String sFor9){
        if(num == 4) {
            sb.append(sFor4);
        } else if(num == 9) {
            sb.append(sFor9);
        } else {
            if(num >= 5) {
                sb.append(sFor4.charAt(1));
                num = num - 5;
            }
            append(sb, sFor4.charAt(0), num);
        }
    }

    private static void append(StringBuilder sb, char toAppend, int times) {
        while(times > 0) {
            sb.append(toAppend);
            times--;
        }
    }

    public static void main(String[] args) {
        int n = 3525;
        System.out.println("Input:    " + n );
        System.out.println("Output:   " + intToRoman(n));
        System.out.println("Expected: MMMDXXV" );

        n = 3749;
        System.out.println("Input:    " + n );
        System.out.println("Output:   " + intToRoman(n));
        System.out.println("Expected: MMMDCCXLIX" );

        n = 58;
        System.out.println("Input:    " + n );
        System.out.println("Output:   " + intToRoman(n));
        System.out.println("Expected: LVIII" );

        n = 7;
        System.out.println("Input:    " + n );
        System.out.println("Output:   " + intToRoman(n));
        System.out.println("Expected: VII" );
    }
}
