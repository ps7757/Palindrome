import java.util.*;

// 1. THE INTERFACE (The Contract)
interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

// 2. CONCRETE STRATEGY A: Using Stack (LIFO)
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) stack.push(c);

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) reversed.append(stack.pop());

        return clean.equals(reversed.toString());
    }
}

// 3. CONCRETE STRATEGY B: Using Deque (Optimized)
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : clean.toCharArray()) deque.addLast(c);

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}

// 4. THE CONTEXT (The Runner)
class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String text) {
        return strategy.isPalindrome(text);
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        System.out.println("--- UC12: Strategy Pattern Palindrome Checker ---");

        PalindromeContext context = new PalindromeContext();
        String testString = "Race Car";

        // Use Stack Strategy at runtime
        context.setStrategy(new StackStrategy());
        System.out.println("Using Stack: " + context.executeStrategy(testString));

        // Switch to Deque Strategy at runtime
        context.setStrategy(new DequeStrategy());
        System.out.println("Using Deque: " + context.executeStrategy(testString));
    }
}