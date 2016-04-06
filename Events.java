import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Events {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        console.nextLine();
        TreeMap<String, TreeMap<String, TreeSet<String>>> collection = new TreeMap<>();

        Pattern pat = Pattern.compile("^#([A-Za-z]+):\\s*@([A-Za-z]+)\\s*(([0-1]?[0-9]|[2][0-3]):([0-5][0-9]))$");

        for (int i = 0; i < n; i++) {
            String userInput = console.nextLine();
            Matcher matcher = pat.matcher(userInput);
            if (matcher.find()) {
                String name = matcher.group(1);
                String location = matcher.group(2);
                String times = matcher.group(3);

                if (!collection.containsKey(location)) {
                    collection.put(location, new TreeMap<>());
                }

                if (!collection.get(location).containsKey(name)) {
                    collection.get(location).put(name, new TreeSet<>());
                }

                collection.get(location).get(name).add(times);
            }
        }

        String cityAsInput = console.nextLine();
        String[] arrCityAsInput = cityAsInput.split(",");
        int count = 1;
        for (String s : collection.keySet()) {
            for (int i = 0; i < arrCityAsInput.length; i++) {
                if (s.equals(arrCityAsInput[i])) {
                    System.out.println(s + ":");
                    String str = "";
                    for (String s1 : collection.get(s).keySet()) {
                        str += (String.format("%d. %s -> %s\n", count, s1, collection.get(s).get(s1)));
                        count++;
                    }
                    count = 1;
                    String newString1 = str.substring(0, str.length()-1);

                    String newString2 = newString1.replaceAll("\\[", "");
                    String newString3 = newString2.replaceAll("\\]", "");
                    System.out.println(newString3);
                }
            }
        }
    }
}


