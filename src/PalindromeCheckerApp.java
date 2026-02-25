// UC11: The Service Class (Encapsulation)
class PalindromeService {

    // Single Responsibility: This method ONLY cares about the logic
    public boolean check(String input) {
        if (input == null) return false;

        // Normalize (Reusing UC10 logic)
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Logic (Reusing UC4 Two-Pointer logic for best performance)
        int left = 0, right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        System.out.println("--- Welcome to the Palindrome Checker App ---");

        // 1. Instantiate the Service (Object Creation)
        PalindromeService service = new PalindromeService();

        // 2. Use the Service
        String test = "No 'x' in Nixon";
        boolean result = service.check(test);

        // 3. Output result
        System.out.println("Input: " + test);
        System.out.println("Result: " + (result ? "Is a Palindrome" : "Not a Palindrome"));
    }
}