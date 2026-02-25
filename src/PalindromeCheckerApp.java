public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // UC1: Welcome Message
        System.out.println("--- Welcome to the Palindrome Checker App ---");

        // UC3: Manual Reverse Using Loop
        String original = "madam";
        String reversed = ""; // Starts empty

        // Loop backward from the last character to the first
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed += original.charAt(i); // String Concatenation (+)
        }

        // UC3: Comparison using .equals()
        if (original.equalsIgnoreCase(reversed)) {
            System.out.println("UC3 Result: '" + original + "' is a palindrome.");
        } else {
            System.out.println("UC3 Result: '" + original + "' is NOT a palindrome.");
        }
    }
}