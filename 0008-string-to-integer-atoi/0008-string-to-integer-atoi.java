class Solution {
    // Method to convert string to integer
    public int myAtoi(String input) {
        int i = 0, n = input.length();
        
        // Step 1: Skip leading spaces
        while (i < n && input.charAt(i) == ' ') {
            i++;
        }
        
        // Step 2: Handle the sign
        int sign = 1;
        if (i < n && input.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < n && input.charAt(i) == '+') {
            i++;
        }
        
        // Step 3: Parse digits and build the number
        long result = 0;
        while (i < n && Character.isDigit(input.charAt(i))) {
            result = result * 10 + (input.charAt(i) - '0');
            i++;
            
            // Step 4: Handle overflow and underflow
            if (result * sign >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result * sign <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        
        // Step 5: Return the final result with the sign
        return (int)(result * sign);
    }
}
