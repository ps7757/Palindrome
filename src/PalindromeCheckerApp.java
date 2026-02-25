public class PalindromeCheckerApp {
    public static void main(String[] args) {
        System.out.println("--- Welcome to the Palindrome Checker App ---");
        checkHardcoded();
    }

    public static void checkHardcoded() {
        String word = "radar";
        String reversed = new StringBuilder(word).reverse().toString();

        if (word.equalsIgnoreCase(reversed)) {
            System.out.println("Result: " + word + " is a palindrome.");
        } else {
            System.out.println("Result: " + word + " is NOT a palindrome.");
        }
    }
}