import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2SoftUniDefenseSystem {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String userInput = console.nextLine();
        Pattern pattern = Pattern.compile("([A-Z][a-z]+).*?([A-Z][a-z]*[A-Z]).*?(\\d+)L");
        int liters = 0;
        while (!userInput.equals("OK KoftiShans")) {
            Matcher matcher = pattern.matcher(userInput);
            while (matcher.find()) {
                String guest = matcher.group(1);
                int quantity = Integer.parseInt(matcher.group(3));
                String drink = matcher.group(2).toLowerCase();
                System.out.printf("%s brought %d liters of %s!\n", guest, quantity, drink);
                liters += quantity;
            }
            userInput = console.nextLine();
        }

        double softUniLiters = liters / 1000d;
        System.out.printf("%.3f softuni liters", softUniLiters);
    }
}
