public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        // Handle single number
        return Integer.parseInt(numbers);
    }
}
