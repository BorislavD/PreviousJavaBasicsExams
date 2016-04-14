import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem3BasicMarkupLanguage {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String userInput = console.nextLine().trim();

        Pattern inverseOrReversePattern = Pattern.compile("\\<\\s*([\\w]+)\\s+content\\s*\\=\\s*\"(.+)\\s*\"\\s*\\/\\>");
        Pattern repeatPattern = Pattern.compile("\\<\\s*([\\w]+)\\s+value\\s*\\=\\s*\"([0-9]+)\"\\s*content\\s*\\=\\s*\"(.+)\\s*\"\\s*\\/\\s*\\>");

        ArrayList<String> output = new ArrayList<>();

        int counter = 1;

        while (!userInput.equals("<stop/>")) {
            Matcher matcherInverseOrReverse = inverseOrReversePattern.matcher(userInput);
            Matcher matcherRepeat = repeatPattern.matcher(userInput);

            if (matcherInverseOrReverse.find()) {
                String command = matcherInverseOrReverse.group(1);
                String toBeInversedOrReversed = matcherInverseOrReverse.group(2);
                String result = "";

                if (command.equals("inverse")) {
                    for (int i = 0; i < toBeInversedOrReversed.length(); i++) {
                        int charValue = (int) toBeInversedOrReversed.charAt(i);
                        if (charValue >= 97 && charValue <= 122) {
                            charValue -= 32;
                        } else if (charValue >= 65 && charValue <= 90) {
                            charValue += 32;
                        }

                        result += (char) charValue;
                    }

                } else if ((command.equals("reverse")))
                    for (int i = toBeInversedOrReversed.length() - 1; i >= 0; i--) {
                        result += toBeInversedOrReversed.charAt(i);
                    }

                output.add(String.format("%d. %s", counter, result));
                counter++;


            } else if (matcherRepeat.find()) {
                String result = "";
                int numberOfRepeating = Integer.parseInt(matcherRepeat.group(2).trim());
                String contentToBeRepeated = matcherRepeat.group(3).trim();
                if (numberOfRepeating != 0) {
                    ArrayList<String> repeatedOutput = new ArrayList<>();
                    for (int i = 0; i < numberOfRepeating; i++) {
                        repeatedOutput.add(String.format("%d. %s", counter, contentToBeRepeated));
                        counter++;
                    }

                    result = String.join("\n", repeatedOutput);
                    output.add(result);
                }
            }

            userInput = console.nextLine().trim();
        }

        System.out.println(String.join("\n", output));
    }
}
