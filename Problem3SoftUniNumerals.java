import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem3SoftUniNumerals {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String userInput = console.nextLine();
        Pattern pattern = Pattern.compile("(aa|aba|bcc|cc|cdc)");
        Matcher matcher = pattern.matcher(userInput);
        StringBuilder sb = new StringBuilder();

        HashMap<String, String> collection = new HashMap<>();
        collection.put("aa", "0");
        collection.put("aba", "1");
        collection.put("bcc", "2");
        collection.put("cc", "3");
        collection.put("cdc", "4");

        while(matcher.find()){
            sb.append(collection.get(matcher.group()));
        }

        BigInteger result = new BigInteger(sb.toString(), 5);

        System.out.println(result);

    }
}
