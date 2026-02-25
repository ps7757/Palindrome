import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // UC1: Welcome Message
        System.out.println("--- Welcome to the Palindrome Checker App ---");

        // UC7: Deque-Based Optimized Logic
        String input = "rotator";
        Deque<Character> deque = new ArrayDeque<>();

        // 1. Add all characters to the Deque
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindrome = true;

        // 2. Compare Front and Rear simultaneously
        // A palindrome must match from both ends until 0 or 1 character remains
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }

        // 3. Output Result
        if (isPalindrome) {
            System.out.println("UC7 (Deque) Result: '" + input + "' is a palindrome.");
        } else {
            System.out.println("UC7 (Deque) Result: '" + input + "' is NOT a palindrome.");
        }
    }
}