class Node {
    char data;
    Node next;
    Node(char data) { this.data = data; }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        System.out.println("--- Welcome to the Palindrome Checker App ---");

        // UC8: Singly Linked List Logic
        String input = "noon";
        if (input.length() <= 1) { System.out.println("Palindrome"); return; }

        // 1. Build the Linked List
        Node head = new Node(input.charAt(0));
        Node temp = head;
        for (int i = 1; i < input.length(); i++) {
            temp.next = new Node(input.charAt(i));
            temp = temp.next;
        }

        // 2. Find Middle using Fast & Slow Pointers
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 3. Reverse Second Half In-Place
        Node prev = null, current = slow, nextNode;
        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        // 4. Compare Halves
        Node firstHalf = head, secondHalf = prev;
        boolean isPal = true;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPal = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        System.out.println("UC8 (Linked List) Result: " + isPal);
    }
}