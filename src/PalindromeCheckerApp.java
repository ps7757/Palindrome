import java.util.Stack; // Add this import at the very top

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // UC1: Welcome Message
        System.out.println("--- Welcome to the Palindrome Checker App ---");

        // UC5: Stack-Based Palindrome Logic
        String input = "racecar";
        Stack<Character> stack = new Stack<>();

        // 1. PUSH: Put every character of the string into the stack
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // 2. POP: Take them out. They will come out in REVERSE order.
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        // 3. Compare
        if (input.equalsIgnoreCase(reversed)) {
            System.out.println("UC5 (Stack) Result: '" + input + "' is a palindrome.");
        } else {
            System.out.println("UC5 (Stack) Result: '" + input + "' is NOT a palindrome.");
        }
    }
}