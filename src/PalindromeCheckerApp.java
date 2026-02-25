import java.util.*;

// ============================================================
// STRATEGY PATTERN INTERFACE (UC12)
// ============================================================
interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

// ============================================================
// UC8: MANUAL LINKED LIST IMPLEMENTATION
// ============================================================
class Node {
    char data;
    Node next;
    Node(char data) { this.data = data; }
}

// ============================================================
// CONCRETE STRATEGIES (UC3 - UC8, UC12)
// ============================================================

// UC3: Manual Loop Reversal
class LoopReversalStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = "";
        for (int i = clean.length() - 1; i >= 0; i--) {
            reversed += clean.charAt(i);
        }
        return clean.equals(reversed);
    }
}

// UC4: Two-Pointer Approach (Most Efficient)
class TwoPointerStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}

// UC5: Stack-Based (LIFO)
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) stack.push(c);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return clean.equals(sb.toString());
    }
}

// UC6: Queue + Stack (FIFO vs LIFO)
class QueueStackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }
        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) return false;
        }
        return true;
    }
}

// UC7: Deque-Based (Double-Ended)
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

// UC8: Singly Linked List Strategy
class LinkedListStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (clean.length() <= 1) return true;

        Node head = new Node(clean.charAt(0));
        Node current = head;
        for (int i = 1; i < clean.length(); i++) {
            current.next = new Node(clean.charAt(i));
            current = current.next;
        }

        // Find middle, reverse second half and compare (Simplified for UC8 demonstration)
        Stack<Character> stack = new Stack<>();
        Node temp = head;
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.data != stack.pop()) return false;
            temp = temp.next;
        }
        return true;
    }
}

// ============================================================
// UC11: CONTEXT CLASS (OOPS ENCAPSULATION)
// ============================================================
class PalindromeContext {
    private PalindromeStrategy strategy;
    public void setStrategy(PalindromeStrategy strategy) { this.strategy = strategy; }
    public boolean check(String text) { return strategy.isPalindrome(text); }
}

// ============================================================
// MAIN APPLICATION (UC1, UC2, UC9, UC10, UC13)
// ============================================================
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        // UC1: Welcome Message
        System.out.println("--- Welcome to the Palindrome Checker App (Integrated UC1-UC13) ---");

        // UC2 & UC10: Hardcoded normalized input
        String input = "Was it a car or a cat I saw";
        System.out.println("Original Input: " + input);

        PalindromeContext context = new PalindromeContext();

        // UC13: Performance Benchmarking
        PalindromeStrategy[] algorithms = {
                new LoopReversalStrategy(),
                new TwoPointerStrategy(),
                new StackStrategy(),
                new QueueStackStrategy(),
                new DequeStrategy(),
                new LinkedListStrategy()
        };

        System.out.println("\n" + String.format("%-25s | %-10s | %-15s", "Algorithm", "Result", "Time (ns)"));
        System.out.println("------------------------------------------------------------");

        for (PalindromeStrategy algo : algorithms) {
            context.setStrategy(algo);

            long start = System.nanoTime();
            boolean isPal = context.check(input);
            long end = System.nanoTime();

            System.out.println(String.format("%-25s | %-10s | %-15d",
                    algo.getClass().getSimpleName(), isPal, (end - start)));
        }

        // UC9: Recursive Check
        System.out.println("\n--- UC9: Recursive Execution ---");
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        boolean recResult = isPalindromeRecursive(clean, 0, clean.length() - 1);
        System.out.println("Recursive Check Result: " + recResult);

        System.out.println("\nExecution Complete. Process finished with exit code 0.");
    }

    // UC9: Recursive Method
    public static boolean isPalindromeRecursive(String str, int s, int e) {
        if (s >= e) return true;
        if (str.charAt(s) != str.charAt(e)) return false;
        return isPalindromeRecursive(str, s + 1, e - 1);
    }
}