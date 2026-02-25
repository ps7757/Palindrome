public class PalindromeCheckerApp {
    public static void main(String[] args) {
        System.out.println("--- Welcome to the Palindrome Checker App ---");

        // UC10: Case-Insensitive & Space-Ignored Logic
        String input = "A man a plan a canal Panama";

        // 1. NORMALIZE: Remove all non-alphanumeric characters and convert to lowercase
        // [^a-zA-Z0-9] means "anything that is NOT a letter or a number"
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        System.out.println("Original: " + input);
        System.out.println("Cleaned:  " + cleanedInput);

        // 2. APPLY LOGIC (Using Two-Pointer for efficiency)
        boolean isPal = true;
        int left = 0, right = cleanedInput.length() - 1;

        while (left < right) {
            if (cleanedInput.charAt(left) != cleanedInput.charAt(right)) {
                isPal = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println("UC10 Result: Is it a palindrome? " + isPal);
    }
}