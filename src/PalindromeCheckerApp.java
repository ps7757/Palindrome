import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // UC1: Welcome Message
        System.out.println("--- Welcome to the Palindrome Checker App ---");

        // UC6: Queue + Stack Logic
        String input = "deified";

        // 1. Initialize Structures
        Queue<Character> queue = new LinkedList<>(); // Queue uses LinkedList in Java
        Stack<Character> stack = new Stack<>();

        // 2. ENQUEUE and PUSH characters
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            queue.add(c);  // Enqueue (FIFO)
            stack.push(c); // Push (LIFO)
        }

        // 3. DEQUEUE and POP to Compare
        boolean isPalindrome = true;
        while (!queue.isEmpty()) {
            // Dequeue gets the 1st char, Pop gets the last char
            if (!queue.remove().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }

        // 4. Result
        if (isPalindrome) {
            System.out.println("UC6 Result: '" + input + "' is a palindrome.");
        } else {
            System.out.println("UC6 Result: '" + input + "' is NOT a palindrome.");
        }
    }
}