/*
# Multiply each digit in num1 with each digit in num2 at store at index (i+j+1)
# Subsequently if there is any value at index (i+j+1), add product to the existing value. You will obtained products array
# Carry the extra value of each value in prod array to previous value
*/

class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if(len1<1 || len2<1){return "0";}
        int[] prod = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                prod[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        int carry = 0;
        for (int i = prod.length - 1; i >= 0; i--) {
            int temp = (prod[i] + carry) % 10;
            carry = (prod[i] + carry) / 10;
            prod[i] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : prod) {
            sb.append(num);
        }

        // remove leading zeros
        while (sb.length() != 0 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        return sb.length()>0?sb.toString():"0";
    }
}
