public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // UC1: Welcome Message
        System.out.println("--- Welcome to the Palindrome Checker App ---");

        // UC4: Character Array & Two-Pointer Logic
        String input = "level";

        // 1. Convert string to char array
        char[] charArray = input.toCharArray();

        // 2. Setup Two Pointers
        int start = 0;
        int end = charArray.length - 1;
        boolean isPalindrome = true;

        // 3. Compare start and end characters moving inward
        while (start < end) {
            if (charArray[start] != charArray[end]) {
                isPalindrome = false;
                break; // Exit loop immediately if a mismatch is found
            }
            start++;
            end--;
        }

        // 4. Display result
        if (isPalindrome) {
            System.out.println("UC4 Result: '" + input + "' is a palindrome.");
        } else {
            System.out.println("UC4 Result: '" + input + "' is NOT a palindrome.");
        }
    }
}