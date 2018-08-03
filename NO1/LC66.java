//plus One

class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return digits;
        int carry = 0;
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + carry;
            carry = num / 10;
            digits[i] = num % 10;
            if (carry == 0) break;
        }
        if (carry == 0)
            return digits;
        
        int[] arr = new int[digits.length + 1];
        arr[0] = carry;
        System.arraycopy(digits, 0, arr, 1, digits.length);
        return arr;
    }
}
