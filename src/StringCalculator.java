public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        String delimiter = ",";
        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf('\n');
            delimiter = numbers.substring(2, delimiterEnd);
            numbers = numbers.substring(delimiterEnd + 1);
        }
        numbers = numbers.replace("\n", delimiter);
        String[] parts = numbers.split(delimiter);
        int sum = 0;
        StringBuilder negatives = new StringBuilder();
        for (String part : parts) {
            int num = Integer.parseInt(part);
            if (num < 0) {
                if (negatives.length() > 0) negatives.append(",");
                negatives.append(num);
            }
            sum += num;
        }
        if (negatives.length() > 0) {
            throw new IllegalArgumentException("negative numbers not allowed " + negatives);
        }
        return sum;
    }
}
