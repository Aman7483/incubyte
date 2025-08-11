public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        if (!numbers.contains(",")) {
            return Integer.parseInt(numbers);
        }
        String[] parts = numbers.split(",");
        int sum = 0;
        for (String part : parts) {
            sum += Integer.parseInt(part);
        }
        return sum;
    }
}
