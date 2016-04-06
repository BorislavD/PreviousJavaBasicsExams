import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String userInput = console.nextLine();

        LinkedHashMap<String, HashMap<String, Integer>> collection = new LinkedHashMap<>();

        Pattern pat = Pattern.compile("^(\\D+)\\s@(\\D+)\\s(\\d+)\\s(\\d+)$");

        while (!userInput.equals("End")) {
            Matcher matcher = pat.matcher(userInput);
            if (matcher.find()) {
                String location = matcher.group(2);
                String singer = matcher.group(1);
                int ticketPrice = Integer.parseInt(matcher.group(3));
                int ticketCount = Integer.parseInt(matcher.group(4));

                int totalIncome = ticketPrice * ticketCount;

                if (!collection.containsKey(location)) {
                    collection.put(location, new HashMap<>());
                }

                if (collection.get(location).containsKey(singer)) {
                    collection.get(location).put(singer, collection.get(location).get(singer) + totalIncome);
                } else {
                    collection.get(location).put(singer, totalIncome);
                }
            }

            userInput = console.nextLine();
        }

        for (Map.Entry<String, HashMap<String, Integer>> pair : collection.entrySet()) {
            System.out.println(pair.getKey());
            pair.getValue()
                    .entrySet()
                    .stream()
                    .sorted((el1, el2) -> el2.getValue().compareTo(el1.getValue()))
                    .forEach(innerPair -> {
                        System.out.printf("#  %s - > %d\n", innerPair.getKey(), innerPair.getValue());
                    });
        }
    }
}

