import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem1Enigma {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        console.nextLine();
        for (int i = 0; i < n; i++) {
            String lines = console.nextLine();
            String withoutWhitespacesAndNumbers = lines.replaceAll("\\s+\\d*", "");
            int length = withoutWhitespacesAndNumbers.length() / 2;
            for (int j = 0; j < lines.length(); j++) {
                if (Character.isDigit(lines.charAt(j))) {
                    System.out.print(lines.charAt(j));
                } else if (lines.charAt(j) == ' ') {
                    System.out.print(" ");
                } else {
                    int ascii = (int) lines.charAt(j);
                    System.out.print((char) (ascii + length));
                }
            }

            System.out.println();
        }
    }
}

