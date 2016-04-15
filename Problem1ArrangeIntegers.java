import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Problem1ArrangeIntegers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String userInput = console.nextLine();
        String[] inputNumbers = userInput.trim().split("\\D+");
        String[] digitToEnglish = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        TreeMap<String, ArrayList<String>> englishWordToNumber = new TreeMap<>();

        for (String inputNumber : inputNumbers) {
            StringBuilder sb = new StringBuilder();
            for (char character : inputNumber.toCharArray()) {
                sb.append(digitToEnglish[Character.getNumericValue(character)]);
            }

            if (!englishWordToNumber.containsKey(sb.toString())) {
                englishWordToNumber.put(sb.toString(), new ArrayList<>());
            }

            englishWordToNumber.get(sb.toString()).add(inputNumber);
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, ArrayList<String>> entry : englishWordToNumber.entrySet()) {
            for (String s : entry.getValue()) {
                sb.append(s + ", ");
            }
        }

        sb.delete(sb.length()-2, sb.length());
        System.out.println(sb.toString());

    }
}
