import java.util.Scanner;
 public class test {
    


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder input = new StringBuilder();
        System.out.println("Enter your sentence (end with a period '.'):");

        while (true) {
            String line = sc.nextLine();
            input.append(line).append(" ");  // allow multiline input

            if (line.contains(".")) {
                break;  // stop when period is found
            }
        }

        // Get full sentence and remove anything after the first '.'
        String sentence = input.toString().trim();
        int periodIndex = sentence.indexOf(".");
        if (periodIndex != -1) {
            sentence = sentence.substring(0, periodIndex + 1);
        }

        // Remove the final period for word processing
        String sentenceWithoutPeriod = sentence.substring(0, sentence.length() - 1).trim();

        String[] words = sentenceWithoutPeriod.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i % 2 == 0) { // 0-based index: 0, 2, 4... are odd-position words (1st, 3rd, etc.)
                result.append("###"); // replace odd-position word
            } else {
                result.append(words[i]);
            }
            result.append(" ");
        }

        // Add the period back
        result.append(".");

        System.out.println("Processed sentence:");
        System.out.println(result.toString().trim());
    }
}


