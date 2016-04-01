import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogsRegex {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String userInput = console.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> collection = new TreeMap<>();

        Pattern pat = Pattern.compile("IP=([\\w.:]+)\\s+message='.*?'\\s+user=(.*)");

        while (!userInput.equals("end")) {
            Matcher matcher = pat.matcher(userInput);
            if (matcher.find()) {
                String ip = matcher.group(1);
                String user = matcher.group(2);

                if (!collection.containsKey(user)) {
                    collection.put(user, new LinkedHashMap<>());
                }

                if (!collection.get(user).containsKey(ip)) {
                    collection.get(user).put(ip, 0);
                }

                int count = 0;
                count = collection.get(user).get(ip);
                collection.get(user).put(ip, count + 1);
            }

            userInput = console.nextLine();
        }

        for (String s : collection.keySet()) {
            System.out.println(s + ":");
            String str = "";
            for (String s1 : collection.get(s).keySet()) {
                str += String.format("%s => %d,\n", s1, collection.get(s).get(s1));
            }
            str = str.substring(0, str.length()-2)+'.';
            System.out.println(str);
        }
    }
}
