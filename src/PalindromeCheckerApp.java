public class PalindromeCheckerApp {
    public static void main(String[] args) {
        System.out.println("--- Welcome to the Palindrome Checker App ---");

        // UC9: Recursive Palindrome Logic
        String input = "deified";
        boolean result = isPalindromeRecursive(input, 0, input.length() - 1);

        System.out.println("UC9 (Recursion) Result: '" + input + "' is a palindrome? " + result);
    }

    /**
     * Helper method for recursion
     */
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        // 1. BASE CONDITION: If the pointers cross, we've checked everything
        if (start >= end) {
            return true;
        }

        // 2. RECURSIVE STEP: Check the current outer characters
        if (str.charAt(start) != str.charAt(end)) {
            return false; // Mismatch found
        }

        // 3. CALL ITSELF: Move inward by 1 character
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}